package co.up.tune.emp.attd.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import co.up.tune.emp.vo.AttdVO;


public interface AttdMapper {
	List<AttdVO> attdListSearch(@Param("key") String key, @Param("val") String val); // 출근날짜 검색
	
	List<AttdVO> attdList();	// 전체사원 근태리스트
	List<AttdVO> attdGoodList();	// 전체사원 정상 근태리스트
	List<AttdVO> attdBadList();	// 전체사원 이상 근태리스트
	List<AttdVO> myAttdList(AttdVO vo);	//나의 근태
	
	int startAttd(AttdVO vo);	//오늘 출근 시작
	int endAttd(AttdVO vo);	//오늘 퇴근
	
	int alreadyAttd(Map<String, Object> paramMap); //오늘 이미 출근했는지 여부
	
	List<String> wktmChart(String empNo);	// 워크타임 차트
	List<String> ovtmChart(String empNo);	// 오버타임 차트

	int checkGood(AttdVO vo);	//오늘 출근 시작 몇명
	int checkBad(AttdVO vo); 	//어제 이상 출근 몇명
	
	AttdVO checkTime(AttdVO vo); //출근시간 띄우기
	AttdVO checkBTime(AttdVO vo); //퇴근시간 띄우기
	
	Date selectAtdcTmByEmpNo(String empNo); // 특정 사원의 출근시간 조회 
	
	String wkov(String empNo);	//총근무 wktm+ovtm
	String totalWktm(String empNo); //근무 wktm
	String totalOvtm(String empNo);	//연장근무 ovtm
}
