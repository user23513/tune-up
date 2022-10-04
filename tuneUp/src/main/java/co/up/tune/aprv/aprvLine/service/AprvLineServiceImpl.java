package co.up.tune.aprv.aprvLine.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.up.tune.aprv.aprvLine.mapper.AprvLineMapper;
import co.up.tune.aprv.vo.ApprovalVO;
import co.up.tune.aprv.vo.AprvLineVO;
import co.up.tune.aprv.vo.ReferVO;
import co.up.tune.emp.vo.EmpVO;

@Service
public class AprvLineServiceImpl implements AprvLineService{

	@Autowired
	AprvLineMapper map;
	
	@Override
	public List<ApprovalVO> approvalList(ApprovalVO vo) {
		return map.approvalList(vo);
	}

	@Override
	public int approvalIn(ApprovalVO vo) {
		return map.approvalIn(vo);
		
	}

	@Override
	public List<ReferVO> ReferList(ReferVO vo) {
		return map.ReferList(vo);
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
	public List<EmpVO> aprvEmpSearch(EmpVO vo) {
		return map.aprvEmpSearch(vo);
	}

	@Override
	public List<EmpVO> aprvDeptSearch() {
		return map.aprvDeptSearch();
	}

}
