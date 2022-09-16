package co.up.tune.emp.mypage.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyPageContoller {
	
	@RequestMapping("/pwCheck")
	public String pwCheck() {
		return "emp/myPage/pwCheck";
	}
	
	@RequestMapping("/profile")
	public String profile() {
		return "emp/myPage/profile";
	}
	
	@RequestMapping("/profileForm")
	public String profileForm() {
		return "emp/myPage/profileForm";
	}
}
