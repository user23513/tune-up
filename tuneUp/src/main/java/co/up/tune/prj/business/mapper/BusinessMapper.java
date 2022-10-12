package co.up.tune.prj.business.mapper;

import java.util.List;

import co.up.tune.prj.vo.BusinessVO;

public interface BusinessMapper {
	List<BusinessVO> businessList(BusinessVO vo);
	int businessInsert(BusinessVO vo); //업무 등록
	int businessDelete(BusinessVO vo);
	
	int busStUpdate(BusinessVO vo); //업무 상태 수정
}
