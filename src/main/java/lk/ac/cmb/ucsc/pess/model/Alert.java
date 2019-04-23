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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "alerts")
@EntityListeners(AuditingEntityListener.class)
public class Alert {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String title;

	private String message;

	private AlertType alertType;

	@ManyToOne
	@JoinColumn
	private Project project;

	@OneToMany(mappedBy = "alert", cascade = CascadeType.ALL)
	private List<StudentAlertStatus> studentAlertStatus = Collections.emptyList();

	@CreatedDate
	private LocalDateTime createdAt;

	@LastModifiedDate
	private LocalDateTime updatedAt;

	public Alert() {
		super();
	}

	public Alert(String title, String message, AlertType alertType, Project project) {
		super();
		this.title = title;
		this.message = message;
		this.alertType = alertType;
		this.project = project;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public AlertType getAlertType() {
		return alertType;
	}

	public void setAlertType(AlertType alertType) {
		this.alertType = alertType;
	}

	@JsonIgnore
	public Project getProject() {
		return project;
	}

	public long getProjectId() {
		return project.getId();
	}

	public String getProjectName() {
		return project.getName();
	}

	public void setProject(Project project) {
		this.project = project;
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

	@JsonIgnore
	public List<StudentAlertStatus> getStudentAlertStatus() {
		return studentAlertStatus;
	}

	public void setStudentAlertStatus(List<StudentAlertStatus> studentAlertStatus) {
		this.studentAlertStatus = studentAlertStatus;
	}

}
