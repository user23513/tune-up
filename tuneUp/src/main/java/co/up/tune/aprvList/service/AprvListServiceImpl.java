package co.up.tune.aprvList.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.up.tune.aprv.vo.AprvCntnVO;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.AprvrVO;
import co.up.tune.aprv.vo.FormItemVO;
import co.up.tune.aprv.vo.FormVO;
import co.up.tune.aprv.vo.ItemCntnVO;
import co.up.tune.aprv.vo.TrustVO;
import co.up.tune.aprvList.mapper.AprvListMapper;

@Service
public class AprvListServiceImpl implements AprvListService {

	@Autowired
	AprvListMapper map;
	
	
	
	// 나의신청리스트
	@Override
	public List<AprvVO> aprvList(String empNo, String aprvSt) {
		return map.aprvList(empNo, aprvSt);
	}
	
	
	// 문서조회
	@Override
	public AprvVO aprvSelect(AprvVO vo) {
		return map.aprvSelect(vo);
	}
	@Override
	public List<ItemCntnVO> cntnList(String aprvNo) {
		return map.cntnList(aprvNo);
	}
	@Override
	public List<AprvrVO> aprvr(String aprvNo) {
		return map.aprvr(aprvNo);
	}
	@Override
	public TrustVO trustSelect(TrustVO vo) {
		return map.trustSelect(vo);
	}
	
	
	
	// 문서작성
	@Override
	public int aprvInsert(AprvVO vo) {
		return map.aprvInsert(vo);
	}

	@Override
	public int aprvCntnInsert(List<AprvCntnVO> list) {
		int cnt = 0;
		
		for (AprvCntnVO vo : list) {
			map.aprvCntnInsert(vo);
			cnt++;
		}
		
		if(cnt == list.size()) {
			return cnt;
		} else {
			return 0;
		}
		
	}
	
	@Override
	public int aprvrInsert(List<AprvrVO> list) {
		
		int cnt = 0;
		
		for (AprvrVO vo : list) {
			map.aprvrInsert(vo);
			cnt++;
		}
		
		if(cnt == list.size()) {
			return cnt;
		} else {
			return 0;
		}
	
	}

	
	// 서식작성
	@Override
	public int formInsert(FormVO vo) {
		return map.formInsert(vo);
	}

	@Override
	public int formItemInsert(List<FormItemVO> list) {
		int cnt = 0;
		
		for (FormItemVO vo : list) {
			map.formItemInsert(vo);
			cnt++;
		}
		
		if(cnt == list.size()) {
			return cnt;
		} else {
			return 0;
		}
		
	}

	
	// 서식삭제
	@Override
	public int formDelete(FormVO vo) {
		return map.formDelete(vo);
	}
	@Override
	public int formItemDelete(List<FormItemVO> list) {
		int cnt = 0;
		
		for (FormItemVO vo : list) {
			map.formItemDelete(vo);
			cnt++;
		}
		
		if(cnt == list.size()) {
			return cnt;
		} else {
			return 0;
		}
	}

	
	// 문서수정
	@Override
	public int aprvUpdate(AprvVO vo) {
		return map.aprvUpdate(vo);
	}

	@Override
	public int aprvCntnUpdate(List<AprvCntnVO> list) {
		int cnt = 0;
		
		for (AprvCntnVO vo : list) {
			map.aprvCntnUpdate(vo);
			cnt++;
		}
		
		if(cnt == list.size()) {
			return cnt;
		} else {
			return 0;
		}
	}

	@Override
	public int aprvrUpdate(List<AprvrVO> list) {
		int cnt = 0;
		
		for (AprvrVO vo : list) {
			map.aprvrUpdate(vo);
			cnt++;
		}
		
		if(cnt == list.size()) {
			return cnt;
		} else {
			return 0;
		}
	}

	
	// 문서삭제
	@Override
	public int aprvDelete(AprvVO vo) {
		return map.aprvDelete(vo);
	}
	@Override
	public int aprvCntnDelete(List<AprvCntnVO> list) {
		int cnt = 0;
		
		for (AprvCntnVO vo : list) {
			map.aprvCntnUpdate(vo);
			cnt++;
		}
		
		if(cnt == list.size()) {
			return cnt;
		} else {
			return 0;
		}
	}

	@Override
	public int aprvrDelete(AprvrVO vo) {
		return map.aprvrDelete(vo);
	}





	

	
	

}
