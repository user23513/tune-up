package co.up.tune.aprv.aprvReq.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import co.up.tune.aprv.aprvReq.service.AprvReqService;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.FormVO;

/**
 * 전자결재 신청 AjaxController
 * @author 윤정은
 * @date 2022.09.22
 * @version 1.2
 **/

@RestController
public class AjaxAprvReqController {

	@Autowired
	AprvReqService rs;
	@Value("${file.dir}") 
	private String fileDir;

	// 문서 상세
	@PostMapping("/aprvView")
	public AprvVO aprvView(AprvVO vo) {
		return rs.aprvSelect(vo);
	}

	// 서식 상세
	@PostMapping("/formView")
	public FormVO formView(FormVO vo) {
		return rs.formSelect(vo);
	}





}
