package lk.ac.cmb.ucsc.pess.service.impl;

import javax.mail.internet.InternetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lk.ac.cmb.ucsc.pess.builders.MimeMessagePreparatorBuilder;
import lk.ac.cmb.ucsc.pess.builders.SimpleMailMessageBuilder;
import lk.ac.cmb.ucsc.pess.dto.Email;
import lk.ac.cmb.ucsc.pess.service.EmailService;
@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	@Async
	public void sendPlainEmail(Email email) {
		email.getRecievers().stream().forEach(receiver -> {
			javaMailSender.send(new SimpleMailMessageBuilder().setTo(receiver).setSubject(email.getSubject())
					.setText(email.getBody()).build());
		});
	}

	@Override
	@Async
	public void sendHtmlEmail(Email email) {
		email.getRecievers().stream().forEach(receiver -> {
			try {
				javaMailSender.send(new MimeMessagePreparatorBuilder().setTo(InternetAddress.parse(receiver))
						.setSubject(email.getSubject()).setText(email.getBody()).build());
			} catch (Exception e) {
				throw new RuntimeException();
			}
		});
	}

}
