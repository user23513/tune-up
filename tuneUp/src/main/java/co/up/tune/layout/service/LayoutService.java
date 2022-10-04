package co.up.tune.layout.service;

import java.util.List;

import co.up.tune.prj.vo.TeamVO;

public interface LayoutService {

	List<TeamVO> prjTeamMembers(String empNo); //layout 왼쪽에 보일 팀원들
}
