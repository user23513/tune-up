package co.up.tune.prj.calendar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.up.tune.prj.calendar.mapper.CalendarMapper;
import co.up.tune.prj.vo.CalendarVO;

@Service
public class CalendarServiceImpl implements CalendarService {
	
	@Autowired
	CalendarMapper map;

	//캘린더 전체 리스트(개인일정+프로젝트)
	@Override
	public List<CalendarVO> CalendarList(CalendarVO vo) {
		return map.CalendarList(vo);
	}

	//개인일정 등록
	@Override
	public int CalendarInsert(CalendarVO vo) {
		return map.CalendarInsert(vo);
	}

	//개인일정 삭제
	@Override
	public int CalendarDelete(CalendarVO vo) {
		return map.CalendarDelete(vo);
	}

	//개인일정 수정
	@Override
	public int calendarUpdate(CalendarVO vo) {
		return map.calendarUpdate(vo);
	}

}
