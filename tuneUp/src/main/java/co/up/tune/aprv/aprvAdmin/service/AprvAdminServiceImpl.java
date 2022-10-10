package co.up.tune.aprv.aprvAdmin.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.up.tune.aprv.aprvAdmin.mapper.AprvAdminMapper;
import co.up.tune.aprv.vo.ApprovalVO;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.FormVO;
import co.up.tune.com.bell.mapper.BellMapper;
import co.up.tune.com.vo.BellVO;

/**
 * 전자결재 관리 ServiceImpl
 * @author 윤정은
 * @date 2022.09.28
 * @version 1.1
 **/

@Service
public class AprvAdminServiceImpl implements AprvAdminService {

	@Autowired
	AprvAdminMapper map;
	@Autowired
	BellMapper bmap;
	
	@Override
	public List<AprvVO> aprvListAll(String reqSt) {
		return map.aprvListAll(reqSt);
	}

	@Override
	@Transactional
	public int aprvAdminDel(AprvVO vo) {
		int cnt = map.approvalAdminDel(vo);
		cnt += map.aprvAdminDel(vo);
		return cnt;
	}

	@Override
	public List<FormVO> aprvFormAll(String formCat) {
		return map.aprvFormAll(formCat);
	}

	@Override
	@Transactional
	public int aprvAdReject(ApprovalVO vo) {
		BellVO bvo = new BellVO();
		bvo.setCntn("관리자님이 <a type='external' href='/aprvReq'>" + vo.getTtl() + "</a> 문서를 반려하셨습니다.");
		bvo.setEmpNo(Integer.parseInt(vo.getEmpNo()));
		bvo.setReceiver("수신인");
		bvo.setSender("관리자");
		bmap.bellInsert(bvo);
		
		int cnt = map.aprvAdReject(vo);
		cnt = map.reqAdReject(vo);
		return cnt;
	}

	@Override
	@Transactional
	public int aprvAdOk(ApprovalVO vo) {
		BellVO bvo = new BellVO();
		bvo.setCntn("관리자님이 <a type='external' href='/aprvReq'>" + vo.getTtl() + "</a> 문서를 승인하셨습니다.");
		bvo.setEmpNo(Integer.parseInt(vo.getEmpNo()));
		bvo.setReceiver("수신인");
		bvo.setSender("관리자");
		bmap.bellInsert(bvo);
		
		int cnt = map.aprvAdOk(vo);
		cnt = map.reqAdOk(vo);
		return cnt;
	}

	

}
