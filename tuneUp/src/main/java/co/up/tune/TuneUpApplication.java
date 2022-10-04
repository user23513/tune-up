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
	
	@GetMapping("/main")
	public String main() {
		return "main/main";
	}
	
	@GetMapping("/aa")
	public String aa() {return "aa";}
	
	@GetMapping("/chat")
	public String chat() {return "chat";}
	
	@GetMapping("/chart")
	public String chart() {return "chart";}
	
}