package co.up.tune.emp.mapper;

import co.up.tune.emp.vo.EmpVO;

public interface EmpMapper {
	
	EmpVO empSelect(EmpVO vo); //UsersService에 id,pw,auth담기위해
	EmpVO empSession(EmpVO vo); //LoginSuccessHandler에서 session에 담기위한 값
	
	int loginStUp(EmpVO vo); //로그인 로그아웃 자리비움 상태..
}
