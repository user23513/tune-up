package co.up.tune.prj.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		int a = 0; 
		int b = 0;
		fvo.setAtchNo(0);
		//프로젝트 파일 등록
		if(fvo.getFNm() != null) {
			fvo.setAtchNo(bvo.getAtchNo());
			b = postMap.prjFileInsert(fvo);
		}
		bvo.setAtchNo(fvo.getAtchNo());
		map.businessInsert(bvo);
		return a+b;
	}

	@Override
	public int businessDelete(BusinessVO vo) {
		return map.businessDelete(vo);
	}

	//업무 상태 수정
	@Override
	public int busStUpdate(BusinessVO vo) {
		return map.busStUpdate(vo);
	}

}
