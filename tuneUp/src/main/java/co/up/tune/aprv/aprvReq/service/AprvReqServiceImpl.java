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
	public AprvVO aprvReqSelect(AprvVO vo) {
		return map.aprvReqSelect(vo);
	}

	@Override
	@Transactional
	public int aprvReqIn(AprvVO vo) {
		// 마감일시 처리
		vo.setDeadline(vo.getDeadDay() + " " + vo.getDeadTime());

		// 중요도 처리
		if (vo.getImpts() == "on") {
			vo.setImpts("Y");
		} else {
			vo.setImpts("N");
		}
		
		int cnt = map.aprvReqIn(vo);
		// 입력 완료시
		if (cnt != 0) {
			// 입력된 문서번호 가져와서 참조 결재자 입력
			int aprvNo = vo.getAprvNo();

			ApprovalVO aprv = new ApprovalVO();
			aprv.setAprvNo(aprvNo);

			// 폼에서 가져온 결재자 목록 처리
			String aprvr = vo.getAprvr();

			if (!aprvr.contains(",")) {
				aprv.setAprvr(aprvr);
				aprv.setAprvSeq(1);
				lmap.approvalIn(aprv);

			} else {
				String[] arrAp = aprvr.split(",");
				int a = 1; // 결재순서

				for (String i : arrAp) {
					aprv.setAprvr(i);
					aprv.setAprvSeq(a);
					lmap.approvalIn(aprv);
					a++;
				}

			}

			// 반복
			ReferVO rf = new ReferVO();
			rf.setAprvNo(aprvNo);

			// 폼에서 가져온 참조인 목록 처리
			String refer = vo.getRefer();
			if (!refer.contains(",")) {
				rf.setEmpNo(refer);
				lmap.referIn(rf);

			} else {
				String[] appRf = refer.split(",");
				for (String i : appRf) {
					rf.setEmpNo(i);
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
