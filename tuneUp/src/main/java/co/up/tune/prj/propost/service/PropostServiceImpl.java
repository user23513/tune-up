package co.up.tune.prj.propost.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.up.tune.com.vo.ReplyVO;
import co.up.tune.emp.vo.EmpVO;
import co.up.tune.prj.propost.mapper.PropostMapper;
import co.up.tune.prj.vo.BusinessVO;
import co.up.tune.prj.vo.FilesVO;
import co.up.tune.prj.vo.MemberVO;
import co.up.tune.prj.vo.PostVO;
import co.up.tune.prj.vo.ScheduleVO;

@Service
public class PropostServiceImpl implements PropostService {
	@Autowired
	PropostMapper map;

	@Override
	public List<PostVO> prjPostList(int prjNo) {
		// 프로젝트 - 글 전체 리스트
		return map.prjPostList(prjNo);
	}

	//글 등록
	@Override
	public int prjPostInsert(PostVO pvo, FilesVO fvo) {
		//프로젝트 글 등록
		int a = map.prjPostInsert(pvo);
		fvo.setAtchNo(pvo.getAtchNo());
		//프로젝트 파일 등록
		int b = map.prjFileInsert(fvo);
		return a+b;
	}

	@Override
	public int prjPostUpdate(PostVO vo, FilesVO fvo) {
		// 프로젝트 - 글 수정
		return map.prjPostUpdate(vo, fvo);
	}

//	@Override
//	public int prjPostDelete(PostVO vo) {
//		// 프로젝트 - 글 삭제
//		return map.prjPostDelete(vo);
//	}

	@Override
	public List<ReplyVO> ppReplyList(ReplyVO vo) {
		// 댓글 리스트
		return map.ppReplyList(vo);
	}


	@Override
	public int ppReplyDelete(ReplyVO vo) {
		// 댓글 삭제
		return map.ppReplyDelete(vo);
	}

	@Override
	public int ppReplyInsert(ReplyVO vo) {
		// 댓글 등록
		return map.ppReplyInsert(vo);
	}

	@Override
	public ReplyVO ppReplySelect(ReplyVO vo) {
		// TODO Auto-generated method stub
		return map.ppReplySelect(vo);
		
	}

	@Override
	public PostVO prjPostSelect(PostVO vo) {
		// TODO Auto-generated method stub
		return map.prjPostSelect(vo);
	}

	@Override
	public ReplyVO ppreplySelect(ReplyVO vo) {
		// TODO Auto-generated method stub
		return map.ppreplySelect(vo);
	}

	@Override
	public FilesVO filesSelect(FilesVO fvo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int filesInsert(FilesVO fvo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int filesDelete(FilesVO fvo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//모든 사원정보
	@Override
	public List<EmpVO> empList() {
		return map.empList();
	}

	//프로젝트 일정 => 멤버 리스트
	@Override
	public List<MemberVO> scheduleMemberList(int prjNo) {
		return map.scheduleMemberList(prjNo);
	}

	//프로젝트 전체 댓글
	@Override
	public List<ReplyVO> prjReplyList() {
		return map.prjReplyList();
	}

	//해당 게시글에 파일정보 가져오기
	@Override
	public List<FilesVO> prjPostFiles(int prjNo) {
		return map.prjPostFiles(prjNo);
	}

	//게시글 삭제
	@Override
	public int postDelete(int postNo, String type) {
		return map.postDelete(postNo, type);
	}

	//프로젝트 업무 리스트
	@Override
	public List<BusinessVO> businessList(int prjNo) {
		return map.businessList(prjNo);
	}
	
	 
	//파일
//	@Override
//	public FilesVO filesSelect(FilesVO vo) {
//		// TODO Auto-generated method stub
//		return map.filesSelect(vo);
//	}
//
//	@Override
//	public int filesInsert(FilesVO vo) {
//		// TODO Auto-generated method stub
//		return map.filesInsert(vo);
//	}
//
//	@Override
//	public int filesDelete(FilesVO vo) {
//		// TODO Auto-generated method stub
//		return map.filesDelete(vo);
//	}

	
}