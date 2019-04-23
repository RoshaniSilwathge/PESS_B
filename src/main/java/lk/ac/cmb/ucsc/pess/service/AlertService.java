package lk.ac.cmb.ucsc.pess.service;

import java.util.List;

import lk.ac.cmb.ucsc.pess.dto.AlertInputDto;
import lk.ac.cmb.ucsc.pess.model.Alert;

public interface AlertService {
	Alert save(AlertInputDto alertInput);

	Alert update(long id, AlertInputDto alertInput);

	List<Alert> getAllAnnouncementsForActiveProjects();
}
