package lk.ac.cmb.ucsc.pess.dto;

import java.util.List;

public class Email {

	private String subject;

	private List<String> recievers;

	private String body;

	public Email(String subject, List<String> recievers, String body) {
		super();
		this.subject = subject;
		this.recievers = recievers;
		this.body = body;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<String> getRecievers() {
		return recievers;
	}

	public void setRecievers(List<String> recievers) {
		this.recievers = recievers;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
