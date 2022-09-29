package co.up.tune.prj.myPrj.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.up.tune.prj.myPrj.service.MyPrjService;
import co.up.tune.prj.vo.ProjectVO;

@Controller
public class MyPrjController {
	@Autowired
	MyPrjService dao;
	
	@GetMapping("/myPrjList")
	public String myPrjList(Model model, ProjectVO vo) {
		model.addAttribute("myPrjList", dao.myPrjList(vo));
		return "prj/myProject";
		
	}
}
