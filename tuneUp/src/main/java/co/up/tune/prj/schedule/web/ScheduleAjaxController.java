package co.up.tune.prj.schedule.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import co.up.tune.emp.vo.EmpVO;
import co.up.tune.prj.schedule.service.ScheduleService;

@RestController
public class ScheduleAjaxController {
	
	@Autowired
	ScheduleService dao;
	
	@PostMapping("/deptList")
	public List<EmpVO> deptList(EmpVO vo) {
		
		return dao.deptList(vo);
	}

}
