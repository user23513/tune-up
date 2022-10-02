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
		// TODO Auto-generated method stub
		return map.teamList(prjNo);
	}
	
	@Override
	public List<TeamVO> authList(int prjNo) {
		// TODO Auto-generated method stub
		return map.authList(prjNo);
	}

	@Override
	public List<EmpVO> addTeamList() {
		// TODO Auto-generated method stub
		return map.addTeamList();
	}

	@Override
	public int addTeam(TeamVO vo) {
		// TODO Auto-generated method stub
		return map.addTeam(vo);
	}

	@Override
	public int removeTeam(TeamVO vo) {
		// TODO Auto-generated method stub
		return map.removeTeam(vo);
	}

	@Override
	public int teamAuth(TeamVO vo) {
		// TODO Auto-generated method stub
		return map.teamAuth(vo);
	}

	@Override
	public int removeAuth(TeamVO vo) {
		// TODO Auto-generated method stub
		return map.removeAuth(vo);
	}

	@Override
	public int prjSt(ProjectVO vo) {
		// TODO Auto-generated method stub
		return map.prjSt(vo);
	}

	 

}
