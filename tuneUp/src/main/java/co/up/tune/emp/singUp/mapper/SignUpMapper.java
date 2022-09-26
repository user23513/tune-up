package co.up.tune.emp.singUp.mapper;

import org.apache.ibatis.annotations.Param;

import co.up.tune.emp.vo.EmpVO;

public interface SignUpMapper {
	int empInsert(EmpVO vo);
	int idCheck(@Param("id") String id);
}
