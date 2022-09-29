package co.up.tune.prj.myPrj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.up.tune.emp.vo.EmpVO;
import co.up.tune.prj.myPrj.mapper.MyPrjMapper;
import co.up.tune.prj.vo.ProjectVO;
import co.up.tune.prj.vo.TeamVO;
@Service
public class MyPrjServiceImpl implements MyPrjService {
	@Autowired
	MyPrjMapper map;
	
	@Override
	public List<ProjectVO> myPrjList(ProjectVO vo) {
		// TODO Auto-generated method stub
		return map.myPrjList(vo);
	}
	
	@Override
	public List<ProjectVO> finPrjList(ProjectVO vo) {
		// TODO Auto-generated method stub
		return map.finPrjList(vo);
	}

	@Override
	public List<EmpVO> empList() {
		// TODO Auto-generated method stub
		return map.empList();
	}

	@Override
	public int updateTeam(TeamVO vo) {
		// TODO Auto-generated method stub
		return map.updateTeam(vo);
	}

	@Override
	public int deleteTeam(TeamVO vo) {
		// TODO Auto-generated method stub
		return map.deleteTeam(vo);
	}

	@Override
	public int updateMng(TeamVO vo) {
		// TODO Auto-generated method stub
		return map.updateMng(vo);
	}

	@Override
	public int deleteMng(TeamVO vo) {
		// TODO Auto-generated method stub
		return map.deleteMng(vo);
	}

	@Override
	public int updateSt(ProjectVO vo) {
		// TODO Auto-generated method stub
		return map.updateSt(vo);
	}



}
