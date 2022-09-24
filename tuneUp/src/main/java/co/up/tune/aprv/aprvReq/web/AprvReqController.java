package co.up.tune.aprv.aprvReq.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.up.tune.aprv.aprvReq.service.AprvReqService;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.common.service.CommonService;

@Controller
public class AprvReqController {
	
	@Autowired
	CommonService cd;
	@Autowired
	AprvReqService ap;
	
	
	@GetMapping("/aprvReq")
	public String aprvList(Model model, HttpServletRequest request) {
		
		//사번으로 내 결재 조회
		HttpSession session =  request.getSession();
		String empNo = (String) session.getAttribute("empNo");
		
		
		 AprvVO vo = new AprvVO();
		 vo.setEmpNo(empNo);
		 
		 List<AprvVO> list = ap.aprvList(vo); 
		 model.addAttribute("aprvList", list);
		 
		
		//공통코드
		model.addAttribute("cd", cd.commonList("신청상태"));

	
		return "aprv/aprvReq";
	}
	

	
	
	

}
