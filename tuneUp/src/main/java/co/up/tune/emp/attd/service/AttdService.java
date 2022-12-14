package co.up.tune.emp.attd.service;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;

import co.up.tune.emp.vo.AttdVO;


public interface AttdService {
	
	List<AttdVO> attdList();	// 전체사원 근태리스트
	List<AttdVO> todayAttdList();	// 전체사원 오늘근태리스트
	List<AttdVO> attdGoodList();	// 전체사원 정상리스트
	List<AttdVO> attdBadList();	// 전체사원 이상리스트
	
	List<AttdVO> myAttdList(AttdVO vo);	//내가 신청한 근태 수정리스트
	
	int startAttd(AttdVO vo);	//오늘 출근 시작
	int endAttd(AttdVO vo);	//오늘 퇴근
	
	List<String> wktmChart(String empNo);	// 워크타임 차트에 쓰이는 근무시간리스트
	List<String> ovtmChart(String empNo);	// 워크타임 차트에 쓰이는 초과근무시간리스트
	
	int checkGood(AttdVO vo);	//오늘 출근 시작 몇명
	int checkBad(AttdVO vo); 	//어제 이상 출근 몇명
	
	AttdVO checkTime(AttdVO vo); //출근시간 띄우기
	AttdVO checkBTime(AttdVO vo); //퇴근시간 띄우기
	
	String wkov(String empNo);	//총근무 wktm+ovtm
	String totalWktm(String empNo); //근무 wktm
	String totalOvtm(String empNo);	//연장근무 ovtm
	
	//엑셀
	void excel(AttdVO attdVO, HttpServletResponse res) throws Exception;
	 
}
