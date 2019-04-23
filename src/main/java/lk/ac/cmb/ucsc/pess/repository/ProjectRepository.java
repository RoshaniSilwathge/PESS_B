package lk.ac.cmb.ucsc.pess.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lk.ac.cmb.ucsc.pess.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
	List<Project> findAllByEnabled(boolean enabled);
}
