package co.up.tune.prj.schedule.service;

import java.util.List;

import co.up.tune.emp.vo.EmpVO;
import co.up.tune.prj.vo.ScheduleVO;

public interface ScheduleService {

	List<EmpVO> deptList(EmpVO vo); //부서별 주소록 리스트
	int scheduleInsert(ScheduleVO vo); //프로젝트 일정 디비에 등록
	List<ScheduleVO> scheduleList(int prjNo); //프로젝트 일정 리스트
}
