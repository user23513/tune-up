package co.up.tune.aprv.aprvLine.mapper;

import java.util.List;

import co.up.tune.aprv.vo.ApprovalVO;
import co.up.tune.aprv.vo.AprvLineVO;
import co.up.tune.aprv.vo.ReferVO;
import co.up.tune.emp.vo.EmpVO;

public interface AprvLineMapper {

	// 결재자
	List<ApprovalVO> approvalList(ApprovalVO vo); // 조회

	int approvalIn(ApprovalVO vo); // 등록 

	int approvalUp(ApprovalVO vo); // 수정 

	int approvalDel(ApprovalVO vo); // 삭제

	// 참조인
	List<ReferVO> ReferList(ReferVO vo); // 조회

	int referIn(ReferVO vo); // 등록 

	int referUp(ReferVO vo); // 수정 

	int referDel(ReferVO vo); // 삭제

	// 결재선
	List<AprvLineVO> aprvLineList(AprvLineVO vo); // 조회

	int aprvLineIn(AprvLineVO vo); // 등록

	int aprvLineUp(AprvLineVO vo); // 수정

	int aprvLineDel(AprvLineVO vo); // 삭제

	List<EmpVO> aprvEmpSearch(EmpVO vo); //사원목록

	List<EmpVO> aprvDeptSearch(); // 부서검색
}
