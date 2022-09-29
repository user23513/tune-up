package co.up.tune.prj.propost.service;

import java.util.List;

import co.up.tune.com.vo.ReplyVO;
import co.up.tune.emp.vo.AttdVO;
import co.up.tune.emp.vo.EmpVO;
import co.up.tune.prj.vo.FilesVO;
import co.up.tune.prj.vo.PostVO;

public interface PropostService {
	
	List<PostVO> prjPostList();	//내 프로젝트 - (모든 사람)글 
	PostVO prjPostSelect(PostVO vo); // 프로젝트-글 단건
	int prjPostInsert(PostVO vo); //프로젝트-글 등록
	int prjPostUpdate(PostVO vo); //프로젝트-글 수정
	int prjPostDelete(PostVO vo); //프로젝트-글 삭제

	List<ReplyVO> ppReplyList(ReplyVO vo); // 댓글 리스트
	ReplyVO ppReplySelect(ReplyVO vo); //댓글 조회
	int ppReplyInsert(ReplyVO vo); // 댓글 등록
	int ppReplyDelete(ReplyVO vo); // 댓글 삭제
	ReplyVO ppreplySelect(ReplyVO vo);

	FilesVO filesSelect(FilesVO fvo); //파일 단건
	int filesInsert(FilesVO fvo); //파일등록
	int filesDelete(FilesVO fvo); //파일삭제
	
	/* 현지 수정 */
	List<EmpVO> empList(); //모든 사원정보
	
 
	
//	FilesVO filesSelect(FilesVO vo); //파일 단건
//	int filesInsert(FilesVO vo); //파일등록
//	int filesDelete(FilesVO vo); //파일삭제
}
