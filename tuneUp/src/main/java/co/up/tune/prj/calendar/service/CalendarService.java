package co.up.tune.prj.calendar.service;

import java.util.List;

import co.up.tune.prj.vo.CalendarVO;

public interface CalendarService {
	
	List<CalendarVO> CalendarList(CalendarVO vo); //캘린더 전체 리스트(개인일정+프로젝트)
	int CalendarInsert(CalendarVO vo); //개인일정 등록
	int CalendarDelete(CalendarVO vo); //개인일정 삭제

}
