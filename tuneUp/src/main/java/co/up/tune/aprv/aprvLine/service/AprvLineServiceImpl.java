package co.up.tune.aprv.aprvLine.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.up.tune.aprv.aprvLine.mapper.AprvLineMapper;
import co.up.tune.aprv.vo.ApprovalVO;
import co.up.tune.aprv.vo.AprvLineVO;
import co.up.tune.aprv.vo.ReferVO;

@Service
public class AprvLineServiceImpl implements AprvLineService{

	@Autowired
	AprvLineMapper map;
	
	@Override
	public List<ApprovalVO> approvalList(ApprovalVO vo) {
		return map.approvalList(vo);
	}

	@Override
	public int approvalIn(List<ApprovalVO> list) {
		int cnt = 0;
		for(ApprovalVO vo : list) {
			map.approvalIn(vo);
			cnt ++;
		}
		return cnt;
		
	}

	@Override
	public int approvalUp(List<ApprovalVO> list) {
		int cnt = 0;
		for(ApprovalVO vo : list) {
			map.approvalUp(vo);
			cnt ++;
		}
		return cnt;
	}

	@Override
	public int approvalDel(ApprovalVO vo) {
		return map.approvalDel(vo);
	}

	@Override
	public List<ReferVO> ReferList(ReferVO vo) {
		return map.ReferList(vo);
	}

	@Override
	public int referIn(List<ReferVO> list) {
		int cnt = 0;
		for(ReferVO vo : list) {
			map.referIn(vo);
			cnt ++;
		}
		return cnt;
		
	}

	@Override
	public int referUp(List<ReferVO> list) {
		int cnt = 0;
		for(ReferVO vo : list) {
			map.referUp(vo);
			cnt ++;
		}
		return cnt;
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
	public int aprvLineUp(AprvLineVO vo) {
		return map.aprvLineUp(vo);
	}

	@Override
	public int aprvLineDel(AprvLineVO vo) {
		return map.aprvLineDel(vo);
	}

}
