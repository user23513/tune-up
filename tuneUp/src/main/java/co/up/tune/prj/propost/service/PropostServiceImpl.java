package co.up.tune.prj.propost.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import co.up.tune.com.vo.ReplyVO;
import co.up.tune.file.service.testService;
import co.up.tune.prj.propost.mapper.PropostMapper;
import co.up.tune.prj.vo.FilesVO;
import co.up.tune.prj.vo.PostVO;

@Service
public class PropostServiceImpl implements PropostService {
	@Autowired
	PropostMapper map;

	@Autowired
	testService fmap;
	@Override
	public List<PostVO> prjPostList() {
		// 프로젝트 - 글 전체 리스트
		return map.prjPostList();
	}

	@Override
	public int prjPostInsert(PostVO vo) {
		// 프로젝트 - 글 등록
		return map.prjPostInsert(vo);
	}

	@Override
	public int prjPostUpdate(PostVO vo) {
		// 프로젝트 - 글 수정
		return map.prjPostUpdate(vo);
	}

	@Override
	public int prjPostDelete(PostVO vo) {
		// 프로젝트 - 글 삭제
		return map.prjPostDelete(vo);
	}

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

	public FilesVO fileUpload( FilesVO vo,@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		
		return fmap.fileUpload(file);
		
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