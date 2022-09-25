package co.up.tune.aprv.aprvReq.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.up.tune.aprv.aprvReq.service.AprvReqService;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.FormVO;
import co.up.tune.common.service.CommonService;

@Controller
public class AprvReqController {

	@Autowired
	CommonService cd;
	@Autowired
	AprvReqService ap;

	@GetMapping("/aprvReq")
	public String aprvReq(Model model, HttpServletRequest request) {

		// 사번으로 신청문서, 서식조회
		HttpSession session = request.getSession();
		String empNo = (String) session.getAttribute("empNo");

		AprvVO vo = new AprvVO();
		vo.setEmpNo(empNo);
		
		FormVO frm = new FormVO();
		frm.setEmpNo(empNo);

		List<FormVO> frmlist = ap.formList(frm);
		model.addAttribute("formList", frmlist);
		List<AprvVO> list = ap.aprvReqList(vo);
		model.addAttribute("aprvList", list);

		
		// 공통코드
		model.addAttribute("cd", cd.commonList("신청상태"));
		model.addAttribute("cat", cd.commonList("서식종류"));

		return "aprv/aprvReq/aprvReq";
	}

	@GetMapping("/aprvForm")
	public String aprvForm() {

		return "aprv/aprvReq/aprvForm";
	}

}
