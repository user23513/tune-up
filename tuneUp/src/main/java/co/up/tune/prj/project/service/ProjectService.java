package co.up.tune.prj.project.service;

import java.util.List;

import co.up.tune.com.vo.ReplyVO;
import co.up.tune.prj.vo.PostVO;
import co.up.tune.prj.vo.ProjectVO;

public interface ProjectService {

	int newProjectInsert(ProjectVO vo); //새 프로젝트 등록
	List<ReplyVO> myReply(ReplyVO vo);
	
}
