package co.up.tune.emp.mypage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.up.tune.emp.mypage.mapper.MyPageMapper;
import co.up.tune.emp.vo.EmpVO;

@Service
public class MyPageServiceImpl implements MypageService {
	@Autowired
	private MyPageMapper map;
	
	@Override
	public EmpVO empSelectOne(EmpVO vo) {
		return map.empSelectOne(vo);
	}

	@Override
	public int empUpdate(EmpVO vo) {
		return map.empUpdate(vo);
	}

}
