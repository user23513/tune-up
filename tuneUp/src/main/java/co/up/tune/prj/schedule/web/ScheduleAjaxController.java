package co.up.tune.prj.schedule.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.up.tune.emp.vo.EmpVO;
import co.up.tune.prj.schedule.service.ScheduleService;
import co.up.tune.prj.vo.ScheduleVO;

@RestController
public class ScheduleAjaxController {
	
	@Autowired
	ScheduleService dao;
	
	//일정 참여자 등록시 불러오는 부서별 모든 사원들
	@PostMapping("/deptList")
	public List<EmpVO> deptList(EmpVO vo) {
		return dao.deptList(vo);
	}
	
	//일정 리스트
	/*
	 * @PostMapping("/scheduleList") public List<ScheduleVO>
	 * scheduleList(@RequestParam("prjNo")int prjNo) { return
	 * dao.scheduleList(prjNo); }
	 */

}
