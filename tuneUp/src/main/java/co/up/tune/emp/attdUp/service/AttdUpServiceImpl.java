package co.up.tune.emp.attdUp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.up.tune.emp.attdUp.mapper.AttdUpMapper;
import co.up.tune.emp.vo.AttdUpVO;
import co.up.tune.prj.vo.PostVO;
@Service
public class AttdUpServiceImpl implements AttdUpService{
	@Autowired
	AttdUpMapper dao;
	
	@Override
	public List<AttdUpVO> attdUpList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AttdUpVO> myAttdUpList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AttdUpVO attdUpSelect(AttdUpVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int attdUpUpdate(PostVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int attdUpInsert(PostVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}




