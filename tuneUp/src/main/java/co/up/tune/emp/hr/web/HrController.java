package co.up.tune.emp.hr.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.up.tune.common.service.CommonService;
import co.up.tune.emp.hr.service.HrService;
import co.up.tune.emp.vo.EmpVO;

@Controller
public class HrController {
	@Autowired
	HrService dao;
	@Autowired
	CommonService cd;
	
	
	@RequestMapping("/empUpdateForm")
	public String empUpdateForm(EmpVO vo, Model model) {
		
		EmpVO emp = dao.empSelect(vo);
		String addr = emp.getAddr();
		String arr[] = addr.split("/");
		String ad1 = arr[0];
		String ad2 = arr[1];
		String ad3 = arr[2];
		emp.setAd1(ad1);
		emp.setAd2(ad2);
		emp.setAd3(ad3);
		
		model.addAttribute("e", emp);
		model.addAttribute("d", cd.commonList("부서"));
		model.addAttribute("p", cd.commonList("직위"));
		model.addAttribute("a", cd.commonList("권한"));
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
	
	@RequestMapping("/empUpdate")
	public String empUpdate(EmpVO vo, Model model) {
		String ad1 = vo.getAd1();
		String ad2 = vo.getAd2();
		String ad3 = vo.getAd3();
		String addr = ad1+ "/" + ad2+ "/" +ad3;
		vo.setAddr(addr);
		
		
		int cnt = 0;
		if (dao.empUpdate(vo) != 0) {
			model.addAttribute("empList",dao.empList());
			model.addAttribute("managerList",dao.managerList());
			return "emp/hr/empManage";
		} else {
			return "redirect:empUpdateForm";
		}
	}
}
