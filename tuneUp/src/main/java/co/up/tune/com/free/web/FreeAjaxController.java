package co.up.tune.com.free.web;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import co.up.tune.com.free.service.FreeService;
import co.up.tune.com.vo.CommunityVO;
import co.up.tune.com.vo.ReplyVO;

@RestController
public class FreeAjaxController {
	
	@Autowired
	FreeService dao;
	
	//자유게시판 게시글 전체 리스트
	@GetMapping("freeAjaxList")
	public List<CommunityVO> freeList(){
		List<CommunityVO> data = dao.freeList();
		return data;
	}
	
	
	//=======댓글==========
	//댓글 등록
	@PostMapping("/replyInsert")
	public ReplyVO replyInsert(ReplyVO vo) {
		dao.replyInsert(vo);
		vo = dao.replySelect(vo);
		return vo;
	}
	
	//댓글 수정
	@PostMapping("/replyUpdate")
	public Date replyUpdate(ReplyVO vo) {
		dao.replyUpdate(vo);
		System.out.println(vo.getDttm());
		return vo.getDttm();
	}
	
	//댓글 삭제
	@PostMapping("/replyDelete")
	public int replyDelete(ReplyVO vo) {
		return dao.replyDelete(vo);
	}

}
