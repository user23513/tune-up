package co.up.tune.prj.prjMng.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import co.up.tune.emp.vo.EmpVO;
import co.up.tune.prj.prjMng.service.PrjMngService;

@RestController
public class PrjMngAjaxController {
	
	@Autowired
	PrjMngService pServ;

	@PostMapping("/tdeptList")
	public List<EmpVO> tdeptList(EmpVO vo) {
		return pServ.tdeptList(vo);
	}
		
	}

 
