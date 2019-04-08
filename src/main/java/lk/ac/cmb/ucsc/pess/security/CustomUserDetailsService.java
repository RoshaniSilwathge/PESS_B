package lk.ac.cmb.ucsc.pess.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lk.ac.cmb.ucsc.pess.exception.ResourceNotFoundException;
import lk.ac.cmb.ucsc.pess.model.UserCredential;
import lk.ac.cmb.ucsc.pess.repository.UserCredentialRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserCredentialRepository userCredentialRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserCredential userCredential = userCredentialRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with username : " + username));

		return UserPrincipal.create(userCredential);
	}

	@Transactional
	public UserDetails loadUserCredentialsById(long id) {
		UserCredential userCredential = userCredentialRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
		return UserPrincipal.create(userCredential);
	}

}
