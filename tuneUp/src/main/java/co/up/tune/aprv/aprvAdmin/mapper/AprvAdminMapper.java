package co.up.tune.aprv.aprvAdmin.mapper;

import java.util.List;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.FormVO;
import co.up.tune.aprv.vo.ReferVO;

public interface AprvAdminMapper {

//////////결재문서
//관리자 전체 결재문서 목록 조회
	List<AprvVO> aprvListAll();

//결재문서 단건 상세
	AprvVO aprvSelect(AprvVO vo);

//관리자  삭제
	int aprvAdminDel(AprvVO vo);


//관리자  수정
	int aprvAdminUp(AprvVO vo);


// 관리자 전체 서식 목록 조회
	List<FormVO> aprvFormAll();

// 서식 단건 상세
	FormVO formSelect(FormVO vo);

// 관리자 서식 삭제
	int formAdminDel(AprvVO vo);

// 관리자 서식  수정 
	int formAdminUp(AprvVO vo);


}
