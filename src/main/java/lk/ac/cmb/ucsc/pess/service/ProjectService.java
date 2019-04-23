package lk.ac.cmb.ucsc.pess.service;

import java.util.List;

import lk.ac.cmb.ucsc.pess.dto.ProjectInputDto;
import lk.ac.cmb.ucsc.pess.model.Project;

public interface ProjectService {
	Project save(ProjectInputDto projectInput);
	Project update(long projectId,ProjectInputDto projectInput);
	List<Project> getAll();
	List<Project> getAllActive();
}
