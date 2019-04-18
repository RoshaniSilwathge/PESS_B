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

import lk.ac.cmb.ucsc.pess.dto.StaffMemberInputDto;
import lk.ac.cmb.ucsc.pess.service.StaffMemberService;

@RestController
@RequestMapping("/api/staff_members")
@CrossOrigin
public class StaffMemberController {

	@Autowired
	private StaffMemberService staffMemberService;

	@PostMapping("")
	public ResponseEntity<?> saveStaffMember(@Valid @RequestBody StaffMemberInputDto staffMemberInput) {
		return new ResponseEntity<>(staffMemberService.save(staffMemberInput), HttpStatus.CREATED);
	}

	@GetMapping("")
	public ResponseEntity<?> getAllStaffMembers() {
		return ResponseEntity.ok(staffMemberService.getAll());
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateStaffMember(@PathVariable Long id,
			@Valid @RequestBody StaffMemberInputDto staffMemberInput) {
		return ResponseEntity.ok(staffMemberService.update(id, staffMemberInput));
	}

}
