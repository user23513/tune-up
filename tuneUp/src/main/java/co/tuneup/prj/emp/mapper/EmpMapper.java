package co.tuneup.prj.emp.mapper;

import java.util.List;

import co.tuneup.prj.emp.service.EmpVO;


public interface EmpMapper {

	List<EmpVO> findAll();
}