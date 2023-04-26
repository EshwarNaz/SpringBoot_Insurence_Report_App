package in.eshwarnaz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.eshwarnaz.entity.CitizenPlan;
import in.eshwarnaz.request.SearchRequest;
import in.eshwarnaz.services.ReportServices;

@Controller
public class ReportController {

	@Autowired
	private ReportServices services;

	@PostMapping("/search")
	public String handleSearch(@ModelAttribute("search") SearchRequest req, Model model) {
		List<CitizenPlan> search = services.search(req);
		model.addAttribute("plans", search);
		init(model);
		return "index";
	}

	@GetMapping("/")
	public String indexPage(Model model) {
		model.addAttribute("search", new SearchRequest());
		init(model);
		return "index";
	}

	private void init(Model model) {

		model.addAttribute("plannames", services.planName());
		model.addAttribute("planstatus", services.planStatus());
	}
}
