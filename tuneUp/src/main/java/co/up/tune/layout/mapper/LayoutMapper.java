package co.up.tune.layout.mapper;

import java.util.List;

import co.up.tune.prj.vo.TeamVO;

public interface LayoutMapper {

	List<TeamVO> prjTeamMembers(String empNo); //layout 왼쪽에 보일 팀원들
}
