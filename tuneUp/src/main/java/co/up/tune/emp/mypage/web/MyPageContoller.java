package co.up.tune.emp.mypage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.up.tune.emp.mypage.service.MypageService;
import co.up.tune.emp.vo.EmpVO;

@Controller
public class MyPageContoller {
	@Autowired
	MypageService dao;
	
	@RequestMapping("/pwCheck")
	public String pwCheck(EmpVO vo, Model model) {
		EmpVO emp = dao.empSelectOne(vo);
		
		emp.getEmpNo();
		
		System.out.println(emp.getEmpNo());
		model.addAttribute("e", dao.empSelectOne(vo));
		
		return "emp/myPage/pwCheck";
	}
	
	@RequestMapping("/profile")
	public String profile(EmpVO vo, Model model) {
		model.addAttribute("e", dao.empSelectOne(vo));
		return "emp/myPage/profile";
	}
	
	@RequestMapping("/profileForm")
	public String profileForm() {
		return "emp/myPage/profileForm";
	}
}
