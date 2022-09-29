package co.up.tune.aprv.aprvReq.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
	public String aprvReq(AprvVO vo, FormVO frm, Model model, HttpServletRequest request, @RequestParam(required = false, defaultValue = "전체")String formCat, @RequestParam(required = false, defaultValue = "전체")String reqSt, @RequestParam(required = false, defaultValue = "1")int aprvPage, @RequestParam(required = false, defaultValue = "1")int formPage,@RequestParam(required = false, defaultValue = "10")int pageSize) {
		
		//세션 사번
		HttpSession session = request.getSession();
		String empNo = (String) session.getAttribute("empNo");
		
		
		//신청문서
		vo.setEmpNo(empNo);
		vo.setReqSt(reqSt);
		PageHelper.startPage(aprvPage, pageSize);
		model.addAttribute("pageInfo", PageInfo.of(ap.aprvReqList(vo)));

		//서식양식
		frm.setEmpNo(empNo);
		frm.setFormCat(formCat);
		PageHelper.startPage(formPage, pageSize);
		model.addAttribute("Info", PageInfo.of(ap.formList(frm)));
		
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
