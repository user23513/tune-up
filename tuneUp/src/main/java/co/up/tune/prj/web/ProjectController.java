package co.up.tune.prj.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectController {


	@GetMapping("/newproject")
	public String newProjectForm() {
		return "prj/newProjectForm";
	}
	
	@GetMapping("/file")
	public String attechmentFile() {
		return "file/file";
	}
	

}
