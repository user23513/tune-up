package co.up.tune.aprv.aprvReq.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.up.tune.aprv.aprvReq.service.AprvReqService;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.common.service.CommonService;

@RestController
public class AjaxAprvReqController {

	@Autowired
	CommonService cd;
	@Autowired
	AprvReqService ap;
	
	@PostMapping("/reqSt")	
	public List<AprvVO>reqSt(AprvVO vo) {
	
		List<AprvVO> list = ap.aprvReqList(vo);
	
		return list;
			
		}
	

	@RequestMapping("/aprvView")	
	public AprvVO aprvView(AprvVO vo) {
		
		vo= ap.aprvReqSelect(vo);
		
		return vo;
			
		}
		
		
	

}
