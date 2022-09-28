package co.up.tune.prj.schedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.up.tune.emp.vo.EmpVO;
import co.up.tune.prj.schedule.mapper.ScheduleMapper;

@Service
public class ScheduleServiceImpl implements ScheduleService {
	
	@Autowired
	ScheduleMapper map;

	@Override
	public List<EmpVO> deptList(EmpVO vo) {
		return map.deptList(vo);
	}

}
