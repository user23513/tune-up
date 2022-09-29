package co.up.tune.emp.attd.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import co.up.tune.emp.attd.service.AttdService;
import co.up.tune.emp.vo.AttdVO;


@RestController
public class AttdAjaxController {
	
	@Autowired
	AttdService dao;
	

	//출근기록 저장 - 에러메세지 뜨게 수정해야함~~
	@PostMapping("/startAttd")
	public String startAttd(AttdVO vo) {
		dao.startAttd(vo);
		int attd = dao.startAttd(vo);
	if(attd != 0) {
		
	return "redirect:/main";
	}
	return "main/main";
		
	}
	
	//퇴근기록 저장
	@PostMapping("/endAttd")
	public Date endAttd(AttdVO vo) {
		dao.endAttd(vo);
		return vo.getAfwkDttm();
	}
	
	
}
