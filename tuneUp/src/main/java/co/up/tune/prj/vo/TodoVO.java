package co.up.tune.prj.vo;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class TodoVO {
	 int postNo;	//게시글번호
	 String empNo;	//사번
	 String ttl;	//제목
	 String wrtr;	//작성자
	 Timestamp dttm; 	//작성일시	
	 int prjNo;		//프로젝트번호
}
