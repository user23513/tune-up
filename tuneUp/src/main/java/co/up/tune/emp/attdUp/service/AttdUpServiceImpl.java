package co.up.tune.emp.attdUp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.up.tune.emp.attdUp.mapper.AttdUpMapper;
import co.up.tune.emp.vo.AttdUpVO;
@Service
public class AttdUpServiceImpl implements AttdUpService{
	@Autowired
	AttdUpMapper dao;
	
	@Override
	public List<AttdUpVO> attdUpList() {
		// 사원 - 나의근태 수정목록
		return dao.attdUpList();
	}

	@Override
	public List<AttdUpVO> myAttdUpList() {
		// TODO Auto-generated method stub
		return dao.myAttdUpList();
	}

	@Override
	public AttdUpVO attdUpSelect(AttdUpVO vo) {
		// TODO Auto-generated method stub
		return dao.attdUpSelect(vo);
	}

	@Override
	public int attdUpUpdate(AttdUpVO vo) {
		// TODO Auto-generated method stub
		return dao.attdUpUpdate(vo);
	}

	@Override
	public int attdUpInsert(AttdUpVO vo) {
		// TODO Auto-generated method stub
		return dao.attdUpInsert(vo);
	}

	@Override
	public int attdUpDel(int attdUpNo) {
		// TODO Auto-generated method stub
		return dao.attdUpDel(attdUpNo);
	}

	@Override
	public int attdUpOk(AttdUpVO vo) {
		// TODO Auto-generated method stub
		int result = dao.attdUpOk(vo);
		
		// 수정이 완료 되었을 때
		if(result > 0) {
			Map<String, Object> map = new HashMap<>();
			map.put("empNo", vo.getEmpNo());
			map.put("atdcDt", vo.getAtdcDt());
			// 사번과 출근 날짜로 근태수정요청 데이터 찾기 
			int no = dao.selectAttdUpNo(map);
			// 근태수정요청 넘버로 근태수정요청데이터 지우기
			dao.attdUpDel(no);
		}
		
		return result;
	}

	@Override
	public int checkModi(AttdUpVO vo) {
		// 수정요청 몇명
		return dao.checkModi(vo);
	}
	
	
}




