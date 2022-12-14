package co.up.tune.common.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.up.tune.common.mapper.CommonMapper;
import co.up.tune.common.vo.CommonVO;

@Service
public class CommonServiceImpl implements CommonService {
	
	@Autowired
	CommonMapper map;
	
	@Override
	public List<CommonVO> commonList(@Param("cdCat") String cdCat) {
		
		return map.commonList(cdCat); 
	}

	
	
}
