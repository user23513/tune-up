package co.up.tune.aprvList.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import co.up.tune.aprv.vo.AprvVO;

public interface AprvListMapper {
	

		List<AprvVO> aprvList(); //나의전자결재
		AprvVO aprvSelect(AprvVO vo); //상세조회
		int apvrInsert(AprvVO vo); //문서작성
		int aprvUpdate(AprvVO vo); //문서수정
		
		

}
