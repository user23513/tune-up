package co.up.tune.aprv.aprvReq.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

	@PostMapping("/reqView")
	public AprvVO aprvView(AprvVO vo) {
		return ap.aprvReqSelect(vo);
	}

	@PostMapping("/formView")
	public FormVO formView(FormVO vo) {
		return ap.formSelect(vo);
	}

	@PostMapping("/lineDeptChange")
	public List<EmpVO> formCat(EmpVO vo) {
		return li.aprvEmpSearch(vo);

	}

	@PostMapping("/lineDel")
	public int lineDel(AprvLineVO vo) {
		return li.aprvLineDel(vo);

	}

}
