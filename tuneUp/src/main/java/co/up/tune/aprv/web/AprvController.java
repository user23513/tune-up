package co.up.tune.aprv.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import co.up.tune.aprvList.service.AprvListService;
import co.up.tune.common.service.CommonService;

@Controller
public class AprvController {
	
	@Autowired
	CommonService cd;
	@Autowired
	AprvListService dao;
	
	@GetMapping("/aprvList")
	public String aprvList(Model model) {
		
		String empNo = null;
		
		model.addAttribute("cd", cd.commonList("결재상태"));
		model.addAttribute("aprvList", dao.aprvList(empNo));
	
		return "aprv/aprvList";
	}
	
	@GetMapping("/aprvr")
	public String aprvr() {
		return "aprv/aprvr";
	}

	@GetMapping("/aprvAdmin")
	public String aprvAdmin() {
		return "aprv/aprvAdmin";
	}

	
	
	

}
