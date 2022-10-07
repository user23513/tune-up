package co.up.tune.aprv.aprvLine.mapper;

import java.util.List;
import co.up.tune.aprv.vo.ApprovalVO;
import co.up.tune.aprv.vo.AprvLineVO;
import co.up.tune.aprv.vo.ReferVO;
import co.up.tune.emp.vo.EmpVO;

/**
* 전자결재 결재라인 Mapper
* @author 윤정은
* @date 2022.10.4
* @version 1.3
**/

public interface AprvLineMapper {
	
	// 결재문서 결재자 목록
	List<ApprovalVO> approvalList(ApprovalVO vo);

	// 결재자 등록
	int approvalIn(ApprovalVO vo); 

	// 결재문서 참조인 목록
	List<ReferVO> ReferList(ReferVO vo); 
	
	// 참조인 등록
	int referIn(ReferVO vo);
	
	// 참조인 삭제
	int referDel(ReferVO vo); 

	// 결재선 조회
	List<AprvLineVO> aprvLineList(AprvLineVO vo);
	
	// 결재선 등록
	int aprvLineIn(AprvLineVO vo); 
	
	// 결재선 삭제
	int aprvLineDel(AprvLineVO vo);
	
	// 결재선 사원목록
	List<EmpVO> aprvEmpList(EmpVO vo);

	// 결재선 부서목록
	List<EmpVO> aprvDeptList();
	
}
