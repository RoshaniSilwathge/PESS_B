package lk.ac.cmb.ucsc.pess.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lk.ac.cmb.ucsc.pess.model.Project;
import lk.ac.cmb.ucsc.pess.model.ProjectSubmission;

public interface ProjectSubmissionRepository extends JpaRepository<ProjectSubmission, Long> {
	List<ProjectSubmission> getAllByProject(Project project);
}
