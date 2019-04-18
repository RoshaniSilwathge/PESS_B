package lk.ac.cmb.ucsc.pess.service;

import java.util.List;

import lk.ac.cmb.ucsc.pess.dto.StaffMemberInputDto;
import lk.ac.cmb.ucsc.pess.model.StaffMember;

public interface StaffMemberService {
	StaffMember save(StaffMemberInputDto staffMemberInput);

	StaffMember update(long staffMemberId, StaffMemberInputDto staffMemberInput);

	List<StaffMember> getAll();
}
