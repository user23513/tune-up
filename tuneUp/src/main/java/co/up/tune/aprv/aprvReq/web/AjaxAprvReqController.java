package co.up.tune.aprv.aprvReq.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import co.up.tune.aprv.aprvLine.service.AprvLineService;
import co.up.tune.aprv.aprvReq.service.AprvReqService;
import co.up.tune.aprv.vo.AprvLineVO;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.FormVO;
import co.up.tune.common.service.CommonService;
import co.up.tune.emp.vo.EmpVO;

@RestController
public class AjaxAprvReqController {

	@Autowired
	CommonService cd;
	@Autowired
	AprvReqService ap;
	@Autowired
	AprvLineService li;

	// 문서 상세
	@PostMapping("/reqView")
	public AprvVO aprvView(AprvVO vo) {
		return ap.aprvReqSelect(vo);
	}

	// 서식 상세
	@PostMapping("/formView")
	public FormVO formView(FormVO vo) {
		return ap.formSelect(vo);
	}

	// 결재선 부서 조회
	@PostMapping("/lineDeptChange")
	public List<EmpVO> formCat(EmpVO vo) {
		return li.aprvEmpSearch(vo);

	}

	// 결재선 삭제
	@PostMapping("/lineDel")
	public int lineDel(AprvLineVO vo) {
		return li.aprvLineDel(vo);

	}



}
