package co.up.tune.aprv.vo;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApprovalVO { //결재자
	
	String aprvr;//결재자 사번
	int aprvNo; //결재번호
	Timestamp aprvDttm; //결재일시
	String sign; //서명파일
	String checked;//확인여부
	int aprvSeq; //결재순서
	String aprvSt;//승인상태
	String reject; //반려사유
	
}