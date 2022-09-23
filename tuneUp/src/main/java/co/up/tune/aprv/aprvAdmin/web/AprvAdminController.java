package co.up.tune.aprv.aprvAdmin.web;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import co.up.tune.common.service.CommonService;

@Controller
public class AprvAdminController {
	
	@Autowired
	CommonService cd;
	
	
	
	@GetMapping("/aprvAdmin")
	public String aprvAdmin(Model model, HttpServletRequest request) throws IOException {
		
		HttpSession session =  request.getSession();
		String auth = (String) session.getAttribute("auth");
		
		if(auth.equals("ADMIN")) {
			
		
			return "aprv/aprvAdmin";	
		
		} else {
			
			model.addAttribute("msg", "관리자가 아닙니다.");
			return "main/main";	
		}

	}

}
