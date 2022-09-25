package co.up.tune.com.bell.mapper;

import java.util.List;

import co.up.tune.com.vo.BellVO;

public interface BellMapper {
	
	List<BellVO> bellList(BellVO vo); //알림 리스트
	int bellInsert(BellVO vo); //알림 등록
	int bellDelete(BellVO vo); //알림 삭제
	int bellCount(); //알림 갯수
}
