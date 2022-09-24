package co.up.tune.aprv.aprvAdmin.service;

import java.util.List;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.ApprovalVO;
import co.up.tune.aprv.vo.FormVO;
import co.up.tune.aprv.vo.ReferVO;

public interface AprvAdminService { // 전자결재 관리자

	//////////결재문서
	//관리자 전체 결재문서 목록 조회
	List<AprvVO> aprvListAll();
	//결재문서 단건 상세
	AprvVO aprvSelect(AprvVO vo);
	
	//관리자 결재문서 + 결재자 + 참조 삭제
	int aprvAdminDel(AprvVO vo);
	//결재문서 결재자 삭제
	//int aprvAdminAprvrDel();
	//결재문서 참조 삭제
	//int aprvAdminReferDel(ReferVO vo);
	

	//관리자 문서 공개여부+중요도+반려 수정
	int aprvAdminUp(AprvVO vo);
	//관리자 결재문서 공개여부 수정
	//int aprvAdminAuthUp(AprvVO vo);
	//관리자 결재문서 중요도 수정
	//int aprvAdminImptsUp(AprvVO vo);
	//관리자 결재문서 강제반려
	//int aprvAdminRejectUp(AprvVO vo);
	//관리자 결재문서 참조 수정 - 반복
	int aprvAdminReferUp(List<ReferVO> list);

	
	////////// 서식
	// 관리자 전체 서식 목록 조회
	List<FormVO> aprvFormAll();
	// 서식 단건 상세
	FormVO formSelect(FormVO vo);

	// 관리자 서식 삭제
	int formAdminDel(AprvVO vo);

	// 관리자 서식 공개여부+카테고리+내용 수정 
	int formAdminUp(AprvVO vo);
	//관리자 서식 공개여부 수정
	//int formAdminAuthUp(AprvVO vo);
	//관리자 서식 카테고리 수정
	//int formAdminCatUp(AprvVO vo);
	//관리자 서식 내용 수정
	//int formAdminCntnUp(AprvVO vo);


}
