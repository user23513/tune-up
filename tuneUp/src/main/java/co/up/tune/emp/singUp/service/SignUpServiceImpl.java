package co.up.tune.emp.singUp.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.up.tune.emp.singUp.mapper.SignUpMapper;
import co.up.tune.emp.vo.EmpVO;


@Service
public class SignUpServiceImpl implements SignUpService{
	
	@Autowired
	private SignUpMapper map;

	@Override
	public int empInsert(EmpVO vo) {
		
		return map.empInsert(vo);
	}

	@Override
	public int idCheck(@Param("id") String id) {
		return map.idCheck(id);
	}
	
	


}
