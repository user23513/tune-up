package co.up.tune.aprv.approval.web;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import co.up.tune.aprv.approval.service.ApprovalService;
import co.up.tune.aprv.aprvLine.service.AprvLineService;
import co.up.tune.aprv.aprvReq.service.AprvReqService;
import co.up.tune.aprv.vo.ApprovalVO;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.ReferVO;
import co.up.tune.aprv.vo.TrustVO;
import co.up.tune.common.service.CommonService;
import co.up.tune.emp.vo.EmpVO;

/**
* 전자결재 승인 Controller
* @author 윤정은
* @date 2022.10.4
* @version 1.4
**/

@Controller
public class ApprovalController {

	@Autowired
	CommonService cd;
	@Autowired
	ApprovalService ap;
	@Autowired
	AprvLineService ls;
	@Autowired
	AprvReqService rs;
	@Value("${file.dir}")
	private String fileDir;
	
	
	//승인페이지
	@GetMapping("/approval")
	public String approval(TrustVO vo, Model model, HttpSession session) {
		String empNo = (String) session.getAttribute("empNo");
		vo.setEmpNo(empNo);
		
		// 승인문서목록
		model.addAttribute("approval", ap.approvalList(empNo, "진행"));
		// 참조문서목록
		model.addAttribute("refer", ap.approvalList(empNo, "참조"));
		
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
	
	//승인문서상세
	@PostMapping("/approvalView")
	public String approvalView(AprvVO vo, Model model) {
		int aprvNo = vo.getAprvNo();
		ApprovalVO avo = new ApprovalVO();
		avo.setAprvNo(aprvNo);
		ReferVO rvo = new ReferVO();
		rvo.setAprvNo(aprvNo);
		
		model.addAttribute("aprv", rs.aprvSelect(vo));
		model.addAttribute("approval", ls.aprvrList(avo));
		model.addAttribute("refer", ls.referList(rvo));
		
		return "/aprv/approval/approvalView";
	}

	

}
