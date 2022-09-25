package co.up.tune.aprv.aprvAdmin.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import co.up.tune.aprv.aprvAdmin.service.AprvAdminService;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.FormVO;
import co.up.tune.common.service.CommonService;

@Controller
public class AprvAdminController {
	
	@Autowired
	CommonService cd;
	@Autowired
	AprvAdminService ap;
	
	
	
	@GetMapping("/aprvAdmin")
	public String aprvAdmin(Model model, HttpServletRequest request) throws IOException {
		
		HttpSession session =  request.getSession();
		String auth = (String) session.getAttribute("auth");
		
		if(auth.equals("ADMIN")) {
			

			List<AprvVO> list = ap.aprvListAll();
			model.addAttribute("aprvList", list);
			
			List<FormVO> form = ap.aprvFormAll();
			model.addAttribute("formList", form);

			
			// 공통코드
			model.addAttribute("cd", cd.commonList("신청상태"));
			model.addAttribute("cat", cd.commonList("서식종류"));
		
			return "aprv/aprvAdmin/aprvAdmin";	
		
		} else {
			
			model.addAttribute("msg", "관리자가 아닙니다.");
			return "main/main";	
		}

	}

}
