package co.up.tune.aprv.approval.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import co.up.tune.aprv.approval.service.ApprovalService;
import co.up.tune.aprv.vo.ApprovalVO;
import co.up.tune.aprv.vo.TrustVO;
import co.up.tune.emp.vo.EmpVO;
import co.up.tune.file.service.FileService;
import co.up.tune.prj.vo.FilesVO;

/**
 * 전자결재 승인 AjaxController
 * @author 윤정은
 * @date 2022.10.4
 * @version 1.5
 **/

@RestController
public class AjaxApprovalController {

	@Autowired
	ApprovalService ap;
	@Autowired
	FileService fs;
	@Value("${file.dir}")
	private String fileDir;

	// 위임자 삭제
	@PostMapping("/trustDel")
	public int trustDel(TrustVO vo) {
		return ap.trustDel(vo);
	}

	// 사인 업로드
	@PostMapping("/signUp")
	public String signUp(EmpVO vo, HttpSession session, @RequestParam("file") MultipartFile[] files) throws IllegalStateException, IOException {

		String empNo = (String) session.getAttribute("empNo");
		vo.setEmpNo(empNo);

		if (!files[0].isEmpty()) {

			String folder = "aprv";
			List<FilesVO> list = fs.fileUpload(files, folder);

			vo.setSign(list.get(0).getFPath());
		}
		ap.signUp(vo);
		return vo.getSign();
	}

	// 결재 -> 문서상태 변경 + 다음 결재자
	@PostMapping("/rejectIn")
	public int rejectIn(ApprovalVO vo, HttpSession session) {
		String empNo = (String) session.getAttribute("empNo");
		vo.setAprvr(empNo); //결재자 본인
		return ap.reject(vo);
	}

	// 결재 -> 문서상태 변경 + 다음 결재자
	@PostMapping("/approved")
	public String approved(ApprovalVO vo, HttpSession session) {
		String empNo = (String) session.getAttribute("empNo");
		vo.setAprvr(empNo); //결재자 본인
		return ap.approved(vo);
	}
	
	// 수임자 변경
	@PostMapping("/trustUp")
	public int trustUp(TrustVO vo, HttpSession session) {
		vo.setNm((String)session.getAttribute("nm"));
		return ap.trustUp(vo);
	}

	// 서명 삭제
	@PostMapping("/signDel")
	public int signDel(EmpVO vo, HttpSession session) {
		String empNo = (String) session.getAttribute("empNo");
		vo.setEmpNo(empNo);
		vo.setSign("");
		return ap.signUp(vo);
	}
	
	// 체크박스 일괄승인
	@PostMapping("/checkApproved") 
	public List<String> checkApproved(ApprovalVO vo, HttpSession session){
		String empNo = (String) session.getAttribute("empNo");
		vo.setAprvr(empNo); //결재자 본인
		return ap.checkApproved(vo); 
	}
	
	// 체크박스 일괄반려
	@PostMapping("/checkReject") 
	public int checkReject(ApprovalVO vo, HttpSession session){
		String empNo = (String) session.getAttribute("empNo");
		vo.setAprvr(empNo); //결재자 본인
		return ap.checkReject(vo); 
	}

}
