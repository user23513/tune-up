package co.up.tune.emp.mypage.service;

import co.up.tune.emp.vo.EmpVO;

public interface MypageService {
	EmpVO empSelectOne(EmpVO vo); //사원조회
	int profileUpdate(EmpVO vo); //프로필 업데이트
	int picUpdate(EmpVO vo); //프로필 사진 업데이트
	int signUpdate(EmpVO vo); //결재 서명 업데이트
}