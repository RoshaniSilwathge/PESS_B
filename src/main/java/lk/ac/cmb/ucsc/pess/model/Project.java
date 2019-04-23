package lk.ac.cmb.ucsc.pess.model;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "projects")
@EntityListeners(AuditingEntityListener.class)
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;

	private LocalDateTime startsAt;

	private LocalDateTime endsAt;

	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
	private List<ProjectSubmission> projectSubmissions = Collections.emptyList();

	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
	private List<Student> students = Collections.emptyList();

	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
	private List<Alert> alerts = Collections.emptyList();

	@CreatedDate
	private LocalDateTime createdAt;

	@LastModifiedDate
	private LocalDateTime updatedAt;

	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean enabled;

	public Project() {
		super();
	}

	public Project(String name, LocalDateTime startsAt, LocalDateTime endsAt, boolean enabled) {
		super();
		this.name = name;
		this.startsAt = startsAt;
		this.endsAt = endsAt;
		this.enabled = enabled;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public List<ProjectSubmission> getProjectSubmissions() {
		return projectSubmissions;
	}

	public void setProjectSubmissions(List<ProjectSubmission> projectSubmissions) {
		this.projectSubmissions = projectSubmissions;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public LocalDateTime getStartsAt() {
		return startsAt;
	}

	public void setStartsAt(LocalDateTime startsAt) {
		this.startsAt = startsAt;
	}

	public LocalDateTime getEndsAt() {
		return endsAt;
	}

	public void setEndsAt(LocalDateTime endsAt) {
		this.endsAt = endsAt;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@JsonIgnore
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@JsonIgnore
	public List<Alert> getAlerts() {
		return alerts;
	}

	public void setAlerts(List<Alert> alerts) {
		this.alerts = alerts;
	}

}
