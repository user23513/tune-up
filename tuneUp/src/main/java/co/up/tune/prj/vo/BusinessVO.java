package co.up.tune.prj.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessVO {	
	int postNo;		//게시글 번호
	 String bussTtl;	//제목
	 String empNo;	//사번
	 String wrtr;	//작성자
	 String st;	//상태
	 Date sdt;	//시작일
	 Date edt;	//종료일
	 String term;	//기간 null
	 String cntn;	//업무내용
	 String sub;	//종속성 null
	 int prog;		//진행률
	 int atchNo;	//첨부파일번호
	 int prjNo;		//프로젝트번호
}
