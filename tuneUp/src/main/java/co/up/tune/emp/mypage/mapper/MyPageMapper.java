package co.up.tune.emp.mypage.mapper;

import co.up.tune.emp.vo.EmpVO;

public interface MyPageMapper {
	EmpVO empSelectOne(EmpVO vo);
	int profileUpdate(EmpVO vo);
	int picUpdate(EmpVO vo); //프로필 사진 업데이트
	int signUpdate(EmpVO vo); //결재 서명 업데이트
}
