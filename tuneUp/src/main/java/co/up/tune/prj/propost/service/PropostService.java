package co.up.tune.prj.propost.service;

import java.util.List;

import co.up.tune.prj.vo.PostVO;

public interface PropostService {
	
	List<PostVO> postList();	//내 프로젝트 - 글 
	
	int postInsert(PostVO vo); //프로젝트-글 등록
	int postUpdate(PostVO vo); //프로젝트-글 수정
	int postDelete(PostVO vo); //프로젝트-글 삭제

	
}
