package co.up.tune.aprv.approval.service;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import co.up.tune.aprv.vo.ApprovalVO;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.TrustVO;

public interface ApprovalService {

	
	// 승인문서 조회
	List<AprvVO> approvalList(@Param("aprvr") String aprvr, @Param("aprvSt") String aprvSt);
	// 단건조회
	AprvVO approvalSelect(AprvVO vo);

	// 결재 승인
	int approvalSign(ApprovalVO vo);
	// 다음 결재자
	int aprvNext(ApprovalVO vo);
	
	// 위임자 목록
	List<TrustVO> trustList(TrustVO vo);
	// 위임자 단건
	TrustVO trustSelect(TrustVO vo);
	// 위임자 등록
	int trustIn(TrustVO vo);
	// 위임자 수정
	int trustUp(TrustVO vo);
	// 위임자 삭제
	int trustDel(TrustVO vo);

}
