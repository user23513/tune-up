package co.up.tune.emp.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import co.up.tune.TuneUpApplication;

@SpringBootApplication
@MapperScan(basePackages = "co.up.tune.**.mapper")
@Controller
public class EmpController {
	public static void main(String[] args) {
		SpringApplication.run(TuneUpApplication.class, args);
	}
	
	@GetMapping("/login")
	public String loginForm() {
		return "member/loginForm";
	}
	
	@GetMapping("/signup")
	public String signUpForm() {
		return "member/signUpForm";
	}
	
	@GetMapping("/findid")
	public String findId() {
		return "member/findId";
	}
	
	@GetMapping("/findpassword")
	public String findPassword() {
		return "member/findPassword";
	}
	@GetMapping("/error404")
	public String error404() {
		return "error404";
	}
	
}
