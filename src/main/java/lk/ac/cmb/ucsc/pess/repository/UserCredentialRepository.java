package lk.ac.cmb.ucsc.pess.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import lk.ac.cmb.ucsc.pess.model.UserCredential;

public interface UserCredentialRepository extends JpaRepository<UserCredential, Long> {
	Optional<UserCredential> findByUsername(String username);

	boolean existsByUsername(String username);
}
