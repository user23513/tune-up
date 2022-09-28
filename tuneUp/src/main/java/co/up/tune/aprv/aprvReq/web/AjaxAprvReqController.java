package co.up.tune.aprv.aprvReq.web;

import org.springframework.beans.factory.annotation.Autowired;
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

	@RequestMapping("/aprvView")	
	public AprvVO aprvView(AprvVO vo) {
		
		vo= ap.aprvReqSelect(vo);
		
		return vo;
			
		}
		
		
	

}
