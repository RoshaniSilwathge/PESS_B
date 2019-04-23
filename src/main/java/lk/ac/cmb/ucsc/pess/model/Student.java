package lk.ac.cmb.ucsc.pess.model;

import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "students")
public class Student extends User {
	private String regNo;

	private String indexNo;

	private String nic;

	private String fullName;

	private String initials;

	private String surname;

	private String supervisorId;

	@ManyToOne
	@JoinColumn
	private Project project;

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private List<StudentAlertStatus> studentAlertStatus = Collections.emptyList();

	public Student() {
		super();
	}

	public Student(String email, String telephone, UserCredential credentials, String regNo, String indexNo, String nic,
			String fullName, String initials, String surname, Project project) {
		super(email, telephone, credentials);

		this.regNo = regNo;
		this.indexNo = indexNo;
		this.nic = nic;
		this.fullName = fullName;
		this.initials = initials;
		this.surname = surname;
		this.project = project;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getIndexNo() {
		return indexNo;
	}

	public void setIndexNo(String indexNo) {
		this.indexNo = indexNo;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSupervisorId() {
		return supervisorId;
	}

	public void setSupervisorId(String supervisorId) {
		this.supervisorId = supervisorId;
	}

	@JsonIgnore
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public long getProjectId() {
		return project.getId();
	}

	public String getProjectName() {
		return project.getName();
	}

	@JsonIgnore
	public List<StudentAlertStatus> getStudentAlertStatus() {
		return studentAlertStatus;
	}

	public void setStudentAlertStatus(List<StudentAlertStatus> studentAlertStatus) {
		this.studentAlertStatus = studentAlertStatus;
	}

}
