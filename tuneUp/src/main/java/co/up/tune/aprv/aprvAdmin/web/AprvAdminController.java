package co.up.tune.aprv.aprvAdmin.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import co.up.tune.aprv.approval.service.ApprovalService;
import co.up.tune.aprv.aprvAdmin.service.AprvAdminService;
import co.up.tune.aprv.aprvLine.service.AprvLineService;
import co.up.tune.aprv.aprvReq.service.AprvReqService;
import co.up.tune.aprv.vo.ApprovalVO;
import co.up.tune.aprv.vo.AprvLineVO;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.FormVO;
import co.up.tune.aprv.vo.ReferVO;
import co.up.tune.aprv.vo.TrustVO;
import co.up.tune.common.service.CommonService;

/**
 * 전자결재 관리 Controller
 * @author 윤정은
 * @date 2022.09.27
 * @version 1.2
 **/

@Controller
public class AprvAdminController {

	@Autowired
	CommonService cd;
	@Autowired
	AprvAdminService as;
	@Autowired
	AprvLineService ls;
	@Autowired
	ApprovalService ap;
	@Autowired
	AprvReqService rs;
	@Value("${file.dir}")
	private String fileDir;
	

	//관리자페이지
	@GetMapping("/aprvAdmin")
	public String aprvAdmin(Model model, HttpSession session, RedirectAttributes rttr,
			@RequestParam(required = false, defaultValue = "전체") String reqSt,
			@RequestParam(required = false, defaultValue = "전체") String formCat) throws IOException {

		String auth = (String) session.getAttribute("auth");
		
		//관리자 체크
		if (auth.equals("ADMIN")) {
			//전체문서
			List<AprvVO> aprv = as.aprvListAll(reqSt);
			model.addAttribute("aprv", aprv);
			//전체서식
			List<FormVO> form = as.aprvFormAll(formCat);
			model.addAttribute("form", form);
			//전체 결재선 (empNo 있으면 전체 조회 안됨)
			AprvLineVO nu = new AprvLineVO();
			model.addAttribute("line", ls.aprvLineList(nu));
			//부서 목록
			model.addAttribute("dept", ls.aprvDeptList());
			//위임자 (empNo 있으면 전체 조회 안됨)
			TrustVO vo = new TrustVO();
			model.addAttribute("trust", ap.trustList(vo));
			// 공통코드
			model.addAttribute("st", cd.commonList("신청상태"));
			model.addAttribute("cat", cd.commonList("서식종류"));

			return "aprv/aprvAdmin/aprvAdmin";

		} else {

			rttr.addFlashAttribute("msg", "관리자가 아닙니다.");
			return "redirect:main";
		}

	}
	
	//문서상세
	@PostMapping("/aprvAdminView")
	public String aprvAdminView(AprvVO vo, Model model) {
		int aprvNo = vo.getAprvNo();
		ApprovalVO avo = new ApprovalVO();
		avo.setAprvNo(aprvNo);
		ReferVO rvo = new ReferVO();
		rvo.setAprvNo(aprvNo);
		
		model.addAttribute("aprv", rs.aprvSelect(vo));
		model.addAttribute("approval", ls.aprvrList(avo));
		model.addAttribute("refer", ls.referList(rvo));
		return "aprv/aprvAdmin/aprvAdminView";
	}
	
}

