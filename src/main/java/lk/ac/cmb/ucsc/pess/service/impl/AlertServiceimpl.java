package lk.ac.cmb.ucsc.pess.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.ac.cmb.ucsc.pess.dto.AlertInputDto;
import lk.ac.cmb.ucsc.pess.model.Alert;
import lk.ac.cmb.ucsc.pess.model.AlertType;
import lk.ac.cmb.ucsc.pess.model.Project;
import lk.ac.cmb.ucsc.pess.repository.AlertRepository;
import lk.ac.cmb.ucsc.pess.repository.ProjectRepository;
import lk.ac.cmb.ucsc.pess.service.AlertService;

@Service
public class AlertServiceimpl implements AlertService {

	@Autowired
	private AlertRepository alertRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public Alert save(AlertInputDto alertInput) {
		Project project = projectRepository.findById(alertInput.getProjectId()).get();
		return alertRepository
				.save(new Alert(alertInput.getTitle(), alertInput.getMessage(), alertInput.getAlertType(), project));
	}

	@Override
	public List<Alert> getAllAnnouncementsForActiveProjects() {
		return alertRepository.findAll().stream()
				.filter(alert -> alert.getAlertType().equals(AlertType.ANNOUNCEMENTS) && alert.getProject().isEnabled())
				.collect(Collectors.toList());
	}

	@Override
	public Alert update(long id, AlertInputDto alertInput) {
		Alert existingAlert = alertRepository.findById(id).get();
		existingAlert.setTitle(alertInput.getTitle());
		existingAlert.setMessage(alertInput.getMessage());
		existingAlert.setAlertType(alertInput.getAlertType());
		return alertRepository.save(existingAlert);
	}

}
