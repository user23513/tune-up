package co.up.tune.prj.myPrj.service;

import java.util.List;

import co.up.tune.emp.vo.EmpVO;
import co.up.tune.prj.vo.ProjectVO;
import co.up.tune.prj.vo.TeamVO;

public interface MyPrjService {
	//내 프로젝트
		List<ProjectVO> myPrjList(ProjectVO vo);
		//내 프로젝트 -완료
		List<ProjectVO> finPrjList(ProjectVO vo);
		
		//모든 사원정보
		List<EmpVO> empList(); 
		
		//멤버 추가
		int updateTeam(TeamVO vo);
		//멤버 삭제
		int deleteTeam(TeamVO vo);
		
		//관리자 추가
		int updateMng(TeamVO vo);
		//관리자 삭제
		int deleteMng(TeamVO vo);
		
		// 상태 업데이트
		int updateSt(ProjectVO vo);
}
