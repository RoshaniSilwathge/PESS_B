package lk.ac.cmb.ucsc.pess.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EntityListeners(AuditingEntityListener.class)
public abstract class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long id;

	protected String email;

	protected String telephone;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "credential_id")
	protected UserCredential credentials;

	@CreatedDate
	protected LocalDateTime createdAt;

	@LastModifiedDate
	protected LocalDateTime updatedAt;

	public User() {
		super();
	}

	public User(String email, String telephone, UserCredential credentials) {
		super();
		this.email = email;
		this.telephone = telephone;
		this.credentials = credentials;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	public UserCredential getCredentials() {
		return credentials;
	}
	
	public UserRole getUserRole() {
		return credentials.getUserRole();
	}

	public void setCredentials(UserCredential credentials) {
		this.credentials = credentials;
	}

}
