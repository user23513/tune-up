package co.up.tune.aprv.aprvAdmin.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import co.up.tune.aprv.approval.service.ApprovalService;
import co.up.tune.aprv.aprvAdmin.service.AprvAdminService;
import co.up.tune.aprv.aprvLine.service.AprvLineService;
import co.up.tune.aprv.vo.ApprovalVO;
import co.up.tune.aprv.vo.AprvLineVO;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.FormVO;
import co.up.tune.common.service.CommonService;

@RestController
public class AjaxAprvAdminController {

	@Autowired
	CommonService cd;
	@Autowired
	AprvAdminService ap;
	@Autowired
	AprvLineService li;
	@Autowired
	ApprovalService as;

	//문서상세
	@PostMapping("/reqAdView")
	public AprvVO aprvAdView(AprvVO vo) {
		return ap.aprvSelect(vo);
	}
	
	//서식상세
	@PostMapping("/formAdView")
	public FormVO formAdView(FormVO vo) {
		return ap.formSelect(vo);
	}
	
	//부서별 결재라인 조회
	@PostMapping("/lineDept")
	public List<AprvLineVO> lineDept(AprvLineVO vo) {
		return li.aprvLineList(vo);
	}
	
	//서식삭제
	@PostMapping("/formAdDel")
	public int formAdDel(FormVO vo) {
		return ap.formAdminDel(vo);
	}
	
	//강제반려처리 결재인+문서
	@PostMapping("/aprvAdRjt")
	public int aprvAdRjt(ApprovalVO vo) {
		return ap.aprvAdReject(vo);
	}
	

}
