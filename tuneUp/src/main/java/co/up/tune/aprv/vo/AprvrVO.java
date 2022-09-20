package co.up.tune.aprv.vo;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AprvrVO { //결재자
	
	String aprvr;//결재자 사번
	int aprvNo; //결재번호
	Timestamp appvDttm; //결재일시
	String recaResn; //반려사유
	int aprvSeq; //결재순서
	String aprvSt;//결재상태
	
}