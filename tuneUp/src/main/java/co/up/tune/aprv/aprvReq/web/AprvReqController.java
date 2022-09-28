package co.up.tune.aprv.aprvReq.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@RequestMapping("/aprvReq")
	public String aprvReq(AprvVO vo, FormVO frm, Model model, HttpServletRequest request, @RequestParam(required = false, defaultValue = "1")int pageNum, @RequestParam(required = false, defaultValue = "10")int pageSize) {

		//세션사번
		HttpSession session = request.getSession();
		String empNo = (String) session.getAttribute("empNo");
		
		//사번으로 신청문서
		vo.setEmpNo(empNo);
		List<AprvVO> list = ap.aprvReqList(vo);
		model.addAttribute("aprvList", list);

		//사번으로 서식양식
		frm.setEmpNo(empNo);
		List<FormVO> frmlist = ap.formList(frm);
		model.addAttribute("formList", frmlist);
		
		
		// 공통코드
		model.addAttribute("cd", cd.commonList("신청상태"));
		model.addAttribute("cat", cd.commonList("서식종류"));

		PageHelper.startPage(pageNum, pageSize);
		model.addAttribute("pageInfo", PageInfo.of(ap.aprvReqList(vo)));
		return "aprv/aprvReq/aprvReq";
	}

	@GetMapping("/aprvForm")
	public String aprvForm() {

		return "aprv/aprvReq/aprvForm";
	}

}
