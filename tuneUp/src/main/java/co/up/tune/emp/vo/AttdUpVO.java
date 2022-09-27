package co.up.tune.emp.vo;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
public class AttdUpVO {
	int attdupNo; 	//신청번호
	String empNo; 	//사번
	String nm; 	//이름
	
	java.sql.Date atdcDt; 	//출근날짜
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	Date atdcDttm; 	//출근시간
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	Date afwkDttm; 	//퇴근시간
	
	String aContent; 	//사유
	String st;	//상태
	java.sql.Date aDate;  	//신청일자
	
	
	
}
