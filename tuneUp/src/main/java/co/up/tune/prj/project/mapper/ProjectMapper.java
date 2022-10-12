package co.up.tune.prj.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.up.tune.com.vo.ReplyVO;
import co.up.tune.prj.vo.PostVO;
import co.up.tune.prj.vo.ProjectVO;
import co.up.tune.prj.vo.TeamVO;

public interface ProjectMapper {

	int newProjectInsert(@Param("vo")ProjectVO vo, @Param("teamList")List<TeamVO> teamList); //새 프로젝트 등록
	List<TeamVO> teamList(List<String> teamEmpNo); //새 프로젝트에서 입력한 사원들 정보 가져오기
	List<PostVO> myPost(PostVO vo); 
	List<ReplyVO> myReply(ReplyVO vo);
}
