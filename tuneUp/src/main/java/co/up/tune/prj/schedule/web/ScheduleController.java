package co.up.tune.prj.schedule.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.up.tune.prj.schedule.service.ScheduleService;
import co.up.tune.prj.vo.ScheduleVO;

@Controller
public class ScheduleController {

	@Autowired
	ScheduleService dao;
	
	//일정 등록
	@PostMapping("/scheduleInsert")
	public String scheduleInsert(ScheduleVO vo) {
		dao.scheduleInsert(vo);
		return "redirect:/prjPostList";
	}
	
}
