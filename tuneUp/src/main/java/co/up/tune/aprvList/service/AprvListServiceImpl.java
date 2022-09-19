package co.up.tune.aprvList.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprvList.mapper.AprvListMapper;

@Service
public class AprvListServiceImpl implements AprvListService {

	@Autowired
	AprvListMapper map;
	
	
	@Override
	public List<AprvVO> aprvList() {
		return map.aprvList();
	}

	@Override
	public AprvVO aprvSelect(AprvVO vo) {
		return map.aprvSelect(vo);
	}

	@Override
	public int apvrInsert(AprvVO vo) {
		return map.apvrInsert(vo);
	}

	@Override
	public int aprvUpdate(AprvVO vo) {
		return map.aprvUpdate(vo);
	}

	

}
