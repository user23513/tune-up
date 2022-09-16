package co.up.tune.emp.mypage.mapper;

import co.up.tune.emp.vo.EmpVO;

public interface MyPageMapper {
	EmpVO empSelectOne(EmpVO vo);
	EmpVO pwCheck(EmpVO vo);
	int empUpdate(EmpVO vo);
}
