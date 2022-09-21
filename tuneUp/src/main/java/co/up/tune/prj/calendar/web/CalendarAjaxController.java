package co.up.tune.prj.calendar.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import co.up.tune.prj.calendar.service.CalendarService;
import co.up.tune.prj.vo.CalendarVO;

@RestController
public class CalendarAjaxController {
	
	@Autowired
	CalendarService dao;
	
	@PostMapping("/calendarList")
	public List<CalendarVO> calendarList(String empNo){
		CalendarVO vo = new CalendarVO();
		vo.setEmpNo(empNo);
		
		return dao.CalendarList(vo);
	}
	
	@PostMapping("/calendarInsert")
	public CalendarVO calendarInsert(CalendarVO vo) {
		dao.CalendarInsert(vo);
		vo.setCalTyp("302");
		
		return vo;
	}
	
	@PostMapping("/calendarDelete")
	public String calendarDelete(CalendarVO vo) {
		String yn = "false";
		int cnt = dao.CalendarDelete(vo);
		if(cnt == 1){yn = "true";}
		
		return yn;
	}
	
}
