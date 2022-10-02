package co.up.tune.prj.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.up.tune.com.vo.ReplyVO;
import co.up.tune.prj.business.mapper.BusinessMapper;
import co.up.tune.prj.vo.BusinessVO;

public class BusinessServiceImpl implements BusinessService{

	@Autowired
	BusinessMapper map;
	
	@Override
	public List<BusinessVO> businessList(BusinessVO vo) {
		return map.businessList(vo);
	}

	@Override
	public int businessInsert(BusinessVO vo) {
		return map.businessInsert(vo);
	}

	@Override
	public int businessUpdate(BusinessVO vo) {
		return map.businessUpdate(vo);
	}

	@Override
	public int businessDelete(BusinessVO vo) {
		return map.businessDelete(vo);
	}

	@Override
	public List<ReplyVO> bReplyList(ReplyVO vo) {
		return null;
	}

	@Override
	public int bReplyInsert(ReplyVO vo) {
		return 0;
	}

	@Override
	public int bReplyDelete(ReplyVO vo) {
		return 0;
	}

}
