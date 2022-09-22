package co.up.tune.prj.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ScheduleVO {
	 int postNo;		//게시글 번호
	 String empNo;		//사번
	 String wrtr;		//작성자
	 Date sdt;		//시작일
	 Date edt;		//종료일
	 String place;		//장소
	 String cntn;	//일정내용
	 int atchNo;	//첨부파일번호
	 int prjNo;		//프로젝트번호
}
