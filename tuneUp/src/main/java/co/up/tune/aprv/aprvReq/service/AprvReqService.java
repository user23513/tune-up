package co.up.tune.aprv.aprvReq.service;

import java.util.List;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.FormVO;

public interface AprvReqService {

	// PDF 저장 인쇄 임시저장 파일업로드

	// 나의 신청 리스트
	List<AprvVO> aprvReqList(AprvVO vo);

	// 단건 조회
	AprvVO aprvReqSelect(AprvVO vo);

	// 새문서 작성
	int aprvReqIn(AprvVO vo);

	// 문서 수정
	int aprvReqUp(AprvVO vo);

	// 문서 삭제
	int aprvReqDel(AprvVO vo);

	// 서식 리스트
	List<FormVO> formList(FormVO vo);

	// 서식 단건
	FormVO formSelect(FormVO vo);

	// 기존서식으로 작성, 기존서식 수정
	int formUp(FormVO vo);

	// 서식으로 저장하기
	int formIn(FormVO vo);

	// 서식 삭제
	int formDel(FormVO vo);

}
