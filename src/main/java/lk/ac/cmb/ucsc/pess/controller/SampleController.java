package lk.ac.cmb.ucsc.pess.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sample")
public class SampleController {

	@GetMapping("/sayHello")
	public String sayHello() {
		return "hello";
	}
}
