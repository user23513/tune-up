package co.up.tune.com.bell.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import co.up.tune.com.bell.service.BellService;
import co.up.tune.com.vo.BellVO;

@RestController
public class BellAjaxController {
	
	@Autowired
	BellService dao;
	
//	@PostMapping("/bellList")
//	public BellVO bellList(BellVO vo) {
//		return dao.bellList(vo);
//	}

	@PostMapping("/bellInsert")
	public String bellInsert(BellVO vo) {
		dao.bellInsert(vo);
		return "insert";
	}
	
	@PostMapping("/bellDelete")
	public int bellDelete(BellVO vo) {
		return dao.bellDelete(vo);
	}
	
	@GetMapping("/bellCount")
	public int bellCount() {
		return dao.bellCount();
	}
}
