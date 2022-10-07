package co.up.tune.aprv.aprvReq.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import co.up.tune.aprv.aprvLine.service.AprvLineService;
import co.up.tune.aprv.aprvReq.service.AprvReqService;
import co.up.tune.aprv.vo.AprvLineVO;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.FormVO;
import co.up.tune.common.service.CommonService;
import co.up.tune.file.service.FileService;
import co.up.tune.prj.vo.FilesVO;

/**
 * 전자결재 신청 Controller
 * @author 윤정은
 * @date 2022.09.22
 * @version 1.2
 **/

@Controller
public class AprvReqController {

	@Autowired
	CommonService cd;
	@Autowired
	AprvReqService rs;
	@Autowired
	AprvLineService ls;
	@Autowired
	FileService fs;

	
	//결재신청상태
	@GetMapping("/aprvReq")
	public String aprvReq(Model model, HttpSession session,
			@RequestParam(required = false, defaultValue = "전체") String reqSt,
			@RequestParam(required = false, defaultValue = "전체") String formCat) {

		String empNo = (String) session.getAttribute("empNo");

		// 신청문서
		AprvVO vo = new AprvVO();
		vo.setEmpNo(empNo);
		vo.setReqSt(reqSt);
		model.addAttribute("aprv", rs.aprvReqList(vo));

		// 서식양식
		FormVO frm = new FormVO();
		frm.setEmpNo(empNo);
		frm.setFormCat(formCat);
		model.addAttribute("form", rs.formList(frm));

		// 결재라인 ~ 부서
		AprvLineVO line = new AprvLineVO();
		line.setEmpNo(empNo); //(부서 있으면 안됨, 사번만)
		model.addAttribute("line", ls.aprvLineList(line));
		model.addAttribute("dept", ls.aprvDeptList());

		// 공통코드
		model.addAttribute("st", cd.commonList("신청상태"));
		model.addAttribute("cat", cd.commonList("서식종류"));

		return "aprv/aprvReq/aprvReq";
	}
	
	// 결재선 추가
	@PostMapping("/aprvLineIn")
	public int aprvLineIn(AprvLineVO vo, HttpSession session) {
		String empNo = (String) session.getAttribute("empNo");
		String dept = (String) session.getAttribute("dept");
		vo.setDept(dept);
		vo.setEmpNo(empNo);
		
		return ls.aprvLineIn(vo);
	}
	
	//서식 추가
	@PostMapping("/formIn")
	public String formIn(FormVO vo, HttpSession session) {
		String empNo = (String) session.getAttribute("empNo");
		String nm = (String) session.getAttribute("nm");
		vo.setNm(nm);
		vo.setEmpNo(empNo);
		
		// 권한 개인 공개문서 처리
		if (vo.getFormAuth() == null) {
			vo.setFormAuth("개인");
		} else {
			vo.setFormAuth("공개");
		}

		rs.formIn(vo);
		return "redirect:aprvReq";
	}
	
	

	//서식적용 결재문서 작성화면
	@PostMapping("/aprvForm")
	public String aprvForm(FormVO vo, Model model, HttpSession session) {

		String empNo = (String) session.getAttribute("empNo");
		// 결재선 조회
		AprvLineVO line = new AprvLineVO();
		line.setEmpNo(empNo); //(부서 있으면 안됨, 사번만)
		model.addAttribute("line", ls.aprvLineList(line));
		// 부서목록
		model.addAttribute("dept", ls.aprvDeptList());
		// 서식출력
		model.addAttribute("form", rs.formSelect(vo));
		
		return "aprv/aprvReq/aprvForm";
	}

	//결재문서 입력
	@PostMapping("/aprvReqIn")
	public String aprvReqn(AprvVO vo, HttpSession session, @RequestParam("file") MultipartFile[] files)
			throws IllegalStateException, IOException {
		
		// 파일 처리
		if (!files[0].isEmpty()) {
			String folder = "aprv";
			List<FilesVO> list = fs.fileUpload(files, folder);
			vo.setFNm(list.get(0).getFNm());
			vo.setFPath(list.get(0).getFPath());
		}
		
		String empNo = (String) session.getAttribute("empNo");
		vo.setEmpNo(empNo);
		String nm = (String) session.getAttribute("nm");
		vo.setNm(nm);
		
		// 결재문서 테이블 입력
		rs.aprvReqIn(vo);
		
		
		return "redirect:aprvReq";
	}

	
}
