package co.up.tune.emp.hr.service;

import java.util.List;

import co.up.tune.emp.vo.EmpVO;

public interface HrService {
	
	List<EmpVO> empList(); //전체 사원리스트
	List<EmpVO> empSearch(String key, String val); //사원 검색
	EmpVO empSelectList(EmpVO vo); //사원 상세내역 조회
	int empUpdate(EmpVO vo); //사원정보 수정
	List<EmpVO> managerList(); //전체 관리자리스트
}
