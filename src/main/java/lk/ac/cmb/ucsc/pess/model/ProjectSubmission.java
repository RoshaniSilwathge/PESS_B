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

	public LocalDateTime getStartDate() {
		return startsAt;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startsAt = startDate;
	}

	public LocalDateTime getEndDate() {
		return endsAt;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endsAt = endDate;
	}

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
