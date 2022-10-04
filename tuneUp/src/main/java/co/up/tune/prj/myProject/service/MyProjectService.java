package co.up.tune.prj.myProject.service;

import java.util.List;

import co.up.tune.prj.vo.ProjectVO;
import co.up.tune.prj.vo.TeamVO;

public interface MyProjectService {

	List<ProjectVO> myPrjList(int empNo, int pageNo); //내프로젝트 리스트
	
	int checkTeam(TeamVO vo);  // 플젝 멤버 수
}
