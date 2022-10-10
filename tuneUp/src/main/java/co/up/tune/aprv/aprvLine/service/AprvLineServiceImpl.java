package co.up.tune.aprv.aprvLine.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.up.tune.aprv.aprvLine.mapper.AprvLineMapper;
import co.up.tune.aprv.vo.ApprovalVO;
import co.up.tune.aprv.vo.AprvLineVO;
import co.up.tune.aprv.vo.ReferVO;
import co.up.tune.emp.vo.EmpVO;

/**
 * 전자결재 결재라인 ServiceImpl
 * 
 * @author 윤정은
 * @date 2022.09.30
 * @version 1.3
 **/

@Service
public class AprvLineServiceImpl implements AprvLineService {

	@Autowired
	AprvLineMapper map;

	@Override
	public List<ApprovalVO> aprvrList(ApprovalVO vo) {
		return map.aprvrList(vo);
	}

	@Override
	public int approvalIn(ApprovalVO vo) {
		return map.approvalIn(vo);

	}

	@Override
	public List<ReferVO> referList(ReferVO vo) {
		return map.referList(vo);
	}

	@Override
	public int referIn(ReferVO vo) {
		return map.referIn(vo);

	}

	@Override
	public int referDel(ReferVO vo) {
		return map.referDel(vo);
	}

	@Override
	public List<AprvLineVO> aprvLineList(AprvLineVO vo) {
		return map.aprvLineList(vo);
	}

	@Override
	public int aprvLineIn(AprvLineVO vo) {
		return map.aprvLineIn(vo);
	}

	@Override
	public int aprvLineDel(AprvLineVO vo) {
		return map.aprvLineDel(vo);
	}

	@Override
	public List<EmpVO> aprvEmpList(EmpVO vo) {
		return map.aprvEmpList(vo);
	}

	@Override
	public List<EmpVO> aprvDeptList() {
		return map.aprvDeptList();
	}

	@Override
	public AprvLineVO aprvLineSelect(AprvLineVO vo) {
		return map.aprvLineSelect(vo);
	}

}
