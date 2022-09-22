package co.up.tune.com.free.web;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import co.up.tune.com.free.service.FreeService;
import co.up.tune.com.notice.service.FileService;
import co.up.tune.com.vo.CommunityVO;
import co.up.tune.com.vo.ReplyVO;

@Controller
public class FreeController {
	
	@Autowired
	FreeService dao;
	
	@Autowired
	FileService fdao;
	
	//자유게시판 리스트로 이동
	@GetMapping("freeList")
	public String freeList(Model model) {
		//model.addAttribute("freeList", dao.freeList());
		return "com/free/freeList";
	}
	
	//자유게시판 등록폼으로 이동
	@GetMapping("/freeInsertForm")
	public String freeInsertForm() {
		return "com/free/freeInsertForm";
	}
	
	//자유게시판 등록(파일까지)
	@PostMapping("/freeInsert")
	public String freeInsert(CommunityVO vo, @RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		//file upload 처리
		if(!file.isEmpty()) {
			vo = fdao.fileUpload(vo, file);
		}
		dao.freeInsert(vo);
		
		return "redirect:/freeList";
	}
	
	//자유게시판 상세조회
	@PostMapping("/freeSelect")
	public String freeSelect(CommunityVO cvo, ReplyVO rvo, Model model) {
		dao.freeHitUpdate(cvo);
		model.addAttribute("f", dao.freeSelect(cvo));
		
		//댓글 리스트
		rvo.setPostNo(cvo.getPostNo());
		model.addAttribute("replyList", dao.replyList(rvo));
		return "com/free/freeSelect";
	}
	
	//자유게시판 수정폼으로 이동
	@PostMapping("/freeUpdateForm")
	public String freeUpdateForm(CommunityVO vo, Model model) {
		model.addAttribute("f", dao.freeSelect(vo));
		return "com/free/freeUpdateForm";
	}
	
	//자유게시판 수정
	@PostMapping("/freeUpdate")
	public String freeUpdate(CommunityVO vo, @RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		//file upload 처리
		if(!file.isEmpty()) {
			vo = fdao.fileUpload(vo, file);
		}
					
		dao.freeUpdate(vo);
			
		return "redirect:/freeList";
	}
	
	//자유게시판 삭제
	@PostMapping("/freeDelete")
	public String freeDelete(CommunityVO vo) {
		dao.freeDelete(vo);
		return "redirect:/freeList";
	}
	
	
}
