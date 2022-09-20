package co.up.tune.emp.attd.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import co.up.tune.emp.attd.service.AttdService;
@Controller
public class AttdController {
	@Autowired
	AttdService dao;
	
	@GetMapping("/attdUpForm")
	public String attdUpForm() {
		return "emp/attd/attdUpForm";
	}
	
	@GetMapping("/attdList")
	public String attdList() {
		return "emp/attd/attdList";
	}
}
