package co.up.tune.prj.calendar.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalendarController {
	
	//캘린더로 이동
	@GetMapping("/calendar")
	public String calendar() {
		return "prj/calendar/calendar";
	}

}
