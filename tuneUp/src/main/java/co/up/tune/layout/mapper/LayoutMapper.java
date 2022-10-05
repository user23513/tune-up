package co.up.tune.layout.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.up.tune.prj.vo.TeamVO;

public interface LayoutMapper {

	List<TeamVO> prjTeamMembers(@Param("empNo")String empNo, @Param("dept")String dept); //layout 왼쪽에 보일 팀원들
}
