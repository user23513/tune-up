package co.up.tune.prj.prjMng.mapper;

import java.util.List;

import co.up.tune.emp.vo.EmpVO;
import co.up.tune.prj.vo.ProjectVO;
import co.up.tune.prj.vo.TeamVO;

public interface PrjMngMapper {
	
	
	List<TeamVO> teamList(int prjNo); // 멤버리스트
	List<TeamVO> authList(); // 관리자리스트
	
	List<EmpVO> addTeamList(); //멤버추가 주소록
	
	int addTeam(TeamVO vo); // 멤버추가

	int removeTeam(TeamVO vo); // 멤버삭제

	int teamAuth(TeamVO vo); // 관리자 추가

	int removeAuth(TeamVO vo);// 관리자 삭제
	
	int prjSt(ProjectVO vo); //프로젝트 상태 변경
}
