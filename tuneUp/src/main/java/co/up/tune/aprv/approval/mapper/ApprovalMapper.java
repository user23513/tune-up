package co.up.tune.aprv.approval.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import co.up.tune.aprv.vo.ApprovalVO;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.TrustVO;
import co.up.tune.emp.vo.EmpVO;

/**
* 전자결재 승인 Mapper
* @author 윤정은
* @date 2022.09.25
* @version 1.3
**/

public interface ApprovalMapper {

	// 결재대기 목록 (aprvr = empNo)
	List<AprvVO> approvalList(@Param("aprvr") String aprvr, @Param("aprvSt") String aprvSt);

	// 문서 승인
	int approved(ApprovalVO vo);
	
	// 문서 반려
	int reject(ApprovalVO vo);

	// 처리문서 다음결재자 
	int aprvNext(ApprovalVO vo);

	// 위임자 목록
	List<TrustVO> trustList(TrustVO vo);

	// 수임자 조회 (rptt = empNo)
	TrustVO trustCheck(TrustVO vo);

	// 위임자 등록
	int trustIn(TrustVO vo);

	// 위임자 삭제
	int trustDel(TrustVO vo);

	// 서명 업로드
	int signUp(EmpVO vo);

	// 서명 조회
	EmpVO signSelect(EmpVO vo);
	
	// 수임자 변경
	int trustUp(TrustVO vo);

}
