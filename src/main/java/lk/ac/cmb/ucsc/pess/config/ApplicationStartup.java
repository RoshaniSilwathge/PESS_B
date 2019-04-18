package lk.ac.cmb.ucsc.pess.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import lk.ac.cmb.ucsc.pess.model.UserCredential;
import lk.ac.cmb.ucsc.pess.model.UserRole;
import lk.ac.cmb.ucsc.pess.repository.UserCredentialRepository;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

	private final String adminUsername = "PESSADMIN";
	private final String adminPassword = "zaq1xsw2@";

	@Autowired
	UserCredentialRepository userCredentialRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event) {
		seedData();
	}

	private void seedData() {
		Optional<UserCredential> adminCredential = this.userCredentialRepository.findByUsername(adminUsername);
		if (!adminCredential.isPresent()) {
			this.userCredentialRepository.save(new UserCredential(adminUsername, passwordEncoder.encode(adminPassword),
					UserRole.ADMINISTRATOR, true));
		}
	}

}
