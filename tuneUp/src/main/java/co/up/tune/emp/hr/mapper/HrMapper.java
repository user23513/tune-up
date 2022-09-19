package co.up.tune.emp.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.up.tune.emp.vo.EmpVO;

public interface HrMapper {

	List<EmpVO> empList(); //전체 사원리스트
	List<EmpVO> empSearch(@Param("key") String key,@Param("vals") String val); //사원 검색
	EmpVO empSelectList(EmpVO vo); //사원 상세내역 조회
	int empUpdate(EmpVO vo); //사원정보 수정
}
