package co.up.tune.aprv.aprvAdmin.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import co.up.tune.aprv.aprvAdmin.service.AprvAdminService;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.FormVO;
import co.up.tune.common.service.CommonService;

@RestController
public class AjaxAprvAdminController {

	@Autowired
	CommonService cd;
	@Autowired
	AprvAdminService ap;
	
	
	//상태카테고리
	@PostMapping("/reqAdSt")	
	public List<AprvVO> aprvAdSt(AprvVO vo, HttpServletRequest request){
		return ap.aprvListAll(vo.getReqSt());	
	}
	@PostMapping("/formAdCat")	
	public List<FormVO> formAdCat(FormVO vo, HttpServletRequest request){
		return ap.aprvFormAll(vo.getFormCat());	
	}
	
	//상세화면
	@PostMapping("/reqAdView")	
	public AprvVO aprvAdView(AprvVO vo, HttpServletRequest request){
		return ap.aprvSelect(vo);	
	}	
	@PostMapping("/formAdView")	
	public FormVO formAdView(FormVO vo, HttpServletRequest request){
		return ap.formSelect(vo);	
	}

}
