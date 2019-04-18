package lk.ac.cmb.ucsc.pess.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lk.ac.cmb.ucsc.pess.model.UserRole;

public class StaffMemberInputDto {

	@NotBlank
	private String name;

	@NotBlank
	private String email;

	@NotBlank
	private String telephone;

	@NotNull
	private UserRole userRole;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

}
