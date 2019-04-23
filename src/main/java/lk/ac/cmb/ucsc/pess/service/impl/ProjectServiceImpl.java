package lk.ac.cmb.ucsc.pess.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.ac.cmb.ucsc.pess.dto.ProjectInputDto;
import lk.ac.cmb.ucsc.pess.exception.ResourceNotFoundException;
import lk.ac.cmb.ucsc.pess.model.Project;
import lk.ac.cmb.ucsc.pess.repository.ProjectRepository;
import lk.ac.cmb.ucsc.pess.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public Project save(ProjectInputDto projectInput) {
		return projectRepository
				.save(new Project(projectInput.getName(), projectInput.getStartsAt(), projectInput.getEndsAt(), true));
	}

	@Override
	public List<Project> getAll() {
		return projectRepository.findAll();
	}

	@Override
	public Project update(long projectId, ProjectInputDto projectInput) {
		Optional<Project> savedProject = projectRepository.findById(projectId);

		if (!savedProject.isPresent()) {
			throw new ResourceNotFoundException("No project found for given Id");
		}

		Project savedProjectins = savedProject.get();
		savedProjectins.setName(projectInput.getName());
		savedProjectins.setStartsAt(projectInput.getStartsAt());
		savedProjectins.setEndsAt(projectInput.getEndsAt());
		
		return projectRepository.save(savedProjectins);
	}

	@Override
	public List<Project> getAllActive() {
		return projectRepository.findAllByEnabled(true);
	}

}
