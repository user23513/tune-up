package co.up.tune.aprvList.service;

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
	

			// 나의 신청 리스트
			List<AprvVO> aprvList(AprvVO vo);

			
			// 문서 조회
			AprvVO aprvSelect(AprvVO vo); // 신청단건개요
			List<ItemCntnVO> cntnList(@Param("aprvNo") String aprvNo); // 결재내용목록
			List<AprvrVO> aprvr(@Param("aprvNo") String aprvNo); // 결재자목록
			TrustVO trustSelect(TrustVO vo); // 위임자확인

			
			// 문서 작성 - 결재자 설정 전까지 임시저장
			int aprvInsert(AprvVO vo); // 결재문서입력
			int aprvCntnInsert(List<AprvCntnVO> list); // 문서내용입력 - 반복
			int aprvrInsert(List<AprvrVO> list); // 결재자입력 - 반복

			
			// 서식 작성 - 공용 체크 가능
			int formInsert(FormVO vo); // 새서식작성
			int formItemInsert(List<FormItemVO> list); // 서식항목작성 - 반복

			
			// 서식 삭제
			int formDelete(FormVO vo); // 서식삭제
			int formItemDelete(List<FormItemVO> list); // 서식항목삭제 - 반복
			
			// 문서 수정 - 결재 전까지만
			int aprvUpdate(AprvVO vo); // 개요수정
			int aprvCntnUpdate(List<AprvCntnVO> list); // 내용수정 - 반복
			int aprvrUpdate(List<AprvrVO> list); // 결재자수정 - 반복

			
			// 문서 삭제 - 결재 전까지만
			int aprvDelete(AprvVO vo); // 개요삭제
			int aprvCntnDelete(List<AprvCntnVO> list); //문서내용 삭제 - 반복
			int aprvrDelete(AprvrVO vo); // 결재자삭제 - 반복

}
