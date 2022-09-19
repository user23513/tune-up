package co.up.tune.prj.propost.mapper;

import java.util.List;

import co.up.tune.prj.vo.PostVO;

public interface PropostMapper {
	List<PostVO> prjPostList();	//내 프로젝트 글 모아보기
	int prjPostInsert(PostVO vo); //프로젝트-글 등록
	int prjPostUpdate(PostVO vo); //프로젝트-글 수정
	int prjPostDelete(PostVO vo); //프로젝트-글 삭제
}
