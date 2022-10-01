package co.up.tune.aprv.aprvReq.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import co.up.tune.aprv.aprvReq.service.AprvReqService;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.FormVO;
import co.up.tune.common.service.CommonService;

@RestController
public class AjaxAprvReqController {

	@Autowired
	CommonService cd;
	@Autowired
	AprvReqService ap;
	
	//상세화면
	@PostMapping("/reqView")	
	public AprvVO aprvView(AprvVO vo) {
		return ap.aprvReqSelect(vo);	
		}
	@PostMapping("/formView")	
	public FormVO formView(FormVO vo) {
		return ap.formSelect(vo);	
		}
	
	//상태카테고리
	@PostMapping("/reqSt")	
	public List<AprvVO> reqSt(AprvVO vo, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String empNo = (String) session.getAttribute("empNo");
		vo.setEmpNo(empNo);
		List<AprvVO> data = ap.aprvReqList(vo);	
		return data;
		}
	
	@PostMapping("/formCat")	
	public List<FormVO> formCat(FormVO vo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String empNo = (String) session.getAttribute("empNo");
		vo.setEmpNo(empNo);
		List<FormVO> data = ap.formList(vo);	
		return data;
	
		}
		
		
	

}
