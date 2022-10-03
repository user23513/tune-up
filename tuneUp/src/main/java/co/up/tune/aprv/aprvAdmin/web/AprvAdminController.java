package co.up.tune.aprv.aprvAdmin.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.up.tune.aprv.approval.service.ApprovalService;
import co.up.tune.aprv.aprvAdmin.service.AprvAdminService;
import co.up.tune.aprv.aprvLine.service.AprvLineService;
import co.up.tune.aprv.vo.AprvLineVO;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.FormVO;
import co.up.tune.aprv.vo.TrustVO;
import co.up.tune.common.service.CommonService;

@Controller
public class AprvAdminController {
	
	@Autowired
	CommonService cd;
	@Autowired
	AprvAdminService as;
	@Autowired
	AprvLineService li;
	@Autowired
	ApprovalService ap;
	
	
	
	@GetMapping("/aprvAdmin")
	public String aprvAdmin(Model model, HttpServletRequest request, @RequestParam(required = false, defaultValue = "전체")String reqSt, @RequestParam(required = false, defaultValue = "전체")String formCat) throws IOException {
		
		HttpSession session =  request.getSession();
		String auth = (String) session.getAttribute("auth");
		
		if(auth.equals("ADMIN")) {
			

			List<AprvVO> list = as.aprvListAll(reqSt);
			model.addAttribute("aprv", list);
			
			List<FormVO> form = as.aprvFormAll(formCat);
			model.addAttribute("form", form);
			
			AprvLineVO nu = new AprvLineVO();
			model.addAttribute("line", li.aprvLineList(nu));
			model.addAttribute("dept", li.aprvDeptSearch());
			
			TrustVO vo = new TrustVO();
			model.addAttribute("trust", ap.trustList(vo));
			
			// 공통코드
			model.addAttribute("st", cd.commonList("신청상태"));
			model.addAttribute("cat", cd.commonList("서식종류"));
		
			return "aprv/aprvAdmin/aprvAdmin";	
		
		} else {
			
			model.addAttribute("msg", "관리자가 아닙니다.");
			return "main/main";	
		}

	}

}
