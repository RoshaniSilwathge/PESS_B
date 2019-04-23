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

import lk.ac.cmb.ucsc.pess.dto.ProjectSubmissionsInputDto;
import lk.ac.cmb.ucsc.pess.service.ProjectSubmissionsService;

@RestController
@RequestMapping("/api/project_submissions")
@CrossOrigin
public class ProjectSubmissionController {

	@Autowired
	private ProjectSubmissionsService projectSubmissionsService;

	@PostMapping("")
	public ResponseEntity<?> saveProjectSubmissions(
			@Valid @RequestBody ProjectSubmissionsInputDto projectSubmissionsInput) {
		return new ResponseEntity<>(projectSubmissionsService.save(projectSubmissionsInput), HttpStatus.CREATED);
	}

	@PutMapping("")
	public ResponseEntity<?> updateProjectSubmissions(
			@Valid @RequestBody ProjectSubmissionsInputDto projectSubmissionsInput) {
		return ResponseEntity.ok(projectSubmissionsService.update(projectSubmissionsInput));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getProjectSubmissionsByProjectId(@PathVariable long id) {
		return ResponseEntity.ok(projectSubmissionsService.getAllByProjectId(id));
	}

}
