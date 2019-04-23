package lk.ac.cmb.ucsc.pess.service;

import java.util.List;

import lk.ac.cmb.ucsc.pess.dto.ProjectSubmissionsInputDto;
import lk.ac.cmb.ucsc.pess.model.ProjectSubmission;

public interface ProjectSubmissionsService {
	List<ProjectSubmission> save(ProjectSubmissionsInputDto projectSubmissionsInput);
	List<ProjectSubmission> update(ProjectSubmissionsInputDto projectSubmissionsInput);
	List<ProjectSubmission> getAllByProjectId(long projectId);
}
