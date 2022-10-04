package co.up.tune.aprv.approval.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import co.up.tune.aprv.approval.service.ApprovalService;
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

	@PostMapping("/approvalView")
	public AprvVO approvalView(AprvVO vo) {
		return ap.approvalSelect(vo);
	}

	@PostMapping("/trustDel")
	public int trustDel(TrustVO vo) {
		return ap.trustDel(vo);
	}
	
	@PostMapping("/signIn")
	public int signIn(EmpVO vo, HttpServletRequest request, @RequestParam("file") MultipartFile[] files)
			throws IllegalStateException, IOException {
		HttpSession session = request.getSession();
		String empNo = (String) session.getAttribute("empNo");
		vo.setEmpNo(empNo);
		if (!files[0].isEmpty()) {
			String folder = "aprv";
			List<FilesVO> list = fs.fileUpload(files, folder);
			vo.setSign(list.get(0).getFPath());
		}
		
		System.out.println(vo.getSign());
		return ap.signIn(vo);
	}

}
