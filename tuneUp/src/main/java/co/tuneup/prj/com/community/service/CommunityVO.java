package co.tuneup.prj.com.community.service;

import java.sql.Date;

public class CommunityVO {
	 int postNo;	//게시글번호
	 String ttl;	//제목
	 String wrtr;	//작성자
	 String cntn;	//내용
	 Date write_dt;		//작성일자
	 String fNm;	//파일이름
	 String fPath;	//파일위치
	 int hit;	//조회수
	 String emerg;	//긴급공지	
	 String typ;	//게시글유형
	 String empNo;	//사번
}
