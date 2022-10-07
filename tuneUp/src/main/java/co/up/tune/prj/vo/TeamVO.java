package co.up.tune.prj.vo;


import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class TeamVO {
	 String empNo;	//사번
	 int prjNo;		//프로젝트 번호
	 String auth;	//권한
	 String nm;	//이름
	 String dept;	//부서
	 
	 String position; //직급
	 List<Integer> teamEmpNo; //팀원들 사원번호
	 String st;
}
