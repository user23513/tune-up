package co.up.tune.aprv.aprvAdmin.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import co.up.tune.aprv.vo.ApprovalVO;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.FormVO;

/**
 * 전자결재 관리자 Mapper
 * 
 * @author 윤정은
 * @date 2022.09.25
 * @version 1.2
 **/

public interface AprvAdminMapper {

	// 관리자 전체 결재문서 조회
	List<AprvVO> aprvListAll(@Param("reqSt") String reqSt);

	// 관리자 전체 서식목록 조회
	List<FormVO> aprvFormAll(@Param("formCat") String formCat);

	// 관리자 결재자 강제삭제
	int approvalAdminDel(AprvVO vo);

	// 관리자 결재문서 강제삭제 (결재자 먼저 지워야함)
	int aprvAdminDel(AprvVO vo);

	// 관리자 결재자 강제반려
	int aprvAdReject(ApprovalVO vo);

	// 관리자 결재문서 강제반려 (결재자 먼저 지워야함)
	int reqAdReject(ApprovalVO vo);

	// 관리자 결재자 강제승인
	int aprvAdOk(ApprovalVO vo);

	// 관리자 결재문서 강제승인 (결재자 먼저 지워야함)
	int reqAdOk(ApprovalVO vo);

}
