package in.eshwarnaz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import in.eshwarnaz.services.ReportServices;

@Controller
public class ReportController {

	@Autowired
	private ReportServices services;

	@GetMapping("/")
	public String indexPage() {
		return "index";
	}
}
