package co.tuneup.prj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@MapperScan(basePackages = "co.tuneup.prj.**.mapper")
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
		return "login/loginForm";
	}

}
