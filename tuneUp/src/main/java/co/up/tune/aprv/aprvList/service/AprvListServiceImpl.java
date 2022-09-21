package co.up.tune.aprv.aprvList.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.up.tune.aprv.aprvList.mapper.AprvListMapper;
import co.up.tune.aprv.vo.AprvCntnVO;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.AprvrVO;
import co.up.tune.aprv.vo.FormItemVO;
import co.up.tune.aprv.vo.FormVO;
import co.up.tune.aprv.vo.ItemCntnVO;
import co.up.tune.aprv.vo.TrustVO;

@Service
public class AprvListServiceImpl implements AprvListService {

	@Autowired
	AprvListMapper map;
	
	
	// 관리자전체리스트
	@Override
	public List<AprvVO> aprvListAll(){
		return map.aprvListAll();
	}
	// 나의신청리스트
	@Override
	public List<AprvVO> aprvList(@Param("aprvNo") String aprvNo) {
		return map.aprvList(aprvNo);
	}
	
	
	
	
	// 단건개요조회
	@Override
	public AprvVO aprvSelect(AprvVO vo) {
		return map.aprvSelect(vo);
	}
	// 단건내용조회
	@Override
	public List<ItemCntnVO> cntnList(String aprvNo) {
		return map.cntnList(aprvNo);
	}
	

	
	// 문서작성
	@Override
	public int aprvInsert(AprvVO vo) {
		return map.aprvInsert(vo);
	}
	// 내용작성
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
	
	
	// 문서수정
		@Override
		public int aprvUpdate(AprvVO vo) {
			return map.aprvUpdate(vo);
		}
	//내용수정
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

		
		
		// 문서삭제
		@Override
		public int aprvDelete(AprvVO vo) {
			return map.aprvDelete(vo);
		}
		@Override
		public int aprvCntnDelete(AprvCntnVO vo) {	
			return map.aprvCntnDelete(vo);
			
		}

		
	//결재자 조회
	@Override
	public List<AprvrVO> aprvr(String aprvNo) {
		return map.aprvr(aprvNo);
	}
	//결재자 등록
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
	
	//결재자 수정
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
	//결재자 삭제
	@Override
	public int aprvrDelete(AprvrVO vo) {
		return map.aprvrDelete(vo);
	}
	
	
	// 서식작성
	@Override
	public int formInsert(FormVO vo) {
		return map.formInsert(vo);
	}
	// 서식항목작성
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
	public int formItemDelete(FormItemVO vo) {
		
		return map.formItemDelete(vo);
		
	}
	
	
	// 서식수정
	@Override
	public int formUpdate(FormVO vo) {
		return map.formUpdate(vo);
	}
	@Override
	public int formItemUpdate(List<FormItemVO> list) {
		int cnt = 0;
		
		for (FormItemVO vo : list) {
			map.formItemUpdate(vo);
			cnt++;
		}
		
		if(cnt == list.size()) {
			return cnt;
		} else {
			return 0;
		}
		
		
	}

	


}
