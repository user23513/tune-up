package co.up.tune.aprv.aprvr.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import co.up.tune.aprv.vo.AprvrVO;

public interface AprvrMapper {
	
		// 나의 결재 리스트
		List<AprvrVO> aprvr(@Param("aprvr") String aprvr);
		
		
		

}
