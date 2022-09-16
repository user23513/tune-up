package co.up.tune;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@MapperScan(basePackages = "co.up.tune.**.mapper")
@Controller
public class TuneUpApplication {

	public static void main(String[] args) {
		SpringApplication.run(TuneUpApplication.class, args);
	}
	
	@GetMapping("/")
	public String main() {
		return "main/main";
	}
	

	@GetMapping("/login")
	public String loginForm() {
		return "member/loginForm";
	}
	
	@GetMapping("/signup")
	public String signUpForm() {
		return "member/signUpForm";
	}
	
	@GetMapping("/myProject")
	public String myProject() {
		return "prj/myProject";
	}
	
	@GetMapping("/prjPost")
	public String testPrj() {
		return "prj/prjPost";
	}
	

}
