package lk.ac.cmb.ucsc.pess.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.ac.cmb.ucsc.pess.dto.ProjectSubmissionsInputDto;
import lk.ac.cmb.ucsc.pess.model.Project;
import lk.ac.cmb.ucsc.pess.model.ProjectSubmission;
import lk.ac.cmb.ucsc.pess.model.ProjectSubmissionType;
import lk.ac.cmb.ucsc.pess.repository.ProjectRepository;
import lk.ac.cmb.ucsc.pess.repository.ProjectSubmissionRepository;
import lk.ac.cmb.ucsc.pess.service.ProjectSubmissionsService;

@Service
public class ProjectSubmissionsServiceImpl implements ProjectSubmissionsService {

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private ProjectSubmissionRepository projectSubmissionRepository;

	@Override
	public List<ProjectSubmission> save(ProjectSubmissionsInputDto projectSubmissionsInput) {

		Project project = projectRepository.findById(projectSubmissionsInput.getProjectId()).get();
		List<ProjectSubmission> projectSubmissions = new ArrayList<>();

		ProjectSubmission apSubmission = new ProjectSubmission(projectSubmissionsInput.getApdescription(),
				ProjectSubmissionType.ADD_PROJECT, projectSubmissionsInput.getApstartsAt(),
				projectSubmissionsInput.getApendsAt(), project);

		ProjectSubmission spSubmission = new ProjectSubmission(projectSubmissionsInput.getSpdescription(),
				ProjectSubmissionType.ADD_SUPERVISOR, projectSubmissionsInput.getSpstartsAt(),
				projectSubmissionsInput.getSpendsAt(), project);

		ProjectSubmission clSubmission = new ProjectSubmission(projectSubmissionsInput.getCldescription(),
				ProjectSubmissionType.ADD_CLIENT, projectSubmissionsInput.getClstartsAt(),
				projectSubmissionsInput.getClendsAt(), project);

		ProjectSubmission pr1Submission = new ProjectSubmission(projectSubmissionsInput.getPr1description(),
				ProjectSubmissionType.PROGRESS_REPORT_1, projectSubmissionsInput.getPr1startsAt(),
				projectSubmissionsInput.getPr1endsAt(), project);

		ProjectSubmission pr2Submission = new ProjectSubmission(projectSubmissionsInput.getPr2description(),
				ProjectSubmissionType.PROGRESS_REPORT_2, projectSubmissionsInput.getPr2startsAt(),
				projectSubmissionsInput.getPr2endsAt(), project);

		ProjectSubmission pr3Submission = new ProjectSubmission(projectSubmissionsInput.getPr3description(),
				ProjectSubmissionType.PROGRESS_REPORT_3, projectSubmissionsInput.getPr3startsAt(),
				projectSubmissionsInput.getPr3endsAt(), project);

		ProjectSubmission pr4Submission = new ProjectSubmission(projectSubmissionsInput.getPr4description(),
				ProjectSubmissionType.PROGRESS_REPORT_4, projectSubmissionsInput.getPr4startsAt(),
				projectSubmissionsInput.getPr4endsAt(), project);

		ProjectSubmission pr5Submission = new ProjectSubmission(projectSubmissionsInput.getPr5description(),
				ProjectSubmissionType.PROGRESS_REPORT_5, projectSubmissionsInput.getPr5startsAt(),
				projectSubmissionsInput.getPr5endsAt(), project);

		ProjectSubmission pr6Submission = new ProjectSubmission(projectSubmissionsInput.getPr6description(),
				ProjectSubmissionType.PROGRESS_REPORT_6, projectSubmissionsInput.getPr6startsAt(),
				projectSubmissionsInput.getPr6endsAt(), project);

		ProjectSubmission pr7Submission = new ProjectSubmission(projectSubmissionsInput.getPr7description(),
				ProjectSubmissionType.PROGRESS_REPORT_7, projectSubmissionsInput.getPr7startsAt(),
				projectSubmissionsInput.getPr7endsAt(), project);

		ProjectSubmission pr8Submission = new ProjectSubmission(projectSubmissionsInput.getPr8description(),
				ProjectSubmissionType.PROGRESS_REPORT_8, projectSubmissionsInput.getPr8startsAt(),
				projectSubmissionsInput.getPr8endsAt(), project);

		ProjectSubmission pr9Submission = new ProjectSubmission(projectSubmissionsInput.getPr9description(),
				ProjectSubmissionType.PROGRESS_REPORT_9, projectSubmissionsInput.getPr9startsAt(),
				projectSubmissionsInput.getPr9endsAt(), project);

		ProjectSubmission pr10Submission = new ProjectSubmission(projectSubmissionsInput.getPr10description(),
				ProjectSubmissionType.PROGRESS_REPORT_10, projectSubmissionsInput.getPr10startsAt(),
				projectSubmissionsInput.getPr10endsAt(), project);

		ProjectSubmission intSubmission = new ProjectSubmission(projectSubmissionsInput.getIntdescription(),
				ProjectSubmissionType.INTEREEM, projectSubmissionsInput.getIntstartsAt(),
				projectSubmissionsInput.getIntendsAt(), project);

		ProjectSubmission vivSubmission = new ProjectSubmission(projectSubmissionsInput.getVivdescription(),
				ProjectSubmissionType.VIVA, projectSubmissionsInput.getVivstartsAt(),
				projectSubmissionsInput.getVivendsAt(), project);

		projectSubmissions.add(apSubmission);
		projectSubmissions.add(spSubmission);
		projectSubmissions.add(clSubmission);
		projectSubmissions.add(pr1Submission);
		projectSubmissions.add(pr2Submission);
		projectSubmissions.add(pr3Submission);
		projectSubmissions.add(pr4Submission);
		projectSubmissions.add(pr5Submission);
		projectSubmissions.add(pr6Submission);
		projectSubmissions.add(pr7Submission);
		projectSubmissions.add(pr8Submission);
		projectSubmissions.add(pr9Submission);
		projectSubmissions.add(pr10Submission);
		projectSubmissions.add(intSubmission);
		projectSubmissions.add(vivSubmission);

		return projectSubmissionRepository.saveAll(projectSubmissions);
	}

