package co.up.tune.emp.mypage.service;

import org.springframework.beans.factory.annotation.Autowired;

import co.up.tune.emp.mypage.mapper.MyPageMapper;
import co.up.tune.emp.vo.EmpVO;

public class MyPageServiceImpl implements MypageService {
	@Autowired
	private MyPageMapper map;
	
	@Override
	public EmpVO empSelectOne(EmpVO vo) {
		return map.empSelectOne(vo);
	}

	@Override
	public EmpVO pwCheck(EmpVO vo) {
		return map.pwCheck(vo);
	}

	@Override
	public int empUpdate(EmpVO vo) {
		return map.empUpdate(vo);
	}

}
