package co.up.tune.prj.prjMng.service;

import java.util.List;

import co.up.tune.emp.vo.EmpVO;
import co.up.tune.prj.vo.ProjectVO;
import co.up.tune.prj.vo.TeamVO;

public interface PrjMngService {

	// 프로젝트 관리자 창
	
	List<TeamVO> teamList(int prjNo); // 멤버리스트
	List<TeamVO> authList(int prjNo); // 관리자리스트

	List<EmpVO> tdeptList(EmpVO vo); //멤버추가 주소록
	int teamInsert(TeamVO vo); // 멤버추가

	int removeTeam(TeamVO vo); // 멤버삭제

	int teamAuth(TeamVO vo); // 관리자 추가

	int removeAuth(TeamVO vo);// 관리자 삭제
	
	int prjSt(ProjectVO vo); //프로젝트 상태 변경
	
	ProjectVO pjSelect(ProjectVO vo);
	
	TeamVO tmSelect(TeamVO vo);
	///////////////
	//int addTeam(TeamVO vo);
}
