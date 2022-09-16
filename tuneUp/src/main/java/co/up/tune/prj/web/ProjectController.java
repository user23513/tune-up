package co.up.tune.prj.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ProjectController {
	
	@GetMapping("/prjPost")
	public String prjPost() {
		return "prj/post/prjPost";
	}
}
