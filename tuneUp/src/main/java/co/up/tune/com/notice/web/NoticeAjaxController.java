package co.up.tune.com.notice.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import co.up.tune.com.notice.service.NoticeService;
import co.up.tune.prj.vo.BusinessVO;

@RestController
public class NoticeAjaxController {
	@Autowired
	NoticeService dao;
	
	@PostMapping("/ganttList")
	public List<BusinessVO> ganttList(BusinessVO vo){
		System.out.println();
		return dao.ganttList(vo);
	}

}
