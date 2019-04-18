package lk.ac.cmb.ucsc.pess.model;

import javax.persistence.Entity;

@Entity(name = "staff_members")
public class StaffMember extends User {

	private String name;

	public StaffMember() {
		super();
	}

	public StaffMember(String name, String email, String telephone, UserCredential credentials) {
		super(email, telephone, credentials);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
