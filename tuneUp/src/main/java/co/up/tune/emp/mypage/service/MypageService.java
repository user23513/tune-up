package co.up.tune.emp.mypage.service;

import co.up.tune.emp.vo.EmpVO;

public interface MypageService {
	EmpVO empSelectOne(EmpVO vo);
	EmpVO pwCheck(EmpVO vo);
	int empUpdate(EmpVO vo);
}