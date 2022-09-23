package co.up.tune.file.myfile.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyFileController {
	@GetMapping("/files")
		public String files() {
			return "file/file";
		}
	
}
