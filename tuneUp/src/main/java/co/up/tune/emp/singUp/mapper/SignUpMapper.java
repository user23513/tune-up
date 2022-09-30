package co.up.tune.emp.singUp.mapper;

import org.apache.ibatis.annotations.Param;

import co.up.tune.emp.vo.EmpVO;

public interface SignUpMapper {
	//회원가입
	int empInsert(EmpVO vo);
	//회원가입 아이디 중복 체크
	int idCheck(@Param("id") String id);
	//아이디찾기
	String findId(EmpVO vo);
<<<<<<< HEAD
	//비밀번호 변경
	int empUpdate(EmpVO vo);
=======
	//비밀번호 찾기 
	String findPassword(EmpVO vo);
	
>>>>>>> branch 'kimgayun' of https://github.com/user23513/tune-up.git
}
