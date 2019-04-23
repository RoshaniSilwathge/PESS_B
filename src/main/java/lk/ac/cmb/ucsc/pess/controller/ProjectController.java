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

import lk.ac.cmb.ucsc.pess.dto.ProjectInputDto;
import lk.ac.cmb.ucsc.pess.service.ProjectService;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@PostMapping("")
	public ResponseEntity<?> saveProject(@Valid @RequestBody ProjectInputDto projectInput) {
		return new ResponseEntity<>(projectService.save(projectInput), HttpStatus.CREATED);
	}

	@GetMapping("")
	public ResponseEntity<?> getAllProjects() {
		return ResponseEntity.ok(projectService.getAll());
	}

	@GetMapping("/active")
	public ResponseEntity<?> getAllActiveProjects() {
		return ResponseEntity.ok(projectService.getAllActive());
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateProject(@PathVariable Long id, @Valid @RequestBody ProjectInputDto projectInput) {
		return ResponseEntity.ok(projectService.update(id, projectInput));
	}

}
