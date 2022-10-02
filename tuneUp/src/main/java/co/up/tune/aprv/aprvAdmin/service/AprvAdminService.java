package co.up.tune.aprv.aprvAdmin.service;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import co.up.tune.aprv.vo.ApprovalVO;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.FormVO;

public interface AprvAdminService { // 전자결재 관리자

	
	//관리자 전체 결재문서 목록 조회
	List<AprvVO> aprvListAll(@Param("reqSt") String reqSt);
	
	//결재문서 단건 상세
	AprvVO aprvSelect(AprvVO vo);
	
	//관리자  삭제
	int aprvAdminDel(AprvVO vo);
	
	// 관리자 전체 서식 목록 조회
	List<FormVO> aprvFormAll(@Param("formCat") String formCat);
	
	// 서식 단건 상세
	FormVO formSelect(FormVO vo);

	// 관리자 서식 삭제
	int formAdminDel(AprvVO vo);

	// 관리자 반려
	int aprvAdReject(ApprovalVO vo);

}
