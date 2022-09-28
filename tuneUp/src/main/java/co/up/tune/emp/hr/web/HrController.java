package co.up.tune.emp.hr.web;

import java.sql.Date;

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
	
	//사원 수정 폼
	@RequestMapping("/empUpdateForm")
	public String empUpdateForm(EmpVO vo, Model model) {
		
		EmpVO emp = dao.empSelect(vo);
		System.out.println(vo.getEmpNo());
		String no = emp.getEmpNo();
		//주소
		String addr = emp.getAddr();
		if(addr == null) {
			emp.setAddr("//");
		}else if(!addr.equals("//") && addr !=null) {
			String arr[] = addr.split("/");
			String ad1 = arr[0];
			String ad2 = arr[1];
			String ad3 = arr[2];
			emp.setAd1(ad1);
			emp.setAd2(ad2);
			emp.setAd3(ad3);
		}
		
		model.addAttribute("e", emp);
		model.addAttribute("d", cd.commonList("부서"));
		model.addAttribute("p", cd.commonList("직위"));
		model.addAttribute("a", cd.commonList("권한"));
		return "emp/hr/empUpdateForm";
	}
	
	//사원관리 폼
	@RequestMapping("/empManage")
	public String empManage(Model model) {
		model.addAttribute("empList",dao.empList());
		model.addAttribute("managerList",dao.managerList());
		return "emp/hr/empManage";
	}
	
	//사원정보 업데이트
	@RequestMapping("/empUpdate")
	public String empUpdate(EmpVO vo, Model model) {
		//주소
		String ad1 = vo.getAd1();
		String ad2 = vo.getAd2();
		String ad3 = vo.getAd3();
		if(ad1 !=null || ad2 != null || ad3 !=null) {
			String addr = ad1+ "/" + ad2+ "/" +ad3;
			vo.setAddr(addr);
		}
		
		//입사일
		EmpVO emp = dao.empSelect(vo);
		Date hDate = emp.getFDate();
		if(hDate !=null) {
			emp.setFDate(hDate);
		}
		
		//상태
		Date fDate = emp.getFDate();
		if(fDate == null) {
			emp.setSt("재직");
			System.out.println("재직");
		}else {
			emp.setSt("퇴사");
			System.out.println("퇴사");
		}
		
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