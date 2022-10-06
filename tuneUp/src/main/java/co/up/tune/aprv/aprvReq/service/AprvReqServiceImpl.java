package co.up.tune.aprv.aprvReq.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.up.tune.aprv.aprvLine.mapper.AprvLineMapper;
import co.up.tune.aprv.aprvReq.mapper.AprvReqMapper;
import co.up.tune.aprv.vo.ApprovalVO;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.FormVO;
import co.up.tune.aprv.vo.ReferVO;

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
			// 문서번호 가져와서 참조 결재자 입력
			int aprvNo = vo.getAprvNo();

			ApprovalVO aprv = new ApprovalVO();
			aprv.setAprvNo(aprvNo);

			// 결재자 목록 처리
			String aprvrs = vo.getAprvr();

			if (!aprvrs.contains(",")) {
				aprv.setAprvr(aprvrs);
				aprv.setAprvSeq(1);
				lmap.approvalIn(aprv);

			} else {
				String[] arrAp = aprvrs.split(",");
				cnt = 1; // 결재순서

				for (String ap : arrAp) {
					aprv.setAprvr(ap);
					aprv.setAprvSeq(cnt);//결재순서
					lmap.approvalIn(aprv);
					cnt++;
				}

			}

			// 참조인 목록 처리
			ReferVO rf = new ReferVO();
			rf.setAprvNo(aprvNo);

			String refers = vo.getRefer();
			if (!refers.contains(",")) {
				rf.setEmpNo(refers);
				lmap.referIn(rf);

			} else {
				String[] arrRf = refers.split(",");
				for (String emp : arrRf) {
					rf.setEmpNo(emp);
					lmap.referIn(rf);

				}
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
