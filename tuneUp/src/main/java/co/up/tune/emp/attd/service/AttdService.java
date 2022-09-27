package co.up.tune.emp.attd.service;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;

import co.up.tune.emp.vo.AttdVO;


public interface AttdService {
	
	List<AttdVO> attdList();	// 전체사원 근태리스트
	List<AttdVO> attdListSearch(@Param("key") String key, @Param("val") String val); // 출근날짜 검색
	
	List<AttdVO> attdGoodList();	// 전체사원 정상리스트
	List<AttdVO> attdBadList();	// 전체사원 이상리스트
	
	List<AttdVO> myAttdList(AttdVO vo);	//내가 신청한 근태 수정리스트
	
	int startAttd(AttdVO vo);	//오늘 출근 시작
	int endAttd(AttdVO vo);	//오늘 퇴근
	
	
	//엑셀
	void excel(AttdVO attdVO, HttpServletResponse res) throws Exception;
	
	 
}
