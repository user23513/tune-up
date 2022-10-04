package co.up.tune.aprv.aprvReq.mapper;

import java.util.List;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.FormVO;

public interface AprvReqMapper {

	// 나의 신청 리스트
	List<AprvVO> aprvReqList(AprvVO vo);

	// 단건 조회
	AprvVO aprvReqSelect(AprvVO vo);

	// 새문서 작성
	int aprvReqIn(AprvVO vo);

	// 서식 리스트
	List<FormVO> formList(FormVO vo);

	// 서식 단건
	FormVO formSelect(FormVO vo);

	// 서식 수정
	int formUp(FormVO vo);

	// 서식 저장
	int formIn(FormVO vo);

	// 서식 삭제
	int formDel(FormVO vo);

}
