package co.up.tune.com.free.web;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;

import co.up.tune.com.free.service.FreeService;
import co.up.tune.com.vo.CommunityVO;
import co.up.tune.com.vo.ReplyVO;
import co.up.tune.file.service.FileService;
import co.up.tune.paging.vo.pagingVO;

@Controller
public class FreeController {

	@Autowired
	FreeService dao;

	@Autowired
	FileService fdao;
	
	// 자유게시판 리스트로 이동
	@GetMapping("freeList")
	public String freeList(@RequestParam(value="pageNum", required = false, defaultValue = "1") int pageNum, Model model) { // 페이징 처리
		PageInfo<CommunityVO> p = new PageInfo<>(dao.freeList(pageNum),10);
		model.addAttribute("fList", p);
		return "com/free/freeList";
	}

	// 자유게시판 등록폼으로 이동
	@GetMapping("/freeInsertForm")
	public String freeInsertForm() {
		return "com/free/freeInsertForm";
	}

	// 자유게시판 등록
	@PostMapping("/freeInsert")
	public String freeInsert(CommunityVO vo){
		dao.freeInsert(vo);

		return "redirect:/freeList";
	}

	// 자유게시판 상세조회
	@PostMapping("/freeSelect")
	public String freeSelect(CommunityVO cvo, ReplyVO rvo, Model model) {
		dao.freeHitUpdate(cvo);
		model.addAttribute("f", dao.freeSelect(cvo));

		// 댓글 리스트
		rvo.setPostNo(cvo.getPostNo());
		model.addAttribute("replyList", dao.replyList(rvo));
		return "com/free/freeSelect";
	}

	// 자유게시판 수정폼으로 이동
	@PostMapping("/freeUpdateForm")
	public String freeUpdateForm(CommunityVO vo, Model model) {
		model.addAttribute("f", dao.freeSelect(vo));
		return "com/free/freeUpdateForm";
	}

	// 자유게시판 수정
	@PostMapping("/freeUpdate")
	public String freeUpdate(CommunityVO vo, @RequestParam("file") MultipartFile file)
			throws IllegalStateException, IOException {
		// file upload 처리
		if (!file.isEmpty()) {
			//vo = fdao.fileUpload(vo, file);
		}

		dao.freeUpdate(vo);

		return "redirect:/freeList";
	}

	// 자유게시판 삭제
	@PostMapping("/freeDelete")
	public String freeDelete(CommunityVO vo) {
		dao.freeDelete(vo);
		return "redirect:/freeList";
	}

}
