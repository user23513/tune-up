package co.up.tune.aprv.approval.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import co.up.tune.aprv.approval.service.ApprovalService;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.common.service.CommonService;

@RestController
public class AjaxApprovalController {

	@Autowired
	CommonService cd;
	@Autowired
	ApprovalService ap;

	@PostMapping("/approvalView")	
	public AprvVO approvalView(AprvVO vo) {
		
		return ap.approvalSelect(vo);	
		}
	
	@PostMapping("/aprvSt")	
	public List<AprvVO> aprvSt(AprvVO vo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String empNo = (String) session.getAttribute("empNo");
		
		return ap.approvalList(empNo, vo.getAprvSt());	
		}
		
		
	

}
