package co.up.tune.aprv.approval.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.up.tune.aprv.vo.ApprovalVO;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.TrustVO;
import co.up.tune.emp.vo.EmpVO;

public interface ApprovalMapper {

	// 문서 조회
	List<AprvVO> approvalList(@Param("aprvr") String aprvr, @Param("aprvSt") String aprvSt);

	// 단건조회
	AprvVO approvalSelect(AprvVO vo);

	// 결재 승인
	int approvalSign(ApprovalVO vo);

	// 다음 결재자
	int aprvNext(ApprovalVO vo);

	// 위임자 목록
	List<TrustVO> trustList(TrustVO vo);

	// 내가 위임자인지 조회
	TrustVO trustSelect(TrustVO vo);

	// 위임자 등록
	int trustIn(TrustVO vo);

	// 위임자 수정
	int trustUp(TrustVO vo);

	// 위임자 삭제
	int trustDel(TrustVO vo);
	
	int signIn(EmpVO vo);//서명 업로드
	
	EmpVO signSel(EmpVO vo);//서명선택

}
