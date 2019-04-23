package lk.ac.cmb.ucsc.pess.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "project_submissions")
@EntityListeners(AuditingEntityListener.class)
public class ProjectSubmission {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String description;

	@Enumerated(EnumType.STRING)
	private ProjectSubmissionType projectSubmissionType;

	private LocalDateTime startsAt;

	private LocalDateTime endsAt;

	@ManyToOne
	@JoinColumn
	private Project project;

	@CreatedDate
	private LocalDateTime createdAt;

	@LastModifiedDate
	private LocalDateTime updatedAt;

	public ProjectSubmission() {
		super();
	}

	public ProjectSubmission(String description, ProjectSubmissionType projectSubmissionType, LocalDateTime startsAt,
			LocalDateTime endsAt, Project project) {
		super();
		this.description = description;
		this.projectSubmissionType = projectSubmissionType;
		this.startsAt = startsAt;
		this.endsAt = endsAt;
		this.project = project;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProjectSubmissionType getProjectSubmissionType() {
		return projectSubmissionType;
	}

	public void setProjectSubmissionType(ProjectSubmissionType projectSubmissionType) {
		this.projectSubmissionType = projectSubmissionType;
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

	@JsonIgnore
	public Project getProject() {
		return project;
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

}
