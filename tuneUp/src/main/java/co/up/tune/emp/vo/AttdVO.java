package co.up.tune.emp.vo;

 

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
public class AttdVO {
	java.sql.Date atdcDt;	//출근날짜
	String empNo;	//사번
	String nm;	//이름
	String dept;		//부서명
	String position;	//직위
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	Date atdcDttm;		//출근시간
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	Date afwkDttm;	//퇴근시간
	
	Long wktm;	//하루근무 (분)
	Long ovtm;	//하루연장근무 (분)
	
	Long wktmH;
	Long ovtmH;
	
	String st;	//상태
	
}
