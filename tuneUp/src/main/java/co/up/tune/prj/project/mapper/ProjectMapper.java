package co.up.tune.prj.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.up.tune.prj.vo.ProjectVO;
import co.up.tune.prj.vo.TeamVO;

public interface ProjectMapper {

	int newProjectInsert(@Param("vo")ProjectVO vo, @Param("teamList")List<TeamVO> teamList); //새 프로젝트 등록
	List<TeamVO> teamList(List<Integer> teamEmpNo); //새 프로젝트에서 입력한 사원들 정보 가져오기
	
}