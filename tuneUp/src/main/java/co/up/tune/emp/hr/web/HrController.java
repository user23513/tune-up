package co.up.tune.emp.hr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.up.tune.emp.hr.service.HrService;
import co.up.tune.emp.vo.EmpVO;

@Controller
public class HrController {
	@Autowired
	HrService dao;
	
	@RequestMapping("/empUpdateForm")
	public String empUpdateForm(EmpVO vo, Model model) {
		dao.empSelect(vo);
		model.addAttribute("e", dao.empSelect(vo));
		return "emp/hr/empUpdateForm";
	}
	
	@RequestMapping("/empManage")
	public String empManage(Model model) {
		model.addAttribute("empList",dao.empList());
		model.addAttribute("managerList",dao.managerList());
		return "emp/hr/empManage";
	}
	
	@RequestMapping("/empProfile")
	public String empSelect(EmpVO vo, Model model) {
		dao.empSelect(vo);
		model.addAttribute("e", dao.empSelect(vo));
		return "emp/hr/empProfile";
	}
	
	@RequestMapping("/addr")
	public String addr() {
		return "emp/hr/addr";
	}
		
	
}
