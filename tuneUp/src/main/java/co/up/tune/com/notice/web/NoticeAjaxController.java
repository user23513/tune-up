package co.up.tune.com.notice.web;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
