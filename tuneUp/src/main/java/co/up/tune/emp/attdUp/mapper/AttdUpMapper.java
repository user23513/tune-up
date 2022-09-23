package co.up.tune.emp.attdUp.mapper;

import java.util.List;

import co.up.tune.emp.vo.AttdUpVO;
import co.up.tune.prj.vo.PostVO;

public interface AttdUpMapper {
	List<AttdUpVO> attdUpList();	//전체 근태 수정리스트 - 관리자
	int attdUpUpdate(AttdUpVO vo); // 근태 업데이트 - 관리자
	AttdUpVO attdUpSelect(AttdUpVO vo); // 수정 상세조회 - 관리자 
	
	List<AttdUpVO> myAttdUpList(); //나의 근태 수정리스트
	int attdUpInsert(AttdUpVO vo); // 근태 수정 신청 - 사원
	
	
	// 수정리스트 - 대기
	// 수정리스트 - 완료
	
	
	
	
}
