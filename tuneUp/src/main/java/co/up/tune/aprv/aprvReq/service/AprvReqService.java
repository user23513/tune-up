package co.up.tune.aprv.aprvReq.service;

import java.util.List;
import co.up.tune.aprv.vo.AprvVO;

public interface AprvReqService {

	List<AprvVO> aprvList(AprvVO vo);
	
	
	


	/*
	 * //나의 신청 리스트 List<AprvVO> aprvList(AprvVO vo, @Param("catSt") String catSt);
	 * 
	 * //문서 단건 조회 AprvVO aprvSelect(AprvVO vo); // 신청단건개요 List<ReferVO>
	 * cntnList(ReferVO vo); // 결재내용목록
	 * 
	 * 
	 * /////////////////////////////////////////문서 CUD //문서 작성 - 결재자 설정 전까지 임시저장 상태
	 * int aprvInsert(AprvVO vo); // 결재문서입력 int aprvCntnInsert(List<AprvCntnVO>
	 * list); // 문서내용입력 - 반복
	 * 
	 * //문서 수정 - 결재 전까지만 int aprvUpdate(AprvVO vo); // 개요수정 int
	 * aprvCntnUpdate(List<AprvCntnVO> list); // 내용수정 - 반복
	 * 
	 * //문서 삭제 - 결재 전까지만 int aprvDelete(AprvVO vo); // 개요삭제 int
	 * aprvCntnDelete(AprvCntnVO vo); // 문서내용 삭제
	 * 
	 * /////////////////////////////////////////// 결재자 CRUD List<AprvrVO>
	 * aprvr(@Param("aprvNo") String aprvNo); // 조회 int aprvrInsert(List<AprvrVO>
	 * list); // 등록 - 반복 int aprvrUpdate(List<AprvrVO> list); // 수정 - 반복 int
	 * aprvrDelete(AprvrVO vo); // 삭제
	 * 
	 * 
	 * ////////////////////////////////////서식 CUD - 공용 체크 가능 int formInsert(FormVO
	 * vo); // 서식작성 int formItemInsert(List<FormItemVO> list); // 서식항목작성 - 반복 //서식
	 * 삭제 int formDelete(FormVO vo); // 서식삭제 int formItemDelete(FormItemVO vo); //
	 * 서식항목삭제 //서식 수정 - 공용 체크 가능 int formUpdate(FormVO vo); // 서식수정 int
	 * formItemUpdate(List<FormItemVO> list); // 서식항목수정 - 반복
	 */
	

	/*
	 * //리스트 -수정 pdf 전체 전송(수정가능) 반려(수정재상신) 검토(불가) 완료(불가)
	 * 
	 * //작성 -결재라인 수정 문서작성하기 공용서식// 나의서식 /// 임시저장
	 * 
	 * //조회 - 위임자설정 전체 진행 위임 참조 반려 완료
	 * 
	 * 
	 * ---기능 임시저장 서식저장 확인상태 수정가능상태 공개여부 마감일자 중요도 위임 결재라인 반려승인전결
	 */

}
