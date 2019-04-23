package lk.ac.cmb.ucsc.pess.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ac.cmb.ucsc.pess.dto.AlertInputDto;
import lk.ac.cmb.ucsc.pess.service.AlertService;

@RestController
@RequestMapping("/api/alerts")
@CrossOrigin
public class AlertController {

	@Autowired
	private AlertService alertService;

	@PostMapping("")
	public ResponseEntity<?> saveAlert(@Valid @RequestBody AlertInputDto alertInput) {
		return new ResponseEntity<>(alertService.save(alertInput), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateAlert(@PathVariable long id, @Valid @RequestBody AlertInputDto alertInput) {
		return ResponseEntity.ok(alertService.update(id, alertInput));
	}

	@GetMapping("/announcements")
	public ResponseEntity<?> getAllAnnouncementsForActiveProjects() {
		return ResponseEntity.ok(alertService.getAllAnnouncementsForActiveProjects());
	}

}
