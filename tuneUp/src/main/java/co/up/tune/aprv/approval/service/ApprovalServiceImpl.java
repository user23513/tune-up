package co.up.tune.aprv.approval.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.up.tune.aprv.approval.mapper.ApprovalMapper;
import co.up.tune.aprv.vo.ApprovalVO;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.TrustVO;

@Service
public class ApprovalServiceImpl implements ApprovalService {

	@Autowired
	ApprovalMapper map;
	
	
	@Override
	public List<AprvVO> approvalList(String aprvr) {
	
		return map.approvalList(aprvr);
	}

	

	@Override
	public AprvVO approvalSelect(AprvVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int approvalSign(ApprovalVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int aprvStUp(AprvVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int trustIn(TrustVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int trustUp(TrustVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int trustDel(TrustVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	


}
