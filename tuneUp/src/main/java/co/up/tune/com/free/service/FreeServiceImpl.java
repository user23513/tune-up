package co.up.tune.com.free.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.up.tune.com.free.mapper.FreeMapper;
import co.up.tune.com.free.web.Paging;
import co.up.tune.com.vo.CommunityVO;
import co.up.tune.com.vo.ReplyVO;

@Service
public class FreeServiceImpl implements FreeService {
	
	@Autowired
	FreeMapper map;

	//[자유게시판 게시글]
	@Override
	public List<CommunityVO> freeList(Paging paging) {
		// TODO Auto-generated method stub
		return map.freeList(paging);
	}

	@Override
	public CommunityVO freeSelect(CommunityVO vo) {
		// TODO Auto-generated method stub
		return map.freeSelect(vo);
	}

	@Override
	public int freeInsert(CommunityVO vo) {
		// TODO Auto-generated method stub
		return map.freeInsert(vo);
	}

	@Override
	public int freeUpdate(CommunityVO vo) {
		// TODO Auto-generated method stub
		return map.freeUpdate(vo);
	}

	@Override
	public int freeDelete(CommunityVO vo) {
		// TODO Auto-generated method stub
		return map.freeDelete(vo);
	}

	@Override
	public List<CommunityVO> freeSearch(String key, String val) {
		// TODO Auto-generated method stub
		return map.freeSearch(key, val);
	}

	@Override
	public int freeHitUpdate(CommunityVO vo) {
		// TODO Auto-generated method stub
		return map.freeHitUpdate(vo);
	}
	
	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return map.getTotal();
	}

	//[댓글]
	@Override
	public List<ReplyVO> replyList(ReplyVO vo) {
		// TODO Auto-generated method stub
		return map.replyList(vo);
	}

	@Override
	public int replyInsert(ReplyVO vo) {
		// TODO Auto-generated method stub
		return map.replyInsert(vo);
	}

	@Override
	public int replyUpdate(ReplyVO vo) {
		// TODO Auto-generated method stub
		return map.replyUpdate(vo);
	}

	@Override
	public int replyDelete(ReplyVO vo) {
		// TODO Auto-generated method stub
		return map.replyDelete(vo);
	}

	@Override
	public ReplyVO replySelect(ReplyVO vo) {
		// TODO Auto-generated method stub
		return map.replySelect(vo);
	}

}
