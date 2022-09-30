package co.up.tune.aprv.aprvReq.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.up.tune.aprv.aprvReq.service.AprvReqService;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.FormVO;
import co.up.tune.common.service.CommonService;

@RestController
public class AjaxAprvReqController {

	@Autowired
	CommonService cd;
	@Autowired
	AprvReqService ap;
	
	@RequestMapping("/aprvView")	
	public AprvVO aprvView(AprvVO vo) {
		
		
		return ap.aprvReqSelect(vo);
			
		}
	
	@RequestMapping("/formView")	
	public FormVO formView(FormVO vo) {
	
		return ap.formSelect(vo);
			
		}
		
		
	

}
