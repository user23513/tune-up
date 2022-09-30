package co.up.tune.aprv.approval.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import co.up.tune.aprv.approval.service.ApprovalService;
import co.up.tune.common.service.CommonService;

@Controller
public class ApprovalController {
	
	@Autowired
	CommonService cd;
	@Autowired
	ApprovalService ap;
	
	@GetMapping("/approval")
	public String approval(Model model, HttpServletRequest request, @RequestParam(required = false, defaultValue = "전체") String aprvSt) {	
		//세션사번
		HttpSession session = request.getSession();
		String empNo = (String) session.getAttribute("empNo");
		// 승인문서목록
		model.addAttribute("aprv", ap.approvalList(empNo, aprvSt));
		// 공통코드
		model.addAttribute("st", cd.commonList("승인상태"));
		
		return "aprv/approval/approval";
	}

	
	
	


}
