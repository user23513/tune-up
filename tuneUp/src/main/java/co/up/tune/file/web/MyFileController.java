package co.up.tune.file.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import co.up.tune.com.vo.CommunityVO;
import co.up.tune.file.service.FileService;
import co.up.tune.file.service.MyFileService;
import co.up.tune.prj.vo.FilesVO;

@Controller
public class MyFileController {
	@Autowired
	MyFileService mdao;
	@Autowired
	FileService fdao;
	
	//내 파일함 페이지
	@GetMapping("/files")
	public String files() {
		return "file/file";
	}
	
	//파일등록
	/*
	 * @PostMapping("/myFileInsert") public String noticeInsert(List<FilesVO>
	 * vo, @RequestParam("file") MultipartFile file) throws IllegalStateException,
	 * IOException { //file upload 처리 if(!file.isEmpty()) { //vo =
	 * fdao.fileUpload(vo,file); }// 맞는지 잘 모르겠음 ..
	 */
		
	//파일다운로드
	@GetMapping("/attach/{no}")
	public ResponseEntity<UrlResource> download(FilesVO vo ,@PathVariable("no") int no) {
		//파일 다운로드
		vo.setFileNo(no);
		vo = (FilesVO) mdao.myFileSelect(vo); //(FilesVO) ???
		
		String filePath = vo.getFPath();
		File target = new File(filePath);
		HttpHeaders header = new HttpHeaders();
		UrlResource rs = null;
		if(target.exists()) {
			try {
				String mimeType = Files.probeContentType(Paths.get(target.getAbsolutePath()));
				if(mimeType == null) {
					mimeType = "octet-stream";
				}
				rs = new UrlResource(target.toURI());
				header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + rs.getFilename() + "\"");
				header.setCacheControl("no-cache");
				header.setContentType(MediaType.parseMediaType(mimeType));
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return new ResponseEntity<UrlResource>(rs, header, HttpStatus.OK);
	}

}
