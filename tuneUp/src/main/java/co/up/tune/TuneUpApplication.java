package co.up.tune;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	public String main(Model model, HttpServletRequest request) {
		PageInfo<CommunityVO> p = new PageInfo<>(dao.noticeList(1, new SearchVO()), 5);
		AttdVO vo = new AttdVO();
		//세션에서 empNo 받아옴(출근기록)
		HttpSession session =  request.getSession();
		
		vo.setEmpNo((String)session.getAttribute("empNo"));
		
		model.addAttribute("nList", p);
		
		// 당일 출퇴근 기록이 없다면(출근기록)
		model.addAttribute("checkTime", (adao.checkTime(vo) == null || adao.checkTime(vo).getAtdcDttm() == null) ? null : adao.checkTime(vo).getAtdcDttm());
		model.addAttribute("checkBTime", (adao.checkBTime(vo) == null || adao.checkBTime(vo).getAfwkDttm() == null) ? null : adao.checkBTime(vo).getAfwkDttm());
		
		return "main/main";
	}
	
	@GetMapping("/chat")
	public String chat() {return "chat";}
	
}