package co.up.tune.com.bell.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import co.up.tune.com.bell.service.BellService;
import co.up.tune.com.vo.BellVO;

@RestController
public class BellAjaxController {
	
	@Autowired
	BellService dao;
	
	@PostMapping("/bellInsert")
	public String bellInsert(BellVO vo) {
		dao.bellInsert(vo);
		return "insert";
	}
	
	@PostMapping("/bellDelete")
	public int bellDelete(BellVO vo) {
		return dao.bellDelete(vo);
	}
	
	@PostMapping("/bellCount")
	public int bellCount(BellVO vo) {
		return dao.bellCount(vo);
	}
}
