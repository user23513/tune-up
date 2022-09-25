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
	AprvReqMapper req;

	@Override
	public List<AprvVO> aprvReqList(AprvVO vo) {
		return req.aprvReqList(vo);
	}

	@Override
	public AprvVO aprvReqSelect(AprvVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int aprvReqIn(AprvVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int aprvReqUp(AprvVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int aprvReqDel(AprvVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<FormVO> formList(FormVO vo) {
		return req.formList(vo);
	}

	@Override
	public FormVO formSelect(FormVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int formUp(FormVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int formIn(FormVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int formDel(FormVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	
	


}
