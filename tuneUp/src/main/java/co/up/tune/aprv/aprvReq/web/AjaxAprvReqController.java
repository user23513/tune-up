package co.up.tune.aprv.aprvReq.web;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import co.up.tune.aprv.aprvReq.service.AprvReqService;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.FormVO;

/**
 * 전자결재 신청 AjaxController
 * 
 * @author 윤정은
 * @date 2022.09.22
 * @version 1.2
 **/

@RestController
public class AjaxAprvReqController {

	@Autowired
	AprvReqService rs;


	// 서식 상세
	@PostMapping("/formView")
	public FormVO formView(FormVO vo) {
		return rs.formSelect(vo);
	}

	// 임시 저장
	@PostMapping("/tempAprv")
	public int tempAprv(FormVO vo, HttpSession session) {
		String empNo = (String) session.getAttribute("empNo");
		String nm = (String) session.getAttribute("nm");
		
		vo.setNm(nm);
		vo.setEmpNo(empNo);
		vo.setFormAuth("개인");
		vo.setFormCat("임시저장");
		
		return rs.formIn(vo);
	}

	//서식 삭제
	@PostMapping("/formDel")
	public int formDel(FormVO vo) {
	return rs.formDel(vo);
	}
	
	
	@PostMapping("/aprvShow")
	public AprvVO aprvShow(AprvVO vo) {
	return rs.aprvSelect(vo);
	}
	
}
