package co.up.tune.emp.attd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.up.tune.com.vo.CommunityVO;
import co.up.tune.emp.vo.AttdVO;


public interface AttdMapper {
	List<AttdVO> attdList();	// 전체사원 근태리스트
	List<AttdVO> attdListSearch(@Param("key") String key, @Param("val") String val); // 출근날짜 검색
	
	List<AttdVO> attdGoodList();	// 전체사원 근태리스트
	List<AttdVO> attdBadList();	// 전체사원 근태리스트
	List<AttdVO> myAttdList(AttdVO vo);	//나의 근태
	
	int attdToday(AttdVO vo);
	int afwkToday(AttdVO vo);
//	AttdVO attdGood(AttdVO vo); //정상출근
//	AttdVO attdBad(AttdVO vo); //근태이상
}
