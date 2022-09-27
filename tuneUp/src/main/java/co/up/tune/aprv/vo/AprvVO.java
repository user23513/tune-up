package co.up.tune.aprv.vo;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AprvVO { //전자결재
	int aprvNo; //결재번호
	String empNo; //사번
	String ttl; //제목
	Timestamp dttm; //작성일시
	Timestamp modDttm; //수정일시
	String cntn; //결재내용
	String atchNo; //첨부파일번호
	String reqSt; //신청상태
	String aprvAuth; //공개여부
	String aprvEtc; //상신의견
	Timestamp deadline; //마감일
	String impts; //중요도
	String reject; //반려사유

}
