package co.up.tune.prj.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectController {

	// 내 프로젝트 목록
	@GetMapping("/myProject")
	public String myProject() {
		return "prj/myProject";
	}

	@GetMapping("/newproject")
	public String newProjectForm() {
		return "member/newProjectForm";
	}
	
	@GetMapping("/file")
	public String attechmentFile() {
		return "file/file";
	}
	

}
