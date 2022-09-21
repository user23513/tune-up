package co.up.tune.aprv.web;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import co.up.tune.aprv.aprvList.service.AprvListService;
import co.up.tune.aprv.aprvr.service.AprvrService;
import co.up.tune.common.service.CommonService;

@Controller
public class AprvController {
	
	@Autowired
	CommonService cd;
	@Autowired
	AprvListService dao1;
	/*
	 * @Autowired AprvrService dao2;
	 */
	
	
	@GetMapping("/aprvList")
	public String aprvList(Model model, HttpServletRequest request) {
		
		//사번으로 내 결재 조회
		String empNo = (String)request.getSession().getAttribute("empNo");
		model.addAttribute("aprvList", dao1.aprvList(empNo));
		
		//공통코드
		model.addAttribute("cd", cd.commonList("결재상태"));
		model.addAttribute("frm", cd.commonList("서식종류"));
	
		return "aprv/aprvList";
	}
	
	@GetMapping("/aprvr")
	public String aprvr(Model model, HttpServletRequest request) {
		
		//사번으로 내 결재 목록 조회
		String empNo = (String)request.getSession().getAttribute("empNo");
		model.addAttribute("aprvr", null);
		//위임자 결재 목록 조회
		
		
		
		//공통코드
		model.addAttribute("cd", cd.commonList("결재상태"));
		
		return "aprv/aprvr";
	}

	@GetMapping("/aprvAdmin")
	public void aprvAdmin(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String auth = (String)request.getSession().getAttribute("auth");
		
		if(auth == "ADMIN") {
			response.sendRedirect("aprv/aprvAdmin");	
		} else {
			
			request.getSession().setAttribute("msg", "관리자가 아닙니다.");
			response.sendRedirect("aprv/aprvList");	
		}

	}

	
	
	

}
