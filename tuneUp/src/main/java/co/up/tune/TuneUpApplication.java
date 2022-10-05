package co.up.tune;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.github.pagehelper.PageInfo;

import co.up.tune.com.notice.service.NoticeService;
import co.up.tune.com.vo.CommunityVO;
import co.up.tune.com.vo.SearchVO;

@SpringBootApplication
@MapperScan(basePackages = "co.up.tune.**.mapper")
@Controller
public class TuneUpApplication {
	
	@Autowired
	NoticeService dao;
	
	public static void main(String[] args) {
		SpringApplication.run(TuneUpApplication.class, args);
	}
	
	@GetMapping("/main")
	public String main(Model model) {
		PageInfo<CommunityVO> p = new PageInfo<>(dao.noticeList(1, new SearchVO()), 5);
		model.addAttribute("nList", p);
		return "main/main";
	}
	
	@GetMapping("/aa")
	public String aa() {return "aa";}
	
	@GetMapping("/chat")
	public String chat() {return "chat";}
	
	@GetMapping("/chart")
	public String chart() {return "chart";}
	
}