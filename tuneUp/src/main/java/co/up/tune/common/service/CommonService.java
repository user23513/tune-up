package co.up.tune.common.service;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import co.up.tune.common.vo.CommonVO;

public interface CommonService {
	
	List<CommonVO> commonList(@Param("cdCat") String cdCat);//코드 카테고리 따라서 조회 123순 정렬

}
