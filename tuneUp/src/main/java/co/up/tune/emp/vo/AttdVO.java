package co.up.tune.emp.vo;

import java.sql.Timestamp;

public class AttdVO {
	Timestamp atdcDt;	//출근날짜
	String empNo;	//사번
	String nm;	//이름
	String dept;		//부서명
	String position;		//직위
	Timestamp atdcDttm;		//출근시간
	Timestamp afwkDttm;	//퇴근시간
	Timestamp wktm;	//하루근무
	Timestamp ovtm;	//하루연장근무
	String st;	//상태
}
