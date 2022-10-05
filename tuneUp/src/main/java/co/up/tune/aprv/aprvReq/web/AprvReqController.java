package co.up.tune.aprv.aprvReq.web;

import java.io.IOException;
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
import co.up.tune.aprv.approval.service.ApprovalService;
import co.up.tune.aprv.aprvLine.service.AprvLineService;
import co.up.tune.aprv.aprvReq.service.AprvReqService;
import co.up.tune.aprv.vo.ApprovalVO;
import co.up.tune.aprv.vo.AprvLineVO;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.FormVO;
import co.up.tune.aprv.vo.ReferVO;
import co.up.tune.common.service.CommonService;
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
	@Autowired
	ApprovalService as;
	@Autowired
	FileService fs;
	
	//결재신청상태
	@GetMapping("/aprvReq")
	public String aprvReq(Model model, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "전체") String reqSt,
			@RequestParam(required = false, defaultValue = "전체") String formCat) {

		// 세션사번
		HttpSession session = request.getSession();
		String empNo = (String) session.getAttribute("empNo");

		// 신청문서
		AprvVO vo = new AprvVO();
		vo.setEmpNo(empNo);
		vo.setReqSt(reqSt);
		model.addAttribute("aprv", ap.aprvReqList(vo));

		// 서식양식
		FormVO frm = new FormVO();
		frm.setEmpNo(empNo);
		frm.setFormCat(formCat);
		model.addAttribute("form", ap.formList(frm));

		// 결재라인 ~ 부서
		AprvLineVO line = new AprvLineVO();
		line.setEmpNo(empNo); //(부서 있으면 안됨, 사번만)
		model.addAttribute("line", li.aprvLineList(line));
		model.addAttribute("dept", li.aprvDeptSearch());

		// 공통코드
		model.addAttribute("st", cd.commonList("신청상태"));
		model.addAttribute("cat", cd.commonList("서식종류"));

		return "aprv/aprvReq/aprvReq";
	}
	
	// 결재선 추가
	@PostMapping("/aprvLineInsert")
	public int aprvLineInsert(AprvLineVO vo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String empNo = (String) session.getAttribute("empNo");
		String dept = (String) session.getAttribute("dept");
		vo.setDept(dept);
		vo.setEmpNo(empNo);
		
		return li.aprvLineIn(vo);
	}
	
	//서식 추가
	@PostMapping("/formInsert")
	public String formInsert(FormVO vo, HttpServletRequest request) {
		HttpSession session = request.getSession();
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

		ap.formIn(vo);
		return "redirect:aprvReq";
	}
	
	//선택한 폼 정보 가지고 결재문서 작성폼 이동
	@PostMapping("/aprvForm")
	public String aprvForm(FormVO vo, Model model, HttpServletRequest request) {

		HttpSession session = request.getSession();
		String empNo = (String) session.getAttribute("empNo");
		// 결재선 조회
		AprvLineVO line = new AprvLineVO();
		line.setEmpNo(empNo); //(부서 있으면 안됨, 사번만)
		model.addAttribute("line", li.aprvLineList(line));
		// 부서목록
		model.addAttribute("dept", li.aprvDeptSearch());
		// 서식출력
		model.addAttribute("form", ap.formSelect(vo));
		
		return "aprv/aprvReq/aprvForm";
	}

	//결재 문서 입력
	@PostMapping("/aprvInsert")
	public String aprvInsert(AprvVO vo, HttpServletRequest request, @RequestParam("file") MultipartFile[] files)
			throws IllegalStateException, IOException {
		
		// 파일 처리
		if (!files[0].isEmpty()) {
			String folder = "aprv";
			List<FilesVO> list = fs.fileUpload(files, folder);
			vo.setFNm(list.get(0).getFNm());
			vo.setFPath(list.get(0).getFPath());
		}

		HttpSession session = request.getSession();
		String empNo = (String) session.getAttribute("empNo");
		vo.setEmpNo(empNo);
		String nm = (String) session.getAttribute("nm");
		vo.setNm(nm);
		
		// 마감일시 처리
		vo.setDeadline(vo.getDeadDay() + " " + vo.getDeadTime());

		// 중요도 처리
		if (vo.getImpts() == "on") {
			vo.setImpts("Y");
		} else {
			vo.setImpts("N");
		}

		// 결재문서 테이블 입력
		int cnt = ap.aprvReqIn(vo);
		// 입력 완료시
		if (cnt != 0) {
			// 입력된 문서번호 가져와서 참조 결재자 입력 
			int aprvNo = vo.getAprvNo();
			
			ApprovalVO aprv = new ApprovalVO();
			aprv.setAprvNo(aprvNo);
			
			//폼에서 가져온 결재자 목록 처리
			String aprvr = vo.getAprvr();

			if (!aprvr.contains(",")) {
				aprv.setAprvr(aprvr);
				aprv.setAprvSeq(1);
				li.approvalIn(aprv);

			} else {
				String[] arrAp = aprvr.split(",");
				int a = 1; // 결재순서
				
				for (String i : arrAp) {
					aprv.setAprvr(i);
					aprv.setAprvSeq(a);
					li.approvalIn(aprv);
					a++;
				}

			}

			// 반복
			ReferVO rf = new ReferVO();
			rf.setAprvNo(aprvNo);
			
			// 폼에서 가져온 참조인 목록 처리
			String refer = vo.getRefer();
			if (!refer.contains(",")) {
				rf.setEmpNo(refer);
				li.referIn(rf);

			} else {
				String[] appRf = refer.split(",");
				for (String i : appRf) {
					rf.setEmpNo(i);
					li.referIn(rf);

				}
			}
		};
		
		return "redirect:aprvReq";
	}

	
}
