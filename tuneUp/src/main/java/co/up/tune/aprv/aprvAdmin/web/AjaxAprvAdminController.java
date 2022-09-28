package co.up.tune.aprv.aprvAdmin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import co.up.tune.aprv.aprvAdmin.service.AprvAdminService;
import co.up.tune.common.service.CommonService;

@RestController
public class AjaxAprvAdminController {

	@Autowired
	CommonService cd;
	@Autowired
	AprvAdminService ap;

	
		
	

}
