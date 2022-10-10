package co.up.tune.aprv.aprvLine.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import co.up.tune.aprv.aprvLine.service.AprvLineService;
import co.up.tune.aprv.vo.AprvLineVO;
import co.up.tune.emp.vo.EmpVO;

/**
 * 전자결재 결재라인 AjaxController
 * 
 * @author 윤정은
 * @date 2022.09.30
 * @version 1.1
 **/

@RestController
public class AjaxAprvLineController {

	@Autowired
	AprvLineService ls;

	// 결재라인 조회
	@PostMapping("/aprvLineList")
	public List<AprvLineVO> aprvLineList(AprvLineVO vo) {
		return ls.aprvLineList(vo);
	}

	// 사원 조회
	@PostMapping("/aprvEmpList")
	public List<EmpVO> aprvEmpList(EmpVO vo) {
		return ls.aprvEmpList(vo);

	}

	// 결재선 삭제
	@PostMapping("/aprvLineDel")
	public int lineDel(AprvLineVO vo) {
		return ls.aprvLineDel(vo);

	}

	

}
