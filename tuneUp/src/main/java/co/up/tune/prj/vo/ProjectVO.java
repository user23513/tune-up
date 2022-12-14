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
	 
	 int cnt; 		//해당 프로젝트를 진행중인 팀원 수
	 List<String> teamEmpNo; //팀원들 사원번호
	 String LeaderEmpNo; //등록한 팀장 사원번호
}
