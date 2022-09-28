package co.up.tune.emp.singUp.service;

import org.apache.ibatis.annotations.Param;

import co.up.tune.emp.vo.EmpVO;

public interface SignUpService {
	
	int empInsert(EmpVO vo);
	int idCheck(@Param("id") String id);
	

}
