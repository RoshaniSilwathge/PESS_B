package lk.ac.cmb.ucsc.pess.builders;

import org.springframework.mail.SimpleMailMessage;

public class SimpleMailMessageBuilder {
	private String to;
	private String subject;
	private String text;

	public SimpleMailMessageBuilder setTo(String to) {
		this.to = to;
		return this;
	}

	public SimpleMailMessageBuilder setSubject(String subject) {
		this.subject = subject;
		return this;
	}

	public SimpleMailMessageBuilder setText(String text) {
		this.text = text;
		return this;
	}

	public SimpleMailMessage build() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(this.to);
		message.setSubject(this.subject);
		message.setText(this.text);

		return message;
	}
}
