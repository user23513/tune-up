package co.up.tune.com.notice.web;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
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

import co.up.tune.com.notice.service.FileService;
import co.up.tune.com.notice.service.NoticeService;
import co.up.tune.com.vo.CommunityVO;

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
	public String noticeInsert(CommunityVO vo, @RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		//file upload 처리
		if(!file.isEmpty()) {
			vo = fdao.fileUpload(vo, file);
		}
		
		//긴급공지 체크되었을때 "1", 안되었을때 "0"
		if(vo.getEmerg()==null) {
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
	
	//공지사항 파일 다운로드
	@GetMapping("/attach/{no}")
	public ResponseEntity<UrlResource> download(CommunityVO vo ,@PathVariable("no") int no) {
		//파일 다운로드
		vo.setPostNo(no);
		vo = dao.noticeSelect(vo);
		
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
			vo = fdao.fileUpload(vo, file);
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
	

}
