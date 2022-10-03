package co.up.tune.aprv.approval.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import co.up.tune.aprv.approval.service.ApprovalService;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.TrustVO;
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

	@PostMapping("/trustDel")
	public int trustDel(TrustVO vo) {
		return ap.trustDel(vo);
	}

}
