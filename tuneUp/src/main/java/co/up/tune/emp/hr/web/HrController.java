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
	HrService hrService;
	@Autowired
	CommonService cd;
	
	//사원 수정 폼
	@RequestMapping("/empUpdateForm")
	public String empUpdateForm(EmpVO vo, Model model) {
		
		EmpVO emp = hrService.empSelect(vo);
		
		if(vo.getPic() == null) {
			vo.setPic("");
		}
		
		//주소
		String addr = emp.getAddr();
		if(addr == null) {
			emp.setAddr("//");
		}else if(!addr.equals("//") ) {
			String arr[] = addr.split("/");
			String ad1 = arr[0];
			String ad2 = arr[1];
			String ad3 = arr[2];
			emp.setAd1(ad1);
			emp.setAd2(ad2);
			emp.setAd3(ad3);
		}
		
		model.addAttribute("emp", emp);
		model.addAttribute("dept", cd.commonList("부서"));
		model.addAttribute("position", cd.commonList("직위"));
		model.addAttribute("auth", cd.commonList("권한"));
		return "emp/hr/empUpdateForm";
	}
	
	//사원관리 폼
	@RequestMapping("/empManage")
	public String empManage(Model model) {
		model.addAttribute("empList",hrService.empList());
		model.addAttribute("managerList",hrService.managerList());
		return "emp/hr/empManage";
	}
	
	//사원정보 업데이트
	@RequestMapping("/empUpdate")
	public String empUpdate(EmpVO vo, Model model) {
		//주소
		String ad1 = vo.getAd1();
		String ad2 = vo.getAd2();
		String ad3 = vo.getAd3();
		String addr = ad1+ "/" + ad2+ "/" +ad3;
		if (hrService.empUpdate(vo) != 0) {
			return "redirect:empManage";
		} else {
			return "redirect:empUpdateForm";
		}
	}
}