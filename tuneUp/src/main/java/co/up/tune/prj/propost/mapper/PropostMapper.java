package co.up.tune.prj.propost.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import co.up.tune.com.vo.ReplyVO;
import co.up.tune.emp.vo.EmpVO;
import co.up.tune.prj.vo.BusinessVO;
import co.up.tune.prj.vo.FilesVO;
import co.up.tune.prj.vo.MemberVO;
import co.up.tune.prj.vo.PostVO;
import co.up.tune.prj.vo.ProjectVO;
import co.up.tune.prj.vo.ScheduleVO;
import co.up.tune.prj.vo.TeamVO;

public interface PropostMapper {
	List<PostVO> prjPostList(int prjNo);	//내 프로젝트 글 모아보기(전체조회)
	int prjPostInsert(PostVO vo); //프로젝트-글 등록
	int prjPostUpdate(@Param("pvo")PostVO pvo, @Param("fvo")FilesVO fvo); //프로젝트-글 수정
	PostVO prjPostSelect(PostVO vo); // 프로젝트-글 단건
	
	//댓글
	List<ReplyVO> pjReplyList(ReplyVO vo); //댓글 리스트
	ReplyVO pjReplySelect(ReplyVO vo); //댓글 조회
	int pjReplyInsert(ReplyVO vo); //댓글 등록
	int pjReplyUpdate(ReplyVO vo); //댓글 수정
	int pjReplyDelete(ReplyVO vo); //댓글 삭제
	
	/* 현지 수정 */
	List<EmpVO> empList(String empNo); //모든 사원정보
	List<MemberVO> scheduleMemberList(int prjNo); //프로젝트 일정 => 멤버 리스트
	int prjFileInsert(FilesVO vo); //프로젝트 파일 등록
	List<ReplyVO> prjReplyList(); //프로젝트 전체 댓글
	List<FilesVO> prjPostFiles(int prjNo); //해당 게시글에 파일정보 가져오기
	int postDelete(@Param("postNo")int postNo, @Param("type")String type); //게시글 삭제
	List<BusinessVO> businessList(int prjNo); //프로젝트 업무 리스트
	
	int isAuth(TeamVO vo);
	
	//정은 프로젝트정보+ 
	ProjectVO projectSel(ProjectVO vo);
	
}
