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
import co.up.tune.emp.attd.service.AttdService;
import co.up.tune.emp.vo.AttdVO;

@SpringBootApplication
@MapperScan(basePackages = "co.up.tune.**.mapper")
@Controller
public class TuneUpApplication {
	
	@Autowired
	NoticeService dao;
	
	@Autowired
	AttdService adao;
	
	public static void main(String[] args) {
		SpringApplication.run(TuneUpApplication.class, args);
	}
	
	@GetMapping("/main")
	public String main(Model model) {
		AttdVO avo = new AttdVO();
		PageInfo<CommunityVO> p = new PageInfo<>(dao.noticeList(1, new SearchVO()), 5);
		model.addAttribute("nList", p);
		/* 메인화면 출퇴근 띄우기 -> 널포인트 수정하고 주석 풀게영
		model.addAttribute("checkTime", adao.checkTime(avo).getAtdcDttm());
		//메인화면 퇴근시간 띄우기 (퇴근 기록 없으면 메인 오류 뜨는거 수정해야함)
		model.addAttribute("checkBTime", adao.checkBTime(avo).getAfwkDttm());
		*/
		return "main/main";
	}
	
	@GetMapping("/aa")
	public String aa() {return "aa";}
	
	@GetMapping("/chat")
	public String chat() {return "chat";}
	
	@GetMapping("/chart")
	public String chart() {return "chart";}
	
}