package co.up.tune.myReply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.up.tune.com.vo.ReplyVO;
import co.up.tune.myReply.mapper.MyReplyMapper;

@Service
public class MyReplyServiceImpl implements MyReplyService{
	@Autowired
	MyReplyMapper map;

	@Override
	public List<ReplyVO> myReplyList(ReplyVO vo) {
		return map.myReplyList(vo);
	}
	

}
