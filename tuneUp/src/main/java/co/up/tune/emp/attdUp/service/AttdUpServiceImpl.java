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
		// 사원 - 나의근태 수정목록
		return dao.attdUpList();
	}

	@Override
	public List<AttdUpVO> myAttdUpList() {
		// TODO Auto-generated method stub
		return dao.myAttdUpList();
	}

	@Override
	public AttdUpVO attdUpSelect(AttdUpVO vo) {
		// TODO Auto-generated method stub
		return dao.attdUpSelect(vo);
	}

	@Override
	public int attdUpUpdate(AttdUpVO vo) {
		// TODO Auto-generated method stub
		return dao.attdUpUpdate(vo);
	}

	@Override
	public int attdUpInsert(AttdUpVO vo) {
		// TODO Auto-generated method stub
		return dao.attdUpInsert(vo);
	}

	@Override
	public int attdUpDel(AttdUpVO vo) {
		// TODO Auto-generated method stub
		return dao.attdUpDel(vo);
	}

	@Override
	public int attdUpOk(AttdUpVO vo) {
		// TODO Auto-generated method stub
		return dao.attdUpOk(vo);
	}
	
	
}




