package co.up.tune.emp.attd.mapper;

import java.util.List;

import co.up.tune.emp.vo.AttdVO;

public interface AttdMapper {
	List<AttdVO> attdList();	// 전체사원 근태리스트
	List<AttdVO> attdGoodList();	// 전체사원 근태리스트
	List<AttdVO> attdBadList();	// 전체사원 근태리스트
	
	List<AttdVO> myAttdList();	//나의 근태
//	AttdVO attdGood(AttdVO vo); //정상출근
//	AttdVO attdBad(AttdVO vo); //근태이상
}
