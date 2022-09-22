package co.up.tune.emp.attd.service;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import co.up.tune.emp.vo.AttdVO;


public interface AttdService {
	
	List<AttdVO> attdList();	// 전체사원 근태리스트
	List<AttdVO> attdGoodList();	// 전체사원 정상리스트
	List<AttdVO> attdBadList();	// 전체사원 이상리스트
	
	List<AttdVO> myAttdList();
	
	//엑셀
	void excel(AttdVO attdVO, HttpServletResponse res) throws Exception;
	
}
