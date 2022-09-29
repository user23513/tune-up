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
}
