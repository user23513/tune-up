package co.up.tune.aprv.approval.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import co.up.tune.aprv.approval.service.ApprovalService;
import co.up.tune.aprv.aprvLine.service.AprvLineService;
import co.up.tune.aprv.vo.AprvLineVO;
import co.up.tune.aprv.vo.TrustVO;
import co.up.tune.common.service.CommonService;

@Controller
public class ApprovalController {

	@Autowired
	CommonService cd;
	@Autowired
	ApprovalService ap;
	@Autowired
	AprvLineService ls;

	@GetMapping("/approval")
	public String approval(Model model, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "전체") String aprvSt) {
		
		HttpSession session = request.getSession();
		String empNo = (String)session.getAttribute("empNo");
		
		// 승인문서목록
		model.addAttribute("approval", ap.approvalList(empNo, aprvSt));

		// 위임자
		TrustVO vo = new TrustVO();
		vo.setEmpNo(empNo);
		model.addAttribute("trust", ap.trustList(vo));
		model.addAttribute("rptt", ap.trustSelect(vo));
		//부서
		model.addAttribute("dept", ls.aprvDeptSearch());
		// 공통코드
		model.addAttribute("st", cd.commonList("승인상태"));

		return "aprv/approval/approval";
	}
	
	@PostMapping("/trustInsert")
	public String trustIn(TrustVO vo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String empNo = (String)session.getAttribute("empNo");
		vo.setEmpNo(empNo);
		ap.trustIn(vo);
		return "redirect:approval";
	}

	
}
