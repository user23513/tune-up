package co.up.tune.aprv.aprvLine.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import co.up.tune.aprv.aprvLine.service.AprvLineService;
import co.up.tune.common.service.CommonService;

@RestController
public class AjaxAprvLineController {
	
	@Autowired
	CommonService cd;
	@Autowired
	AprvLineService ap;

}
