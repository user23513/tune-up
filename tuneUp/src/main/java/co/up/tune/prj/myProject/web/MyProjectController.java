package co.up.tune.prj.myProject.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.up.tune.prj.myProject.service.MyProjectService;

@Controller
public class MyProjectController {

	@Autowired
	MyProjectService dao;
	
	// 내 프로젝트 목록
	@PostMapping("/myProject")
	public String myProject(@RequestParam("empNo")int empNo, Model model) {
		model.addAttribute("myPrjList", dao.myPrjList(empNo));
		return "prj/myProject";
	}
}
