package co.up.tune.emp.attdUp.mapper;

import java.util.List;
import java.util.Map;

import co.up.tune.emp.vo.AttdUpVO;

public interface AttdUpMapper {
	List<AttdUpVO> attdUpList();	//전체 근태 수정리스트 - 관리자
	int attdUpUpdate(AttdUpVO vo); // 근태 업데이트 - 관리자
	AttdUpVO attdUpSelect(AttdUpVO vo); // 수정 상세조회 - 관리자 
	
	List<AttdUpVO> myAttdUpList(String empNo); //나의 근태 수정리스트
	int attdUpInsert(AttdUpVO vo); // 근태 수정 신청 - 사원
	int attdUpDel(int attdUpNo);	//근태 수정 반려
	int attdUpOk(Map<String, Object> paramMap);	//근태 수정 승인
	
	int checkModi(AttdUpVO vo);	//수정요청 몇명
	
	int selectAttdUpNo(Map<String, Object> paramMap);
	
	
	
	
	
	
}
