package co.up.tune.aprv.aprvr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.up.tune.aprv.aprvList.mapper.AprvListMapper;
import co.up.tune.aprv.aprvr.mapper.AprvrMapper;

@Service
public class AprvrServiceImpl implements AprvrService {

	 @Autowired 
	 AprvListMapper apList;
	 @Autowired 
	 AprvrMapper aprvr;
	

	// 승인문서조회
	// 승인위임문서조회

	// 상세보기는 aprvList 사용

	// 기본결재라인조회 - 부서별 멤버
	// 기본결재라인등록
	// 기본결재라인수정
	// 기본결재라인삭제
	// 기본결재라인으로 결재자 생성

	// 결재상태조회
	// 결재 승인
	// 결재 반려

	// 위임자 등록
	// 위임자 수정
	// 위임자 삭제

}
