package co.up.tune.prj.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.up.tune.prj.project.mapper.ProjectMapper;
import co.up.tune.prj.vo.ProjectVO;
import co.up.tune.prj.vo.TeamVO;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	ProjectMapper map;

	//새 프로젝트 등록
	@Override
	public int newProjectInsert(ProjectVO vo) {
		//새 프로젝트 팀원들 정보 가져오기
		List<TeamVO> list = map.teamList(vo.getTeamEmpNo());
		int cnt = map.newProjectInsert(vo, list);
		return cnt;
	}

}
