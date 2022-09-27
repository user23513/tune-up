package co.up.tune.aprv.vo;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AprvVO { //전자결재
	int aprvNo; //결재번호
	String empNo; //사번
	String ttl; //제목
	Date dttm; //작성일시
	String modYn; //수정여부
	String cntn; //결재내용
	String atchNo; //첨부파일번호
	String reqSt; //신청상태
	String aprvAuth; //공개여부
	String aprvEtc; //상신의견
	Date deadline; //마감일
	String impts; //중요도
	String reject; //반려사유
	String aprvSt; //승인상태

}
