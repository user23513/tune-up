package co.up.tune.aprv.aprvAdmin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import co.up.tune.aprv.aprvAdmin.service.AprvAdminService;
import co.up.tune.aprv.aprvReq.service.AprvReqService;
import co.up.tune.aprv.vo.ApprovalVO;
import co.up.tune.aprv.vo.AprvVO;

/**
 * 전자결재 관리 AjaxController
 * 
 * @author 윤정은
 * @date 2022.09.27
 * @version 1.1
 **/

@RestController
public class AjaxAprvAdminController {

	@Autowired
	AprvAdminService as;
	@Autowired
	AprvReqService rs;

	// 결재문서 강제삭제
	@PostMapping("/aprvDel")
	public int aprvDel(AprvVO vo) {
		return as.aprvAdminDel(vo);
	}

	// 결재문서 강제반려
	@PostMapping("/aprvAdRjt")
	public int aprvAdRjt(ApprovalVO vo) {
		return as.aprvAdReject(vo);
	}

	// 결재문서 강제승인
	@PostMapping("/aprvAdOk")
	public int aprvAdOk(ApprovalVO vo) {
		return as.aprvAdOk(vo);
	}

}
