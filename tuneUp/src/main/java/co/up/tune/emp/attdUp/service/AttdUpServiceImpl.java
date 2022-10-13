package co.up.tune.emp.attdUp.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		
		
		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("atdcDt", vo.getAtdcDt());
		paramMap.put("empNo", vo.getEmpNo());
		paramMap.put("atdcDttm", vo.getAtdcDttm());
		paramMap.put("afwkDttm", vo.getAfwkDttm());

		// 만약 퇴근시간 데이터가 있다면
		if(vo.getAfwkDttm() != null ) {
			// 근무시간 등 계산
		
			Date afwkDttm = vo.getAfwkDttm();
			Date atdcDttm = vo.getAtdcDttm();
			
			//포맷 정하기
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd HH:mm:ss");
			
			try {
				
				atdcDttm = dateFormat.parse(dateFormat.format(atdcDttm));
				afwkDttm = dateFormat.parse(dateFormat.format(afwkDttm));
			
				long commonWktm = 540;
				
				// 1. 근무시간 구하기 (퇴근시간 - 출근시간)
				long diff = afwkDttm.getTime() - atdcDttm.getTime();
				// 분단위로 변환
				long diffMinutes = diff / 60000 ;  
				
				paramMap.put("wktm", diffMinutes);
				
				// 2. 초과근무시간 구하기 (일반 근무시간(540분) - 근무시간)
				// 정산근무 혹은 초과근무라면
				if (diffMinutes >= commonWktm ) {
					paramMap.put("st", "정상");
					long ovtmLong = diffMinutes-commonWktm;
					paramMap.put("ovtm", ovtmLong);
				
				// 근무시간 미달시
				} else {
					paramMap.put("st", "비정상");
					paramMap.put("ovtm", 0);
				}
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		int result = dao.attdUpOk(paramMap);
		
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




