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

import lk.ac.cmb.ucsc.pess.dto.StudentInputDto;
import lk.ac.cmb.ucsc.pess.service.StudentService;

@RestController
@RequestMapping("/api/students")
@CrossOrigin
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("")
	public ResponseEntity<?> saveStudent(@Valid @RequestBody StudentInputDto studentInput) {
		return new ResponseEntity<>(studentService.save(studentInput), HttpStatus.CREATED);
	}

	@GetMapping("")
	public ResponseEntity<?> getAllStudents() {
		return ResponseEntity.ok(studentService.getAll());
	}

	@GetMapping("/active")
	public ResponseEntity<?> getAllActiveStudents() {
		return ResponseEntity.ok(studentService.getAllActive());
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateStudent(@PathVariable Long id, @Valid @RequestBody StudentInputDto studentInput) {
		return ResponseEntity.ok(studentService.update(id, studentInput));
	}

}
