package lk.ac.cmb.ucsc.pess.service;

import lk.ac.cmb.ucsc.pess.dto.Email;

public interface EmailService {
	void sendPlainEmail(Email email);

	void sendHtmlEmail(Email email);
}
