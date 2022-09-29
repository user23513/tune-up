package co.up.tune.prj.schedule.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ScheduleController {

	@PostMapping("/scheduleInsert")
	public String scheduleInsert() {
		return "";
	}
	
}
