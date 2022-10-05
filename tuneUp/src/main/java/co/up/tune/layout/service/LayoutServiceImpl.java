package co.up.tune.layout.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.up.tune.layout.mapper.LayoutMapper;
import co.up.tune.prj.vo.TeamVO;

@Service
public class LayoutServiceImpl implements LayoutService {
	
	@Autowired
	LayoutMapper map;

	//layout 왼쪽에 보일 팀원들
	@Override
	public List<TeamVO> prjTeamMembers(String empNo, String dept) {
		return map.prjTeamMembers(empNo, dept);
	}

}
