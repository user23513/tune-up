package co.up.tune.com.free.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import co.up.tune.com.free.service.FreeService;
import co.up.tune.com.vo.ReplyVO;

@RestController
public class FreeAjaxController {
	
	@Autowired
	FreeService dao;
	
	//댓글 등록
	@PostMapping("/replyInsert")
	public ReplyVO replyInsert(ReplyVO vo) {
		dao.replyInsert(vo);
		vo = dao.replySelect(vo);
		return vo;
	}
	
	//댓글 수정
	@PostMapping("/replyUpdate")
	public int replyUpdate(ReplyVO vo) {
		return dao.replyUpdate(vo);
	}
	
	//댓글 삭제
	@PostMapping("/replyDelete")
	public int replyDelete(ReplyVO vo) {
		return dao.replyDelete(vo);
	}

}