	@Override
	public List<ProjectSubmission> getAllByProjectId(long projectId) {
		return projectSubmissionRepository.getAllByProject(projectRepository.findById(projectId).get());
	}

	@Override
	public List<ProjectSubmission> update(ProjectSubmissionsInputDto projectSubmissionsInput) {
		Project project = projectRepository.findById(projectSubmissionsInput.getProjectId()).get();
		List<ProjectSubmission> existingProjectSubmissions = projectSubmissionRepository.getAllByProject(project);

		List<ProjectSubmission> projectSubmissionsToUpdate = existingProjectSubmissions.stream()
				.map(projectSubmission -> {
					switch (projectSubmission.getProjectSubmissionType()) {
					case ADD_PROJECT: {
						projectSubmission.setDescription(projectSubmissionsInput.getApdescription());
						projectSubmission.setStartsAt(projectSubmissionsInput.getApstartsAt());
						projectSubmission.setEndsAt(projectSubmissionsInput.getApendsAt());
						return projectSubmission;
					}
					case ADD_SUPERVISOR: {
						projectSubmission.setDescription(projectSubmissionsInput.getSpdescription());
						projectSubmission.setStartsAt(projectSubmissionsInput.getSpstartsAt());
						projectSubmission.setEndsAt(projectSubmissionsInput.getSpendsAt());
						return projectSubmission;
					}
					case ADD_CLIENT: {
						projectSubmission.setDescription(projectSubmissionsInput.getCldescription());
						projectSubmission.setStartsAt(projectSubmissionsInput.getClstartsAt());
						projectSubmission.setEndsAt(projectSubmissionsInput.getClendsAt());
						return projectSubmission;
					}
					case PROGRESS_REPORT_1: {
						projectSubmission.setDescription(projectSubmissionsInput.getPr1description());
						projectSubmission.setStartsAt(projectSubmissionsInput.getPr1startsAt());
						projectSubmission.setEndsAt(projectSubmissionsInput.getPr1endsAt());
						return projectSubmission;
					}
					case PROGRESS_REPORT_2: {
						projectSubmission.setDescription(projectSubmissionsInput.getPr2description());
						projectSubmission.setStartsAt(projectSubmissionsInput.getPr2startsAt());
						projectSubmission.setEndsAt(projectSubmissionsInput.getPr2endsAt());
						return projectSubmission;
					}
					case PROGRESS_REPORT_3: {
						projectSubmission.setDescription(projectSubmissionsInput.getPr3description());
						projectSubmission.setStartsAt(projectSubmissionsInput.getPr3startsAt());
						projectSubmission.setEndsAt(projectSubmissionsInput.getPr3endsAt());
						return projectSubmission;
					}
					case PROGRESS_REPORT_4: {
						projectSubmission.setDescription(projectSubmissionsInput.getPr4description());
						projectSubmission.setStartsAt(projectSubmissionsInput.getPr4startsAt());
						projectSubmission.setEndsAt(projectSubmissionsInput.getPr4endsAt());
						return projectSubmission;
					}
					case PROGRESS_REPORT_5: {
						projectSubmission.setDescription(projectSubmissionsInput.getPr5description());
						projectSubmission.setStartsAt(projectSubmissionsInput.getPr5startsAt());
						projectSubmission.setEndsAt(projectSubmissionsInput.getPr5endsAt());
						return projectSubmission;
					}
					case PROGRESS_REPORT_6: {
						projectSubmission.setDescription(projectSubmissionsInput.getPr6description());
						projectSubmission.setStartsAt(projectSubmissionsInput.getPr6startsAt());
						projectSubmission.setEndsAt(projectSubmissionsInput.getPr6endsAt());
						return projectSubmission;
					}
					case PROGRESS_REPORT_7: {
						projectSubmission.setDescription(projectSubmissionsInput.getPr7description());
						projectSubmission.setStartsAt(projectSubmissionsInput.getPr7startsAt());
						projectSubmission.setEndsAt(projectSubmissionsInput.getPr7endsAt());
						return projectSubmission;
					}
					case PROGRESS_REPORT_8: {
						projectSubmission.setDescription(projectSubmissionsInput.getPr8description());
						projectSubmission.setStartsAt(projectSubmissionsInput.getPr8startsAt());
						projectSubmission.setEndsAt(projectSubmissionsInput.getPr8endsAt());
						return projectSubmission;
					}
					case PROGRESS_REPORT_9: {
						projectSubmission.setDescription(projectSubmissionsInput.getPr9description());
						projectSubmission.setStartsAt(projectSubmissionsInput.getPr9startsAt());
						projectSubmission.setEndsAt(projectSubmissionsInput.getPr9endsAt());
						return projectSubmission;
					}
					case PROGRESS_REPORT_10: {
						projectSubmission.setDescription(projectSubmissionsInput.getPr10description());
						projectSubmission.setStartsAt(projectSubmissionsInput.getPr10startsAt());
						projectSubmission.setEndsAt(projectSubmissionsInput.getPr10endsAt());
						return projectSubmission;
					}
					case INTEREEM: {
						projectSubmission.setDescription(projectSubmissionsInput.getIntdescription());
						projectSubmission.setStartsAt(projectSubmissionsInput.getIntstartsAt());
						projectSubmission.setEndsAt(projectSubmissionsInput.getIntendsAt());
						return projectSubmission;
					}
					case VIVA: {
						projectSubmission.setDescription(projectSubmissionsInput.getVivdescription());
						projectSubmission.setStartsAt(projectSubmissionsInput.getVivstartsAt());
						projectSubmission.setEndsAt(projectSubmissionsInput.getVivendsAt());
						return projectSubmission;
					}

					}
					return projectSubmission;
				}).collect(Collectors.toList());

		return projectSubmissionRepository.saveAll(projectSubmissionsToUpdate);
	}

}
