package lk.ac.cmb.ucsc.pess.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ac.cmb.ucsc.pess.dto.Email;
import lk.ac.cmb.ucsc.pess.service.EmailService;
import lk.ac.cmb.ucsc.pess.utils.EmailUtils;

@RestController
@RequestMapping("/api/sample")
public class SampleController {

	@Autowired
	EmailService emailService;
	
	@GetMapping("/sayHello")
	public String sayHello() {
		emailService.sendHtmlEmail(new Email("PESS user account has been created !!",
				new ArrayList<>(Arrays.asList("ams.amila@gmail.com")), EmailUtils.getUserAccountNotificationEmailBody(
						"amila", "ams.amila@gmail.com", "zaq1xsw2@")));
		return "hello";
	}
}
