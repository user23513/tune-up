package co.up.tune.prj.prjMng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.up.tune.emp.vo.EmpVO;
import co.up.tune.prj.vo.ProjectVO;
import co.up.tune.prj.vo.TeamVO;

public interface PrjMngMapper {
	
	
	List<TeamVO> teamList(int prjNo); // 멤버리스트
	List<TeamVO> authList(int prjNo); // 관리자리스트
	
	List<EmpVO> addTeamList(EmpVO vo); //트리뷰
	
	int addTeam(TeamVO vo); // 멤버추가

	int removeTeam(TeamVO vo); // 멤버삭제

	int teamAuth(TeamVO vo); // 관리자 추가

	int removeAuth(TeamVO vo);// 관리자 삭제
	
	int prjSt(ProjectVO vo); //프로젝트 상태 변경
	
	ProjectVO pjSelect(ProjectVO vo);
	/////////아래는 테스트용/////////////
	
	int addTeamList(@Param("vo")TeamVO vo, @Param("addTeamList")List<TeamVO> addTeamList); //새 멤버 추가
	List<TeamVO> addTeamList(List<String> teamEmpNo); //새 프로젝트에서 입력한 사원들 정보 가져오기
}
