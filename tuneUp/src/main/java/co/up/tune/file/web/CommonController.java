package co.up.tune.file.web;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommonController {
	
	@Value("${file.dir}")
	String dir;
	
	//a태그이면 파일 다운로드, img태그이면 파일보여주기
	@GetMapping("/attach")
	public ResponseEntity<Object> download(@RequestParam("path")String path) {
		try {
			Path filePath = Paths.get(dir,path);
			Resource resource = new InputStreamResource(Files.newInputStream(filePath)); // 파일 resource 얻기
			
			File file = new File(dir,path);
			
			// 다운로드 되거나 로컬에 저장되는 용도로 쓰이는지를 알려주는 헤더
			HttpHeaders headers = new HttpHeaders();
			headers.setContentDisposition(ContentDisposition.builder("attachment").filename(file.getName()).build());  
			
			return new ResponseEntity<Object>(resource ,headers, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<Object>(null, HttpStatus.CONFLICT);
		}
	}

}
