package co.up.tune.aprv.aprvReq.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.up.tune.aprv.aprvReq.mapper.AprvReqMapper;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.FormVO;

@Service
public class AprvReqServiceImpl implements AprvReqService {

	@Autowired
	AprvReqMapper map;

	@Override
	public List<AprvVO> aprvReqList(AprvVO vo) {
		return map.aprvReqList(vo);
	}

	@Override
	public AprvVO aprvReqSelect(AprvVO vo) {
		return map.aprvReqSelect(vo);
	}

	@Override
	public int aprvReqIn(AprvVO vo) {
		return map.aprvReqIn(vo);
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
