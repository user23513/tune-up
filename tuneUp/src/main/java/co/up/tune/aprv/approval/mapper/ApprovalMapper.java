package co.up.tune.aprv.approval.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.up.tune.aprv.vo.ApprovalVO;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.TrustVO;

public interface ApprovalMapper {

	// 문서 조회
	List<AprvVO> approvalList(@Param("aprvr") String aprvr);

	// 단건조회
	AprvVO approvalSelect(AprvVO vo);

	// 결재 승인
	int approvalSign(ApprovalVO vo);

	// 결재 상태 변경
	int aprvStUp(AprvVO vo);

	// 위임자 등록
	int trustIn(TrustVO vo);

	// 위임자 수정
	int trustUp(TrustVO vo);

	// 위임자 삭제
	int trustDel(TrustVO vo);

}
