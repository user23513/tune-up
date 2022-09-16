package co.up.tune.com.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommunityVO {
	 int postNo;	//게시글번호
	 String ttl;	//제목
	 String wrtr;	//작성자
	 String cntn;	//내용
	 Date writeDt;		//작성일자
	 String fNm;	//파일이름
	 String fPath;	//파일위치
	 int hit;	//조회수
	 String emerg;	//긴급공지	
	 String typ;	//게시글유형
	 String empNo;	//사번
}
