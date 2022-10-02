package co.up.tune.aprv.aprvAdmin.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import co.up.tune.aprv.aprvAdmin.service.AprvAdminService;
import co.up.tune.aprv.aprvLine.service.AprvLineService;
import co.up.tune.aprv.vo.AprvLineVO;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.FormVO;
import co.up.tune.common.service.CommonService;

@RestController
public class AjaxAprvAdminController {

	@Autowired
	CommonService cd;
	@Autowired
	AprvAdminService ap;
	@Autowired
	AprvLineService li;
	
	//상세화면
	@PostMapping("/reqAdView")	
	public AprvVO aprvAdView(AprvVO vo){
		return ap.aprvSelect(vo);	
	}	
	@PostMapping("/formAdView")	
	public FormVO formAdView(FormVO vo){
		return ap.formSelect(vo);	
	}
	
	@PostMapping("/lineDept")	
	public List<AprvLineVO> lineDept(AprvLineVO vo){
		return li.aprvLineList(vo);	
	}
	

}
