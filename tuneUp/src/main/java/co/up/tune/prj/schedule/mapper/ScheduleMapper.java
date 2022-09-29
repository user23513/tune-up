package co.up.tune.prj.schedule.mapper;

import java.util.List;

import co.up.tune.emp.vo.EmpVO;

public interface ScheduleMapper {
	
	List<EmpVO> deptList(EmpVO vo); //부서별 주소록 리스트
	int scheduleInsert(EmpVO vo); //프로젝트 일정 디비에 등록

}
