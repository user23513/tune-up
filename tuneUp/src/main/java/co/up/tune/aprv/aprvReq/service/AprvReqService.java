package co.up.tune.aprv.aprvReq.service;

import java.util.List;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.FormVO;

/**
 * 전자결재 신청 Service
 * @author 윤정은
 * @date 2022.09.22
 * @version 1.2
 **/


public interface AprvReqService {

	// 나의 신청 목록
	List<AprvVO> aprvReqList(AprvVO vo);

	// 결재문서 단건 조회
	AprvVO aprvSelect(AprvVO vo);

	// 새로운 문서 작성
	int aprvReqIn(AprvVO vo);

	// 서식 목록 (공개 + 개인 문서)
	List<FormVO> formList(FormVO vo);

	// 서식 단건 조회
	FormVO formSelect(FormVO vo);

	// 서식 수정
	int formUp(FormVO vo);

	// 서식 저장
	int formIn(FormVO vo);

	// 서식 삭제
	int formDel(FormVO vo);

}
