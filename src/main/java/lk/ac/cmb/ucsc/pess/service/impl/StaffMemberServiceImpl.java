package lk.ac.cmb.ucsc.pess.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lk.ac.cmb.ucsc.pess.dto.Email;
import lk.ac.cmb.ucsc.pess.dto.StaffMemberInputDto;
import lk.ac.cmb.ucsc.pess.exception.ResourceNotFoundException;
import lk.ac.cmb.ucsc.pess.model.StaffMember;
import lk.ac.cmb.ucsc.pess.model.UserCredential;
import lk.ac.cmb.ucsc.pess.repository.StaffMemberRepository;
import lk.ac.cmb.ucsc.pess.repository.UserCredentialRepository;
import lk.ac.cmb.ucsc.pess.service.EmailService;
import lk.ac.cmb.ucsc.pess.service.StaffMemberService;
import lk.ac.cmb.ucsc.pess.utils.EmailUtils;

@Service
public class StaffMemberServiceImpl implements StaffMemberService {

	@Autowired
	private StaffMemberRepository staffMemberRepository;

	@Autowired
	private UserCredentialRepository userCredentialRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	EmailService emailService;

	@Override
	public StaffMember save(StaffMemberInputDto staffMemberInput) {
		UserCredential userCredential = userCredentialRepository.save(new UserCredential(staffMemberInput.getEmail(),
				passwordEncoder.encode("zaq1xsw2@"), staffMemberInput.getUserRole(), true));

		emailService.sendHtmlEmail(new Email("PESS user account has been created !!",
				Collections.singletonList(staffMemberInput.getEmail()), EmailUtils.getUserAccountNotificationEmailBody(
						staffMemberInput.getName(), staffMemberInput.getEmail(), "zaq1xsw2@")));
		
		return staffMemberRepository.save(new StaffMember(staffMemberInput.getName(), staffMemberInput.getEmail(),
				staffMemberInput.getTelephone(), userCredential));
	}

	@Override
	public List<StaffMember> getAll() {
		return staffMemberRepository.findAll();
	}

	@Override
	public StaffMember update(long staffMemberId, StaffMemberInputDto staffMemberInput) {
		Optional<StaffMember> savedStaffMember = staffMemberRepository.findById(staffMemberId);

		if (!savedStaffMember.isPresent()) {
			throw new ResourceNotFoundException("No Staff Member found for given Id");
		}

		StaffMember savedStaffMemberins = savedStaffMember.get();
		savedStaffMemberins.setName(staffMemberInput.getName());
		savedStaffMemberins.setTelephone(staffMemberInput.getTelephone());
		return staffMemberRepository.save(savedStaffMemberins);
	}

}
