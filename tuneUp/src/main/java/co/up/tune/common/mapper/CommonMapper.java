package co.up.tune.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.up.tune.common.vo.CommonVO;

public interface CommonMapper {

	List<CommonVO> commonList(@Param("cdCat") String cdCat);//코드조회
	
}
