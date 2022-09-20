package co.up.tune.aprv.vo;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AprvVO { //전자결재
	int aprvNo; //결재번호
	int formNo; //서식번호
	String wrtr; //작성자
	String empNo; //사번
	String ttl; //제목
	Timestamp dttm; //작성일시
	Timestamp modDttm; //수정일시
	String cntn; //결재내용
	String atchNo; //첨부파일번호
	String tempSt; //임시저장
	String aprvSt; //결재상태
	String aprvr; //결재자
}
