package co.up.tune.prj.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.up.tune.prj.propost.service.PropostService;

@Controller
public class ProjectController {

	@Autowired
	PropostService dao;

	@GetMapping("/newproject")
	public String newProjectForm(Model model) {
		model.addAttribute("empList", dao.empList());
		return "prj/newProject";
	}
	
	@GetMapping("/file")
	public String attechmentFile() {
		return "file/file";
	}
	

}
