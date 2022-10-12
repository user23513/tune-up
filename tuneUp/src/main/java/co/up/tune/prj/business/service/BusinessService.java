package co.up.tune.prj.business.service;

import java.util.List;

import co.up.tune.prj.vo.BusinessVO;
import co.up.tune.prj.vo.FilesVO;

public interface BusinessService {
	
	List<BusinessVO> businessList(BusinessVO vo);
	int businessInsert(BusinessVO vo, FilesVO fvo); //업무 등록
	int businessDelete(BusinessVO vo);
	
	int busStUpdate(BusinessVO vo); //업무 상태 수정
}
