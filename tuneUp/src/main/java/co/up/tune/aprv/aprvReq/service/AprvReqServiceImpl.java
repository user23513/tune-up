package co.up.tune.aprv.aprvReq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.up.tune.aprv.aprvReq.mapper.AprvReqMapper;
import co.up.tune.aprv.vo.AprvVO;

@Service
public class AprvReqServiceImpl implements AprvReqService {

	@Autowired
	AprvReqMapper req;

	@Override
	public List<AprvVO> aprvList(AprvVO vo) {
		return req.aprvList(vo);
	}
	
	
	
	


}
