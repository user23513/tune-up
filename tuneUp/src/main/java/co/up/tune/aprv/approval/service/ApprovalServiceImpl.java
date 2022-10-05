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
* 결재자 승인 serviceImpl
* @author 윤정은
* @date 2022.09.25
* @version 1.0
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
	public AprvVO approvalSelect(AprvVO vo) {
		return map.approvalSelect(vo);
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
	public TrustVO trustSelect(TrustVO vo) {
		return map.trustSelect(vo);
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
	public EmpVO signSel(EmpVO vo) {
		return map.signSel(vo);
	}

}
