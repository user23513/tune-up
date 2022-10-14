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
import co.up.tune.prj.vo.ProjectVO;
import co.up.tune.prj.vo.TeamVO;

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
		int a = 0;
		int b = 0;
		fvo.setAtchNo(0);
		//프로젝트 파일 등록
		if(fvo.getFNm() != null) {
			fvo.setAtchNo(pvo.getAtchNo());
			b = map.prjFileInsert(fvo);
		}
		pvo.setAtchNo(fvo.getAtchNo());
		map.prjPostInsert(pvo);
		return a+b;
	}

	@Override
	public int prjPostUpdate(PostVO vo, FilesVO fvo) {
		// 프로젝트 - 글 수정
		return map.prjPostUpdate(vo, fvo);
	}

	@Override
	public PostVO prjPostSelect(PostVO vo) {
		// TODO Auto-generated method stub
		return map.prjPostSelect(vo);
	}

	//모든 사원정보
	@Override
	public List<EmpVO> empList(String empNo) {
		return map.empList(empNo);
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

	@Override
	public List<ReplyVO> pjReplyList(ReplyVO vo) {
		// TODO Auto-generated method stub
		return map.pjReplyList(vo);
	}

	@Override
	public ReplyVO pjReplySelect(ReplyVO vo) {
		// TODO Auto-generated method stub
		return map.pjReplySelect(vo);
	}

	@Override
	public int pjReplyInsert(ReplyVO vo) {
		// TODO Auto-generated method stub
		return map.pjReplyInsert(vo);
	}

	@Override
	public int pjReplyUpdate(ReplyVO vo) {
		// TODO Auto-generated method stub
		return map.pjReplyUpdate(vo);
	}

	@Override
	public int pjReplyDelete(ReplyVO vo) {
		// TODO Auto-generated method stub
		return map.pjReplyDelete(vo);
	}

	@Override
	public boolean isAuth(String empNo, int prjNo) {
		// TODO Auto-generated method stub
		TeamVO vo = new TeamVO();
		vo.setEmpNo(empNo);
		vo.setPrjNo(prjNo);
		
		return map.isAuth(vo) > 0;
	}

	@Override
	public ProjectVO projectSel(ProjectVO vo) {
		return map.projectSel(vo);
	}
	
}