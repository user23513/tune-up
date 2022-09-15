package co.tuneup.prj.apv.apprv.service;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class apprvVO { //전자결재
	int aprvNo; //결재번호
	int formNo; //서식번호
	String wrtr; //작성자
	String empNo; //사번
	String ttl; //제목
	Date dttm; //작성일시
	Date modDttm; //수정일시
	String cntn; //결재내용
	String atchNo; //첨부파일번호
}
