package co.up.tune.prj.schedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import co.up.tune.emp.vo.EmpVO;
import co.up.tune.prj.schedule.mapper.ScheduleMapper;
import co.up.tune.prj.vo.ScheduleVO;

@Service
public class ScheduleServiceImpl implements ScheduleService {
	
	@Autowired
	ScheduleMapper map;

	//부서별 주소록 리스트
	@Override
	public List<EmpVO> deptList(EmpVO vo) {
		
		return map.deptList(vo);
	}

	//프로젝트 일정 디비에 등록
	@Override
	public int scheduleInsert(ScheduleVO vo) {
		return map.scheduleInsert(vo);
	}

	//프로젝트 일정 리스트
	@Override
	public Page<ScheduleVO> scheduleList(int pageNo, int prjNo) {
		PageHelper.startPage(pageNo, 10);
		return map.scheduleList(prjNo);
	}

}
