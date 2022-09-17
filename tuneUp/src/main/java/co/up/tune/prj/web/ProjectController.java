package co.up.tune.prj.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ProjectController {
	
	@GetMapping("/prjPost")
	public String prjPost() {
		return "prj/post/prjPost";
	}
	

	@GetMapping("newproject")
	public String newProjectForm() {
		return "member/newProjectForm";
	}
	
	@GetMapping("projectform")
	public String ProjectForm() {
		return "prj/businessForm";
	}
}
