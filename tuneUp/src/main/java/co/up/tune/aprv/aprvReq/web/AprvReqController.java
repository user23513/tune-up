package co.up.tune.aprv.aprvReq.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import co.up.tune.aprv.aprvLine.service.AprvLineService;
import co.up.tune.aprv.aprvReq.service.AprvReqService;
import co.up.tune.aprv.vo.AprvLineVO;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.FormVO;
import co.up.tune.com.vo.CommunityVO;
import co.up.tune.common.service.CommonService;
import co.up.tune.emp.vo.EmpVO;
import co.up.tune.file.service.FileService;
import co.up.tune.prj.vo.FilesVO;

@Controller
public class AprvReqController {

	@Autowired
	CommonService cd;
	@Autowired
	AprvReqService ap;
	@Autowired
	AprvLineService li;
	
	
	@GetMapping("/aprvReq")
	public String aprvReq(Model model, HttpServletRequest request, @RequestParam(required = false, defaultValue = "전체")String reqSt, @RequestParam(required = false, defaultValue = "전체")String formCat) {
		
		//세션 사번
		HttpSession session = request.getSession();
		String empNo = (String) session.getAttribute("empNo");
		String dept = (String) session.getAttribute("dept");
		
		//신청문서
		AprvVO vo = new AprvVO();
		vo.setEmpNo(empNo);
		vo.setReqSt(reqSt);
		model.addAttribute("aprv", ap.aprvReqList(vo));

		//서식양식
		FormVO frm = new FormVO();
		frm.setEmpNo(empNo);
		frm.setFormCat(formCat);
		model.addAttribute("form", ap.formList(frm));
		
		//결재라인
		AprvLineVO line = new AprvLineVO();
		line.setDept(dept);
		line.setEmpNo(empNo);
		model.addAttribute("line", li.aprvLineList(line));
		model.addAttribute("dept", li.aprvDeptSearch());
		
		// 공통코드
		model.addAttribute("st", cd.commonList("신청상태"));
		model.addAttribute("cat", cd.commonList("서식종류"));

		return "aprv/aprvReq/aprvReq";
	}

	@PostMapping("/aprvLineInsert")
	public String aprvLineInsert(AprvLineVO vo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String empNo = (String) session.getAttribute("empNo");
		String dept = (String) session.getAttribute("dept");
		vo.setDept(dept);
		vo.setEmpNo(empNo);
		
		li.aprvLineIn(vo);
		return "redirect:aprvReq";
	}
	
	@PostMapping("/formInsert")
	public String formInsert(FormVO vo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String empNo = (String) session.getAttribute("empNo");
		vo.setEmpNo(empNo);
		
		if(vo.getFormAuth() == null) {
			vo.setFormAuth("공개");
		} else {
			vo.setFormAuth("개인");
		}
		
		
		ap.formIn(vo);
		return "redirect:aprvReq";
	}

	
		
	
	
	
}
