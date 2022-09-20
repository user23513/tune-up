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

	@Override
	public List<CalendarVO> CalendarList(CalendarVO vo) {
		//캘린더 전체 리스트(개인일정+프로젝트)
		return map.CalendarList(vo);
	}

	@Override
	public int CalendarInsert(CalendarVO vo) {
		//개인일정 등록
		return map.CalendarInsert(vo);
	}

	@Override
	public int CalendarDelete(CalendarVO vo) {
		//개인일정 삭제
		return map.CalendarDelete(vo);
	}

}
