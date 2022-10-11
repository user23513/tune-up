package co.up.tune.aprv.aprvReq.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.up.tune.aprv.aprvLine.mapper.AprvLineMapper;
import co.up.tune.aprv.aprvReq.mapper.AprvReqMapper;
import co.up.tune.aprv.vo.ApprovalVO;
import co.up.tune.aprv.vo.AprvLineVO;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.FormVO;
import co.up.tune.aprv.vo.ReferVO;
import co.up.tune.com.bell.mapper.BellMapper;
import co.up.tune.com.vo.BellVO;

/**
 * 전자결재 신청 ServiceImpl
 * @author 윤정은
 * @date 2022.09.22
 * @version 1.2
 **/

@Service
public class AprvReqServiceImpl implements AprvReqService {

	@Autowired
	AprvReqMapper map;
	@Autowired
	AprvLineMapper lmap;
	@Autowired
	BellMapper bmap;

	@Override
	public List<AprvVO> aprvReqList(AprvVO vo) {
		return map.aprvReqList(vo);
	}

	@Override
	public AprvVO aprvSelect(AprvVO vo) {
		return map.aprvSelect(vo);
	}

	@Override
	@Transactional
	public int aprvReqIn(AprvVO vo) {
		// 마감일시
		vo.setDeadline(vo.getDeadDay() + " " + vo.getDeadTime());

		// 중요
		if (vo.getImpts() != null) {
			vo.setImpts("Y");
		} else {
			vo.setImpts("N");
		}
		
		int cnt = map.aprvReqIn(vo);
		// 입력 완료시
		
		if (cnt != 0) {
			// 문서번호 가져와서 참조인 테이블 결재자 테이블 입력
			int aprvNo = vo.getAprvNo();

			ApprovalVO aprv = new ApprovalVO();
			aprv.setAprvNo(aprvNo);

			// 결재자 목록 처리
			AprvLineVO lvo = new AprvLineVO();
			lvo.setLineNo(vo.getLineNo());
			lvo = lmap.aprvLineSelect(lvo);
			
			//알림
			BellVO bvo = new BellVO();
			bvo.setSender("발신인");
			bvo.setReceiver("수신인");
			bvo.setCntn("<a type='external' href='/approval'>" + vo.getTtl() + "</a> 문서가 대기중입니다.");
			
			String[] arrAp;
			String[] arrNm;
			if (lvo.getAp3() != null) {
				arrAp =  new String[]{lvo.getAp1(),lvo.getAp2(),lvo.getAp3()}; 
				arrNm =  new String[]{lvo.getNm1(),lvo.getNm2(),lvo.getNm3()}; 
			} else if (lvo.getAp2() != null) {
				arrAp = new String[]{lvo.getAp1(),lvo.getAp2()}; 
				arrNm = new String[]{lvo.getNm1(),lvo.getNm2()}; 
			} else {
				arrAp = new String[]{lvo.getAp1()}; 
				arrNm = new String[]{lvo.getNm1()}; 
			}
			
			for(int i = 0; i<arrAp.length; i++) {
				aprv.setAprvr(arrAp[i]);
				aprv.setNm(arrNm[i]);
				aprv.setAprvSeq(i+1);//결재순서
				lmap.approvalIn(aprv);
				
				bvo.setEmpNo(Integer.parseInt(arrAp[i]));
				bmap.bellInsert(bvo);
			}
		
			// 참조인 목록 처리
			ReferVO rf = new ReferVO();
			rf.setAprvNo(aprvNo);
			bvo.setCntn("<a type='external' href='/approval'>" + vo.getTtl() + "</a> 문서의 참조인에 추가되었습니다.");
			
			String refers = vo.getRefer();
			String referNms = vo.getReferNm();
			
			if (refers.contains(",")){
				String[] arrRf = refers.split(",");
				String[] arrRfNm = referNms.split(",");
				
				for (int i = 0; i<arrRf.length; i++) {
					rf.setEmpNo(arrRf[i]);
					rf.setNm(arrRfNm[i]);
					lmap.referIn(rf);
					
					bvo.setEmpNo(Integer.parseInt(arrRf[i]));
					bmap.bellInsert(bvo);
					
				}
			} else if (refers != null && refers != "" && refers != " ") {
				rf.setEmpNo(refers);
				rf.setNm(referNms);
				lmap.referIn(rf);
				int no = Integer.parseInt(refers);
				bvo.setEmpNo(no);
				bmap.bellInsert(bvo);

			}
			
			
		}
		;
		return cnt;

	}

	@Override
	public List<FormVO> formList(FormVO vo) {
		return map.formList(vo);
	}

	@Override
	public FormVO formSelect(FormVO vo) {
		return map.formSelect(vo);
	}

	@Override
	public int formUp(FormVO vo) {
		return map.formUp(vo);
	}

	@Override
	public int formIn(FormVO vo) {
		return map.formIn(vo);
	}

	@Override
	public int formDel(FormVO vo) {
		return map.formDel(vo);
	}

}
