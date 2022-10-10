package co.up.tune.emp.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.up.tune.emp.hr.mapper.HrMapper;
import co.up.tune.emp.vo.EmpVO;

@Service
public class HrServiceImpl implements HrService {
	@Autowired
	HrMapper map;

	@Override
	public List<EmpVO> empList() {
		return map.empList();
	}

	@Override
	public EmpVO empSelect(EmpVO vo) {
		return map.empSelect(vo);
	}

	@Override
	public int empUpdate(EmpVO vo) {
		return map.empUpdate(vo);
	}
	
	@Override
	public List<EmpVO> managerList() {
		return map.managerList();
	}

	@Override
	public int authUpdate(EmpVO vo) {
		return map.authUpdate(vo);
	}

	@Override
	public int mngUpdate(EmpVO vo) {
		return map.mngUpdate(vo);
	}
}
