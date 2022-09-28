package co.up.tune.aprv.aprvLine.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import co.up.tune.aprv.aprvLine.service.AprvLineService;
import co.up.tune.common.service.CommonService;

@Controller
public class AprvLineController {
	
	@Autowired
	CommonService cd;
	@Autowired
	AprvLineService ap;

}
