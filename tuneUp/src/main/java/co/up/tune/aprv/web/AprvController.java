package co.up.tune.aprv.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import co.up.tune.aprv.aprvList.service.AprvListService;
import co.up.tune.aprv.aprvr.service.AprvrService;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.common.service.CommonService;

@Controller
public class AprvController {
	
	@Autowired
	CommonService cd;
	@Autowired
	AprvListService apList;
	@Autowired
	AprvrService aprvr;
	
	
	@GetMapping("/aprvList")
	public String aprvList(Model model, HttpServletRequest request) {
		
		//사번으로 내 결재 조회
		HttpSession session =  request.getSession();
		String empNo = (String) session.getAttribute("empNo");
		
		AprvVO vo = new AprvVO();
		vo.setEmpNo(empNo);
		
	
		List<AprvVO> list = apList.aprvList(vo);
		model.addAttribute("aprvList", list);
		
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
	public String aprvAdmin(Model model, HttpServletRequest request) throws IOException {
		
		HttpSession session =  request.getSession();
		String auth = (String) session.getAttribute("auth");
		
		if(auth == "ADMIN") {
			return "aprv/aprvAdmin";	
		
		} else {
			
			model.addAttribute("msg", "관리자가 아닙니다.");
			return "main/main";	
		}

	}

	
	
	

}
