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
	public List<AprvVO> approvalList(String aprvr, String aprvSt) {
	
		return map.approvalList(aprvr, aprvSt);
	}

	

	@Override
	public AprvVO approvalSelect(AprvVO vo) {
		return map.approvalSelect(vo);
	}

	@Override
	public int approvalSign(ApprovalVO vo) {
		
		return map.approvalSign(vo);
	}

	@Override
	public int aprvNext(ApprovalVO vo) {
		return map.aprvNext(vo);
	};
	
	
	@Override
	public List<TrustVO> trustList(TrustVO vo){
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
	public int trustUp(TrustVO vo) {
		
		return map.trustUp(vo);
	}

	@Override
	public int trustDel(TrustVO vo) {
		return map.trustDel(vo);
	}
	
	


}
