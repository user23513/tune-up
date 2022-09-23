package co.up.tune.aprv.aprvReq.mapper;

import java.util.List;

import co.up.tune.aprv.vo.AprvVO;

public interface AprvReqMapper {
	
	//나의 신청 리스트 (신청상태, 사번) 
	List<AprvVO> aprvList(AprvVO vo);
	//나의 신청 상세 조회
	//나의 신청 수정 (전송, 반려 상태 활성화, 반려 재전송)
	//나의 신청 삭제 (전송 상태 활성화)
	
	
	
	
	

}
