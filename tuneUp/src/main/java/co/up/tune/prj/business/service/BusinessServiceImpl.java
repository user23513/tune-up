package co.up.tune.prj.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.up.tune.com.vo.ReplyVO;
import co.up.tune.prj.business.mapper.BusinessMapper;
import co.up.tune.prj.propost.mapper.PropostMapper;
import co.up.tune.prj.vo.BusinessVO;
import co.up.tune.prj.vo.FilesVO;

@Service
public class BusinessServiceImpl implements BusinessService{

	@Autowired
	BusinessMapper map;
	
	@Autowired
	PropostMapper postMap;
	
	@Override
	public List<BusinessVO> businessList(BusinessVO vo) {
		return map.businessList(vo);
	}

	//업무 등록
	@Override
	public int businessInsert(BusinessVO bvo, FilesVO fvo) {
		//프로젝트 업무 등록
		int a = map.businessInsert(bvo);
		fvo.setAtchNo(bvo.getAtchNo());
		//프로젝트 파일 등록
		int b = postMap.prjFileInsert(fvo);
		return a+b;
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
