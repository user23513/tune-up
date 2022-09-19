package co.up.tune.prj.vo;

import java.util.Date;

import lombok.Data;
@Data
public class PostVO {
	 int postNo;	//게시글 번호
	 String empNo;	//사번
	 String wrtr;	//작성자
	 String ttl;	//제목
	 String cntn;	//내용
	 Date dttm;		//작성일시
	 int atchNo;	//첨부파일 번호
	 int prjNo;		//프로젝트 번호
}
