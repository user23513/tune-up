package co.up.tune.emp.mypage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.up.tune.com.vo.ReplyVO;
import co.up.tune.emp.mypage.mapper.MyPageMapper;
import co.up.tune.emp.vo.EmpVO;
import co.up.tune.prj.vo.PostVO;

@Service
public class MyPageServiceImpl implements MypageService {
	@Autowired
	private MyPageMapper map;
	
	@Override
	public EmpVO empSelectOne(EmpVO vo) {
		return map.empSelectOne(vo);
	}

	@Override
	public int profileUpdate(EmpVO vo) {
		return map.profileUpdate(vo);
	}

	@Override
	public int picUpdate(EmpVO vo) {
		return map.picUpdate(vo);
	}

	@Override
	public int signUpdate(EmpVO vo) {
		return map.signUpdate(vo);
	}

	

	@Override
	public PostVO postLook(PostVO vo) {
		return map.postLook(vo);
	}
}
