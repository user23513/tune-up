package co.up.tune.emp.hr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import co.up.tune.emp.hr.service.HrService;
import co.up.tune.emp.vo.EmpVO;

@RestController
public class HrAjaxContoller {
	@Autowired
	HrService dao;
	
	@PostMapping("/authUpdate")
	public String authUpdate(EmpVO vo) {
		dao.authUpdate(vo);
		System.out.println(dao.authUpdate(vo));
		return vo.getAuth();
	}
}
