package co.up.tune.com.bell.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.up.tune.com.bell.mapper.BellMapper;
import co.up.tune.com.vo.BellVO;

@Service
public class BellServiceImpl implements BellService {
	
	@Autowired
	BellMapper map;

	//알림 리스트
	@Override
	public List<BellVO> bellList(BellVO vo) {
		return map.bellList(vo);
	}
	
	//알림 등록
	@Override
	public int bellInsert(BellVO vo) {
		return map.bellInsert(vo);
	}

	//알림 삭제
	@Override
	public int bellDelete(BellVO vo) {
		return map.bellDelete(vo);
	}

	//알림 갯수
	@Override
	public int bellCount() {
		return map.bellCount();
	}
	
}
