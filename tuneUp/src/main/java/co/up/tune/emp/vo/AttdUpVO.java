package co.up.tune.emp.vo;

import java.sql.Timestamp;

import lombok.Data;
@Data
public class AttdUpVO {
	int attdupNo; 	//신청번호
	String empNo; 	//사번
	String nm; 	//이름
	Timestamp atdcDt; 	//출근날짜
	Timestamp atdcDttm; 	//출근시간
	Timestamp afwkDttm; 	//퇴근시간
	String aContent; 	//사유
	String st;	//상태
	Timestamp aDate;  	//신청일자
	
	
	
}
