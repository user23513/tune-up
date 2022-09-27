package co.up.tune.com.notice.web;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import co.up.tune.com.notice.service.NoticeService;
import co.up.tune.com.vo.CommunityVO;
import co.up.tune.file.service.FileService;
import co.up.tune.prj.vo.FilesVO;

@Controller
public class NoitceController {
	
	@Autowired
	NoticeService dao;
	
	@Autowired
	FileService fdao;
	
	//공지사항 리스트
	@GetMapping("/noticeList")
	public String noticeList(Model model) {
		model.addAttribute("noticeList", dao.noticeList());
		return "com/notice/noticeList";
	}
	
	//공지사항 등록 폼으로 이동
	@GetMapping("/noticeInsertForm")
	public String noticeInserForm() {
		return "com/notice/noticeInsertForm";
	}
	
	//공지사항 등록(파일까지)
	@PostMapping("/noticeInsert")
	public String noticeInsert(CommunityVO vo, @RequestParam("file") MultipartFile[] files) throws IllegalStateException, IOException {
		//file upload 처리
		List<FilesVO> list = new ArrayList<>();
		String folder = "com"; //Temp안에 폴더명
		if(files.length != 0) {
			list = fdao.fileUpload(files, folder);
			
			vo.setFNm(list.get(0).getFNm());
			vo.setFPath(list.get(0).getFPath());
		}
		
		//긴급공지 체크되었을때 "1", 안되었을때 "0"
		if(vo.getEmerg() == null) {
			vo.setEmerg("0");
		} else {
			vo.setEmerg("1");
		}
		dao.noticeInsert(vo);
		
		return "redirect:/noticeList";
	}
	
	//공지사항 상세조회
	@PostMapping("/noticeSelect")
	public String noticeSelect(CommunityVO vo, Model model) {
		dao.noticeHitUpdate(vo);
		model.addAttribute("n", dao.noticeSelect(vo));
		return "com/notice/noticeSelect";
	}
	
	@GetMapping("/noticeSelect")
	public String noticeSelect(@RequestParam("postNo")int postNo, Model model) {
		CommunityVO vo = new CommunityVO();
		vo.setPostNo(postNo);
		model.addAttribute("n", dao.noticeSelect(vo));
		return "com/notice/noticeSelect";
	}
	
	//공지사항 파일 다운로드
//	@GetMapping("/attach") //img src에 /atthach/{no}대신에 파일이름 해놓으면 다운받아서 보여준다.
//	public ResponseEntity<Object> download() {
//		String aa = "C:/Temp/com/2b3cc990-063c-40d5-a1e6-400689ba6ea9.jpg";
//		try {
//			Path filePath = Paths.get(aa);
//			Resource resource = new InputStreamResource(Files.newInputStream(filePath)); // 파일 resource 얻기
//			
//			File file = new File(aa);
//			
//			HttpHeaders headers = new HttpHeaders();
//			headers.setContentDisposition(ContentDisposition.builder("attachment").filename(file.getName()).build());  // 다운로드 되거나 로컬에 저장되는 용도로 쓰이는지를 알려주는 헤더
//			
//			return new ResponseEntity<Object>(resource, headers, HttpStatus.OK);
//		} catch(Exception e) {
//			return new ResponseEntity<Object>(null, HttpStatus.CONFLICT);
//		}
//	}
	
	
	//	public ResponseEntity<UrlResource> download(@PathVariable("fPath") String fPath) throws IOException {
//		//파일 다운로드
////		vo.setPostNo(no);
////		vo = dao.noticeSelect(vo);
////		String filePath = vo.getFPath();
//		File target = new File(fPath);//filePath 대신에 서버에 있는 파일이름(앞에 폴더명이랑)
//		HttpHeaders header = new HttpHeaders();
//		UrlResource rs = null;
//		if(target.exists()) {
//			try {
//				String mimeType = Files.probeContentType(Paths.get(target.getAbsolutePath()));
//				if(mimeType == null) {
//					mimeType = "octet-stream";
//				}
//				rs = new UrlResource(target.toURI());
//				header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + rs.getFilename() + "\"");
//				header.setCacheControl("no-cache");
//				header.setContentType(MediaType.parseMediaType(mimeType));
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
//		
//		return new ResponseEntity<UrlResource>(rs, header, HttpStatus.OK);
//		
//	}
	
	//공지사항 수정폼으로 이동
	@PostMapping("/noticeUpdateForm")
	public String noticeUpdateForm(CommunityVO vo, Model model) {
		model.addAttribute("n", dao.noticeSelect(vo));
		return "com/notice/noticeUpdateForm";
	}
	
	//공지사항 수정
	@PostMapping("/noticeUpdate")
	public String noticeUpdate(CommunityVO vo, @RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		//file upload 처리
		if(!file.isEmpty()) {
			//vo = fdao.fileUpload(vo, file);
		}
				
		//긴급공지 체크되었을때 "1", 안되었을때 "0"
		if(vo.getEmerg()==null) {
			vo.setEmerg("0");
		} else {
			vo.setEmerg("1");
		}
		
		dao.noticeUpdate(vo);
		
		return "redirect:/noticeList";
	}
	
	//공지사항 삭제
	@PostMapping("/noticeDelete")
	public String noticeDelete(CommunityVO vo) {
		dao.noticeDelete(vo);
		return "redirect:/noticeList";
	}
	
	//=================================
	@GetMapping("/gantt")
	public String gantt() {
		return "com/notice/gantt";
	}
	
	

}
