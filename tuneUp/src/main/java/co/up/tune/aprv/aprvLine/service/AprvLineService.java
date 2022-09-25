package co.up.tune.aprv.aprvLine.service;

import java.util.List;
import co.up.tune.aprv.vo.ApprovalVO;
import co.up.tune.aprv.vo.AprvLineVO;
import co.up.tune.aprv.vo.ReferVO;

public interface AprvLineService {

	// 결재자
	List<ApprovalVO> approvalList(ApprovalVO vo); // 조회

	int approvalIn(List<ApprovalVO> list); // 등록 - 반복

	int approvalUp(List<ApprovalVO> list); // 수정 - 반복

	int approvalDel(ApprovalVO vo); // 삭제

	// 참조인
	List<ReferVO> ReferList(ReferVO vo); // 조회

	int referIn(List<ReferVO> list); // 등록 - 반복

	int referUp(List<ReferVO> list); // 수정 - 반복

	int referDel(ReferVO vo); // 삭제

	// 결재선
	List<AprvLineVO> aprvLineList(AprvLineVO vo); // 조회

	int aprvLineIn(AprvLineVO vo); // 등록

	int aprvLineUp(AprvLineVO vo); // 수정

	int aprvLineDel(AprvLineVO vo); // 삭제

}
