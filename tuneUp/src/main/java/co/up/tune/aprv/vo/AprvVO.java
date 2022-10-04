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
	String cntn; //결재내용
	String fNm;	//파일이름
	String fPath;	//파일위치
	String reqSt; //신청상태
	String aprvEtc; //상신의견
	String deadline; //마감일
	String impts; //중요
	String nm;
	//=========테이블에 없는값
	String aprvSt; 
	String aprvr;
	String refer;
	String deadDay;
	String deadTime;
}
