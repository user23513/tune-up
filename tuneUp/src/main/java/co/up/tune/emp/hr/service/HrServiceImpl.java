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
	public List<EmpVO> empSearch(String key, String val) {
		return map.empSearch(key, val);
	}

	@Override
	public EmpVO empSelectList(EmpVO vo) {
		return map.empSelectList(vo);
	}

	@Override
	public int empUpdate(EmpVO vo) {
		return map.empUpdate(vo);
	}
}
