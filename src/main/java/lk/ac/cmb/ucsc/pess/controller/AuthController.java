package lk.ac.cmb.ucsc.pess.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ac.cmb.ucsc.pess.dto.ChangeCredentialInputDto;
import lk.ac.cmb.ucsc.pess.dto.LoginInputDto;
import lk.ac.cmb.ucsc.pess.dto.LoginOutputDto;
import lk.ac.cmb.ucsc.pess.dto.PlainResponse;
import lk.ac.cmb.ucsc.pess.model.UserCredential;
import lk.ac.cmb.ucsc.pess.repository.UserCredentialRepository;
import lk.ac.cmb.ucsc.pess.security.JwtTokenProvider;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserCredentialRepository userCredentialRepository;

	@Autowired
	private JwtTokenProvider tokenProvider;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginInputDto loginInputDto) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginInputDto.getUsername(), loginInputDto.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = tokenProvider.generateToken(authentication);
		return ResponseEntity.ok(new LoginOutputDto(jwt));
	}

	@PostMapping("/change/{cId}")
	public ResponseEntity<?> changePassword(@PathVariable long cId,
			@Valid @RequestBody ChangeCredentialInputDto changeCredentialInput) {

		UserCredential userCredential = userCredentialRepository.findById(cId).get();

		if (!passwordEncoder.matches(changeCredentialInput.getCurrentPassword(), userCredential.getPassword())) {
			return new ResponseEntity<>(new PlainResponse("Invalid current password provided"), HttpStatus.BAD_REQUEST);
		}

		userCredential.setPassword(passwordEncoder.encode(changeCredentialInput.getNewPassword()));
		userCredentialRepository.save(userCredential);
		return ResponseEntity.ok(new PlainResponse("Password successfully changed !!!"));
	}
}
