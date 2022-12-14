package co.up.tune.prj.prjMng.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.up.tune.emp.vo.EmpVO;
import co.up.tune.prj.prjMng.mapper.PrjMngMapper;
import co.up.tune.prj.vo.ProjectVO;
import co.up.tune.prj.vo.TeamVO;

@Service
public class PrjMngServiceImpl implements PrjMngService {
	@Autowired
	PrjMngMapper map;
	
	@Override
	public List<TeamVO> teamList(int prjNo) {
		// 플젝 - 멤버리스트
		return map.teamList(prjNo);
	}
	
	@Override
	public List<TeamVO> authList(int prjNo) {
		// 플젝 - 팀장 리스트
		return map.authList(prjNo);
	}

	@Override
	public List<EmpVO> tdeptList(EmpVO vo) {
		// 트리뷰
		return map.tdeptList(vo);
	}
	

	@Override
	public int teamInsert(TeamVO vo) {
		// 플젝 - 멤버추가
		return map.teamInsert(vo);
	}

	@Override
	public int removeTeam(TeamVO vo) {
		// 플젝 - 멤버 삭제
		return map.removeTeam(vo);
	}

	@Override
	public int teamAuth(TeamVO vo) {
		// 플젝 - 팀장 권한 부여
		return map.teamAuth(vo);
	}

	@Override
	public int removeAuth(TeamVO vo) {
		// 플젝 - 팀장 권한 삭제
		return map.removeAuth(vo);
	}

	@Override
	public int prjSt(ProjectVO vo) {
		// 플젝 - 상태 
		return map.prjSt(vo);
	}

	@Override
	public ProjectVO pjSelect(ProjectVO vo) {
		// TODO Auto-generated method stub
		return map.pjSelect(vo);
	}

	@Override
	public TeamVO tmSelect(TeamVO vo) {
		// TODO Auto-generated method stub
		return map.tmSelect(vo);
	}


	@Override
	public List<EmpVO> mEmpList() {
		// TODO Auto-generated method stub
		return map.mEmpList();
	}

	@Override
	public List<EmpVO> mEmpListByPrj(String prjNo) {
		// TODO Auto-generated method stub
		return map.mEmpListByPrj(prjNo);
	}


}
