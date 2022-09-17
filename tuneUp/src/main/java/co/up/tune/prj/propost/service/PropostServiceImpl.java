package co.up.tune.prj.propost.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.up.tune.prj.propost.mapper.PropostMapper;
import co.up.tune.prj.vo.PostVO;

@Service
public class PropostServiceImpl implements PropostService {
	@Autowired
	PropostMapper map;

	@Override
	public List<PostVO> postList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int postInsert(PostVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int postUpdate(PostVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int postDelete(PostVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}