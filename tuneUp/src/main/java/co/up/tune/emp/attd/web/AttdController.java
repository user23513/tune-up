package co.up.tune.emp.attd.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AttdController {
	@GetMapping("/attdList")
	public String attdList() {
		return "emp/attd/attdList";
		
	}
	
}
