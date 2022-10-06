package co.up.tune.com.bell.web;

import javax.servlet.http.HttpSession; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.up.tune.com.bell.service.BellService;
import co.up.tune.com.vo.BellVO;

@Controller
public class BellController {
	
	@Autowired
	BellService dao;

	@GetMapping("/bellList")
	public String bellList(HttpSession session, Model model) {
		BellVO vo = new BellVO();
		String empNo = (String)session.getAttribute("empNo");
		vo.setEmpNo(Integer.parseInt(empNo));
		model.addAttribute("bellList", dao.bellList(vo));
		return "com/bell/bellList";
	}
	
}
