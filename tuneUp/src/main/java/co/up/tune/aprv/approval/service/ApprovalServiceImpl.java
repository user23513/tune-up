package co.up.tune.aprv.approval.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.up.tune.aprv.approval.mapper.ApprovalMapper;
import co.up.tune.aprv.vo.ApprovalVO;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.TrustVO;
import co.up.tune.emp.vo.EmpVO;

/**
* 전자결재 승인 ServiceImpl
* @author 윤정은
* @date 2022.10.1
* @version 1.3
**/

@Service
public class ApprovalServiceImpl implements ApprovalService {

	@Autowired
	ApprovalMapper map;

	@Override
	public List<AprvVO> approvalList(String aprvr, String aprvSt) {
		return map.approvalList(aprvr, aprvSt);
	}

	@Override
	@Transactional
	public int approvalSign(ApprovalVO vo) {
		int cnt = map.approvalSign(vo);
		cnt += map.aprvNext(vo);
		return cnt;
	}

	@Override
	public List<TrustVO> trustList(TrustVO vo) {
		return map.trustList(vo);
	}

	@Override
	public TrustVO trustCheck(TrustVO vo) {
		return map.trustCheck(vo);
	};

	@Override
	public int trustIn(TrustVO vo) {
		return map.trustIn(vo);
	}

	@Override
	public int trustDel(TrustVO vo) {
		return map.trustDel(vo);
	}

	@Override
	public int signUp(EmpVO vo) {
		return map.signUp(vo);
	}

	@Override
	public EmpVO signSelect(EmpVO vo) {
		return map.signSelect(vo);
	}

	@Override
	public int trustUp(TrustVO vo) {
		return map.trustUp(vo);
	}

}
