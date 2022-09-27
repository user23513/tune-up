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
	
	@Value("${file.dir}")
	String dir;
	
	//a태그이면 파일 다운로드, img태그이면 파일보여주기
	@GetMapping("/attach")
	public ResponseEntity<Object> download(@RequestParam("path")String path) {
		try {
			Path filePath = Paths.get(dir,path);
			Resource resource = new InputStreamResource(Files.newInputStream(filePath)); // 파일 resource 얻기
			
			File file = new File(dir,path);
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentDisposition(ContentDisposition.builder("attachment").filename(file.getName()).build());  // 다운로드 되거나 로컬에 저장되는 용도로 쓰이는지를 알려주는 헤더
			
			return new ResponseEntity<Object>(resource ,headers, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<Object>(null, HttpStatus.CONFLICT);
		}
	}

}
