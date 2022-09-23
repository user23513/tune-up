package co.up.tune.emp.web;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import co.up.tune.TuneUpApplication;
import co.up.tune.emp.vo.EmpVO;

@SpringBootApplication
@MapperScan(basePackages = "co.up.tune.**.mapper")
@Controller
public class EmpController {
	public static void main(String[] args) {
		SpringApplication.run(TuneUpApplication.class, args);
	}
	
	//로그인
	@GetMapping("/login")
	public String loginForm() {
		return "member/loginForm";
	}
	//회원가입 폼
	@GetMapping("/signupform")
	public String signUpForm(EmpVO vo) {
		return "member/signUpForm";
	}
	//회원가입하면 로그인폼으로 
	@PostMapping("/signup")
	public String signUp() {
		return "member/loginForm";
	}
	//아이디 찾기
	@GetMapping("/findid")
	public String findId() throws Exception{
		return "member/findId";
	}
	//비밀번호 찾기
	@GetMapping("/findpassword")
	public String findPassword() {
		return "member/findPassword";
	}
	//에러페이지
	@GetMapping("/error404")
	public String error404() {
		return "error404";
	}
	
}
