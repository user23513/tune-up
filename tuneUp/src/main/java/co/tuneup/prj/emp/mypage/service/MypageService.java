package co.tuneup.prj.emp.mypage.service;

import co.tuneup.prj.emp.emp.service.EmpVO;

public interface MypageService {
	EmpVO empSelectOne(EmpVO vo);
	EmpVO pwCheck(EmpVO vo);
	int empUpdate(EmpVO vo);
}