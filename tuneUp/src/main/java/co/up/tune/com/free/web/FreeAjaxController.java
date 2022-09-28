package co.up.tune.com.free.web;



import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import co.up.tune.com.free.service.FreeService;
import co.up.tune.com.vo.CommunityVO;
import co.up.tune.com.vo.ReplyVO;
import co.up.tune.paging.vo.pagingVO;
import oracle.jdbc.proxy.annotation.Post;

@RestController
public class FreeAjaxController {
	
	@Autowired
	FreeService dao;
	
	//페이징처리 클래스
	@Autowired
	Paging paging; 
	
	//자유게시판 게시글 전체 리스트
	/*
	 * @PostMapping("freeAjaxList") public List<CommunityVO> freeList(Paging paging,
	 * Model model) { // 페이징 처리 if(paging.getPageNum() == null)
	 * {paging.setPageNum(1);} paging = new Paging(paging.getPageNum());
	 * List<CommunityVO> freeList = dao.freeList(paging); return freeList; }
	 */
	
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
