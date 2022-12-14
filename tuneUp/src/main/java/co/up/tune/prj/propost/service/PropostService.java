package co.up.tune.prj.propost.service;

import java.util.List;

import co.up.tune.com.vo.ReplyVO;
import co.up.tune.emp.vo.EmpVO;
import co.up.tune.prj.vo.BusinessVO;
import co.up.tune.prj.vo.FilesVO;
import co.up.tune.prj.vo.MemberVO;
import co.up.tune.prj.vo.PostVO;
import co.up.tune.prj.vo.ProjectVO;

public interface PropostService {
	
	List<PostVO> prjPostList(int prjNo);	//내 프로젝트 - (모든 사람)글 
	PostVO prjPostSelect(PostVO vo); // 프로젝트-글 단건
	int prjPostInsert(PostVO pvo, FilesVO fvo); //프로젝트-글 등록
	int prjPostUpdate(PostVO vo, FilesVO fvo); //프로젝트-글 수정

	//댓글
	List<ReplyVO> pjReplyList(ReplyVO vo); //댓글 리스트
	ReplyVO pjReplySelect(ReplyVO vo); //댓글 조회
	int pjReplyInsert(ReplyVO vo); //댓글 등록
	int pjReplyUpdate(ReplyVO vo); //댓글 수정
	int pjReplyDelete(ReplyVO vo); //댓글 삭제

	/* 현지 수정 */
	List<EmpVO> empList(String empNo); //모든 사원정보
	List<MemberVO> scheduleMemberList(int prjNo); //프로젝트 일정 => 멤버 리스트
	List<ReplyVO> prjReplyList(); //프로젝트 전체 댓글
	List<FilesVO> prjPostFiles(int prjNo); //해당 게시글에 파일정보 가져오기
	int postDelete(int postNo, String type); //게시글 삭제
	List<BusinessVO> businessList(int prjNo); //프로젝트 업무 리스트
	
	//관리버튼 관리자 권한 체크
	boolean isAuth(String empNo, int prjNo);
	
	//정은 프로젝트정보+ 
	ProjectVO projectSel(ProjectVO vo);
}
