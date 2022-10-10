package co.up.tune.prj.schedule.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.up.tune.emp.vo.EmpVO;
import co.up.tune.prj.myProject.service.MyProjectService;
import co.up.tune.prj.schedule.service.ScheduleService;
import co.up.tune.prj.vo.ScheduleVO;

@Controller
public class ScheduleController {

	@Autowired
	ScheduleService dao;
	
	@Autowired
	MyProjectService myDao;
	
	//일정 등록
	@PostMapping("/scheduleInsert")
	public String scheduleInsert(ScheduleVO vo, RedirectAttributes re) {
		dao.scheduleInsert(vo);
		re.addAttribute("prjNo", vo.getPrjNo());
		
		return "redirect:prjPostList";
	}
	
	//일정 참여자 등록시 불러오는 부서별 모든 사원들
	@ResponseBody
	@PostMapping("/deptList")
	public List<EmpVO> deptList(EmpVO vo) {
		return dao.deptList(vo);
	}
	
}
