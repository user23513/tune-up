package co.up.tune.aprv.approval.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.up.tune.aprv.approval.mapper.ApprovalMapper;
import co.up.tune.aprv.vo.ApprovalVO;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.TrustVO;
import co.up.tune.com.bell.mapper.BellMapper;
import co.up.tune.com.vo.BellVO;
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
	@Autowired
	BellMapper bmap;

	@Override
	public List<AprvVO> approvalList(String aprvr, String aprvSt) {
		return map.approvalList(aprvr, aprvSt);
	}

	@Override
	@Transactional
	public int approved(ApprovalVO vo) {
		BellVO bvo = new BellVO();
		bvo.setCntn("<a type='external' href='/aprvReq'>" + vo.getTtl() + "</a> 문서가 승인되었습니다.");
		bvo.setEmpNo(vo.getEmpNo());
		bvo.setReceiver("수신인");
		bvo.setSender("발신인");
		bmap.bellInsert(bvo);
		int cnt = map.approved(vo);
		map.aprvNext(vo);
		return cnt;
	}
	
	@Override
	@Transactional
	public int reject(ApprovalVO vo) {
		BellVO bvo = new BellVO();
		bvo.setCntn("<a type='external' href='/aprvReq'>" + vo.getTtl() + "</a> 문서가 반려되었습니다.");
		bvo.setEmpNo(vo.getEmpNo());
		bvo.setReceiver("수신인");
		bvo.setSender("발신인");
		bmap.bellInsert(bvo);
		int cnt = map.reject(vo);
		map.aprvNext(vo);
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
	@Transactional
	public int trustIn(TrustVO vo) {
		BellVO bvo = new BellVO();
		bvo.setCntn(vo.getNm()+ "님이 <a type='external' href='/approval'>문서 결재권을 위임</a>하셨습니다.");
		bvo.setEmpNo(vo.getRptt());
		bvo.setReceiver("수신인");
		bvo.setSender("발신인");
		bmap.bellInsert(bvo);
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
	@Transactional
	public int trustUp(TrustVO vo) {
		BellVO bvo = new BellVO();
		bvo.setCntn(vo.getNm()+ "님이 <a type='external' href='/approval'>문서 결재권을 위임</a>하셨습니다.");
		bvo.setEmpNo(vo.getRptt());
		bvo.setReceiver("수신인");
		bvo.setSender("발신인");
		bmap.bellInsert(bvo);
		
		return map.trustUp(vo);
	}

	@Override
	@Transactional
	public int checkApproved(ApprovalVO vo) {
		//체크박스 번호 리스트 & 알림용 사번 리스트
		 List<Integer> numbers = vo.getValueArr();
		 List<String> emps = vo.getEmpArr();
		 
		 BellVO bvo = new BellVO();
			bvo.setCntn("<a type='external' href='/aprvReq'>" + vo.getTtl() + "</a> 문서가 승인되었습니다.");
			bvo.setReceiver("수신인");
			bvo.setSender("발신인");
			
		for (String emp : emps) {
			bvo.setEmpNo(emp);
			bmap.bellInsert(bvo);
		}
			
		 int cnt = 0;
		 for(int aprvNo : numbers) {
			 vo.setAprvNo(aprvNo);
			 map.approved(vo);
			 map.aprvNext(vo);
			 cnt ++;
		  }
		
		return cnt;
	}
	
	

}
