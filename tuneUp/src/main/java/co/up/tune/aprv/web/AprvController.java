package co.up.tune.aprv.web;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import co.up.tune.aprvList.service.AprvListService;

@Controller
public class AprvController {
	
	@Autowired
	AprvListService dao;
	
	@GetMapping("/aprvList")
	public String aprvList(Model model, @Param("empNo") String empNo, @Param("aprvSt") String aprvSt) {
		model.addAttribute("aprvList", dao.aprvList(empNo, aprvSt));
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
