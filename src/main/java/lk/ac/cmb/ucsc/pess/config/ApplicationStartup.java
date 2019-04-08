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

	private final String pcUsername = "PESSPC";
	private final String pcPassword = "zaq1xsw2@";

	private final String apcUsername = "PESSAPC";
	private final String apcPassword = "zaq1xsw2@";

	private final String supervisorUsername = "PESSSUPERVISOR";
	private final String supervisorPassword = "zaq1xsw2@";

	private final String studentUsername = "PESSSTUDENT";
	private final String studentPassword = "zaq1xsw2@";

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
			this.userCredentialRepository.save(new UserCredential(1, adminUsername,
					passwordEncoder.encode(adminPassword), UserRole.ADMINISTRATOR, true));
		}

		Optional<UserCredential> pcCredential = this.userCredentialRepository.findByUsername(pcUsername);
		if (!pcCredential.isPresent()) {
			this.userCredentialRepository
					.save(new UserCredential(2, pcUsername, passwordEncoder.encode(pcPassword), UserRole.PC, true));
		}

		Optional<UserCredential> apcCredential = this.userCredentialRepository.findByUsername(apcUsername);
		if (!apcCredential.isPresent()) {
			this.userCredentialRepository
					.save(new UserCredential(3, apcUsername, passwordEncoder.encode(apcPassword), UserRole.APC, true));
		}

		Optional<UserCredential> supervisorCredential = this.userCredentialRepository.findByUsername(supervisorUsername);
		if (!supervisorCredential.isPresent()) {
			this.userCredentialRepository.save(new UserCredential(4, supervisorUsername,
					passwordEncoder.encode(supervisorPassword), UserRole.SUPERVISOR, true));
		}

		Optional<UserCredential> studentCredential = this.userCredentialRepository.findByUsername(studentUsername);
		if (!studentCredential.isPresent()) {
			this.userCredentialRepository.save(new UserCredential(5, studentUsername,
					passwordEncoder.encode(studentPassword), UserRole.STUDENT, true));
		}
	}

}
