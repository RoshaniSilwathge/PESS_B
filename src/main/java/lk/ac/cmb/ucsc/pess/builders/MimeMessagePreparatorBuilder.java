package lk.ac.cmb.ucsc.pess.builders;

import javax.mail.internet.InternetAddress;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

public class MimeMessagePreparatorBuilder {
	private InternetAddress[] to;
	private String subject;
	private String text;

	public MimeMessagePreparatorBuilder setTo(InternetAddress[] to) {
		this.to = to;
		return this;
	}

	public MimeMessagePreparatorBuilder setSubject(String subject) {
		this.subject = subject;
		return this;
	}

	public MimeMessagePreparatorBuilder setText(String text) {
		this.text = text;
		return this;
	}

	public MimeMessagePreparator build() {
		MimeMessagePreparator message = mimeMessage -> {
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
			messageHelper.setTo(this.to);
			messageHelper.setSubject(this.subject);
			messageHelper.setText(this.text, true);
		};

		return message;
	}
}
