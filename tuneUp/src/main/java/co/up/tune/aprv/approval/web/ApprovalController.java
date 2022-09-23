package co.up.tune.aprv.approval.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import co.up.tune.common.service.CommonService;

@Controller
public class ApprovalController {
	
	@Autowired
	CommonService cd;
	
	
	
	@GetMapping("/approval")
	public String approval(Model model, HttpServletRequest request) {
		
		
		
		return "aprv/approval";
	}

	
	
	


}
