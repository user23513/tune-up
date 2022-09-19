package co.up.tune.com.myPost.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyPostController {

	
	@GetMapping("/mypost")
	public String myPost() {
		return "myPost/myPostView";
	}
}
