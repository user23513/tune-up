package co.up.tune.emp.attd.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.up.tune.emp.vo.AttdUpVO;
import co.up.tune.emp.vo.AttdVO;


public interface AttdMapper {
	List<AttdVO> attdListSearch(@Param("key") String key, @Param("val") String val); // 출근날짜 검색
	
	List<AttdVO> attdList();	// 전체사원 근태리스트
	List<AttdVO> attdGoodList();	// 전체사원 정상 근태리스트
	List<AttdVO> attdBadList();	// 전체사원 이상 근태리스트
	List<AttdVO> myAttdList(AttdVO vo);	//나의 근태
	
	int startAttd(AttdVO vo);	//오늘 출근 시작
	int endAttd(AttdVO vo);	//오늘 퇴근
	
	List<AttdVO> wktmChart(AttdVO vo);	// 워크타임 차트

	int checkGood(AttdVO vo);	//오늘 출근 시작 몇명
	int checkBad(AttdVO vo); 	//어제 이상 출근 몇명
	
	AttdVO checkTime(AttdVO vo); //출근시간 띄우기
	
	Date selectAtdcTmByEmpNo(String empNo); // 특정 사원의 출근시간 조회 
}
