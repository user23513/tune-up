package co.up.tune.aprv.approval.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import co.up.tune.aprv.approval.service.ApprovalService;
import co.up.tune.aprv.vo.ApprovalVO;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.TrustVO;
import co.up.tune.common.service.CommonService;
import co.up.tune.emp.vo.EmpVO;
import co.up.tune.file.service.FileService;
import co.up.tune.prj.vo.FilesVO;

@RestController
public class AjaxApprovalController {

	@Autowired
	CommonService cd;
	@Autowired
	ApprovalService ap;
	@Autowired
	FileService fs;

	//결제문서 상세
	@PostMapping("/approvalView")
	public AprvVO approvalView(AprvVO vo) {
		return ap.approvalSelect(vo);
	}
	
	//위임자 삭제
	@PostMapping("/trustDel")
	public int trustDel(TrustVO vo) {
		return ap.trustDel(vo);
	}
	
	//사인업데이트
	@PostMapping("/signUp")
	public int signUp(EmpVO vo, HttpSession session, @RequestParam("file") MultipartFile[] files)
			throws IllegalStateException, IOException {
		
		String empNo = (String) session.getAttribute("empNo");
		vo.setEmpNo(empNo);
		if (!files[0].isEmpty()) {
			String folder = "aprv";
			List<FilesVO> list = fs.fileUpload(files, folder);
			vo.setSign(list.get(0).getFPath());
		}
		
		return ap.signUp(vo);
	}
	
	//승인 반려 결재 approvalSign -> aprvNext 문서의 신청상태 변경 and 다음 결재자 상태 변경 (결재권 넘어감)
	@PostMapping("/signReject")
	public int signReject(ApprovalVO vo, HttpSession session) {
		
		String empNo = (String) session.getAttribute("empNo");
		vo.setAprvr(empNo);
		//sign reject null값으로 상태 바뀜
		
		return ap.approvalSign(vo);
	}
	
}
