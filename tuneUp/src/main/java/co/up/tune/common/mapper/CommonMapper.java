package co.up.tune.common.mapper;

import java.util.List;
import co.up.tune.common.vo.CommonVO;

public interface CommonMapper {

	List<CommonVO> commonList(CommonVO vo);//코드조회
	
}
