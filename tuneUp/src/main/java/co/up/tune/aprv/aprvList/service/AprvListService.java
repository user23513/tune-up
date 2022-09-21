package co.up.tune.aprv.aprvList.service;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import co.up.tune.aprv.vo.AprvCntnVO;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.AprvrVO;
import co.up.tune.aprv.vo.FormItemVO;
import co.up.tune.aprv.vo.FormVO;
import co.up.tune.aprv.vo.ItemCntnVO;
import co.up.tune.aprv.vo.TrustVO;

public interface AprvListService {

	
	//////////////////////////////////////READ
	// 관리자 전체 리스트
	List<AprvVO> aprvListAll();

	// 나의 신청 리스트
	List<AprvVO> aprvList(AprvVO vo);
	
	// 문서 단건 조회
	AprvVO aprvSelect(AprvVO vo); // 신청단건개요
	List<ItemCntnVO> cntnList(ItemCntnVO vo); // 결재내용목록 
	
	
	/////////////////////////////////////////문서 CUD
	// 문서 작성 - 결재자 설정 전까지 임시저장 상태
	int aprvInsert(AprvVO vo); // 결재문서입력
	int aprvCntnInsert(List<AprvCntnVO> list); // 문서내용입력 - 반복

	// 문서 수정 - 결재 전까지만
	int aprvUpdate(AprvVO vo); // 개요수정
	int aprvCntnUpdate(List<AprvCntnVO> list); // 내용수정 - 반복
	
	// 문서 삭제 - 결재 전까지만
	int aprvDelete(AprvVO vo); // 개요삭제
	int aprvCntnDelete(AprvCntnVO vo); // 문서내용 삭제

	/////////////////////////////////////////// 결재자  CRUD
	List<AprvrVO> aprvr(@Param("aprvNo") String aprvNo); // 조회
	int aprvrInsert(List<AprvrVO> list); // 등록 - 반복
	int aprvrUpdate(List<AprvrVO> list); // 수정 - 반복
	int aprvrDelete(AprvrVO vo); // 삭제

	
	//////////////////////////////////// 서식 CUD - 공용 체크 가능
	int formInsert(FormVO vo); // 서식작성
	int formItemInsert(List<FormItemVO> list); // 서식항목작성 - 반복
	// 서식 삭제
	int formDelete(FormVO vo); // 서식삭제
	int formItemDelete(FormItemVO vo); // 서식항목삭제
	// 서식 수정 - 공용 체크 가능
	int formUpdate(FormVO vo); // 서식수정
	int formItemUpdate(List<FormItemVO> list); // 서식항목수정 - 반복

}
