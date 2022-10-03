package co.up.tune.prj.vo;

import java.sql.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ProjectVO {
	 int prjNo;		//프로젝트 번호
	 String nm;		//프로젝트 이름
	 String cntn;	//프로젝트 내용
	 int prog;		//진행률
	 String st;		//상태
	 Date dt;		//작성일자
	 Date sdt;		//시작일
	 Date edt;		//종료일
	 
	 List<Integer> teamEmpNo; //팀원들 사원번호
}
