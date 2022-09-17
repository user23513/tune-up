package co.up.tune.emp.hr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HrController {

	@RequestMapping("/empManage")
	public String empManage() {
		return "emp/hr/empManage";
	}
	
	@RequestMapping("/empUpdateForm")
	public String empUpdateForm() {
		return "emp/hr/empUpdateForm";
	}
	
}
