package co.up.tune.aprv.approval.web;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import co.up.tune.aprv.approval.service.ApprovalService;
import co.up.tune.aprv.aprvLine.service.AprvLineService;
import co.up.tune.aprv.vo.TrustVO;
import co.up.tune.common.service.CommonService;
import co.up.tune.emp.vo.EmpVO;

/**
* 전자결재 승인 Controller
* @author 윤정은
* @date 2022.10.4
* @version 1.3
**/

@Controller
public class ApprovalController {

	@Autowired
	CommonService cd;
	@Autowired
	ApprovalService ap;
	@Autowired
	AprvLineService ls;
	
	
	//승인페이지
	@GetMapping("/approval")
	public String approval(TrustVO vo, Model model, HttpSession session,
			@RequestParam(required = false, defaultValue = "전체") String aprvSt) {

		String empNo = (String) session.getAttribute("empNo");

		// 승인문서목록
		model.addAttribute("approval", ap.approvalList(empNo, aprvSt));

		vo.setEmpNo(empNo);
		// 내가 위임한 리스트
		model.addAttribute("trust", ap.trustList(vo));
		// 내가 위임 받은 사항이 있는지 확인
		model.addAttribute("rptt", ap.trustCheck(vo));
		// 나의 서명 조회
		EmpVO emp = new EmpVO();
		emp.setEmpNo(empNo);
		model.addAttribute("sign", ap.signSelect(emp));
		
		// 부서조회
		model.addAttribute("dept", ls.aprvDeptList());
		// 공통코드
		model.addAttribute("st", cd.commonList("승인상태"));

		return "aprv/approval/approval";
	}
	
	//위임자 추가
	@PostMapping("/trustIn")
	public String trustIn(TrustVO vo, HttpSession session) {
		
		String empNo = (String) session.getAttribute("empNo");
		String nm = (String) session.getAttribute("nm");
		//내정보등록
		vo.setNm(nm);
		vo.setEmpNo(empNo);
		
		ap.trustIn(vo);
		
		return "redirect:approval";
	
	}

	

}
