package co.up.tune.aprv.aprvAdmin.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import co.up.tune.aprv.vo.ApprovalVO;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.FormVO;

public interface AprvAdminMapper {

	// 관리자 전체 결재문서 조회
	List<AprvVO> aprvListAll(@Param("reqSt") String reqSt);

	// 결재문서 단건 상세
	AprvVO aprvSelect(AprvVO vo);

	// 관리자 삭제 (결재인 먼저 지워야함)
	int aprvAdminDel(AprvVO vo);

	int approvalAdminDel(AprvVO vo);

	// 관리자 전체 서식목록 조회
	List<FormVO> aprvFormAll(@Param("formCat") String formCat);

	// 서식 단건 상세
	FormVO formSelect(FormVO vo);

	// 관리자 서식 삭제
	int formAdminDel(FormVO vo);

	// 관리자 반려(결재인)
	int aprvAdReject(ApprovalVO vo);

	// 관리자 반려(문서)
	int reqAdReject(ApprovalVO vo);

}
