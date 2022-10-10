package co.up.tune.com.notice.web;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;

import co.up.tune.com.notice.service.NoticeService;
import co.up.tune.com.vo.CommunityVO;
import co.up.tune.com.vo.SearchVO;
import co.up.tune.file.service.FileService;
import co.up.tune.prj.vo.BusinessVO;
import co.up.tune.prj.vo.FilesVO;

@Controller
public class NoitceController {
	
	@Autowired
	NoticeService dao;
	
	@Autowired
	FileService fdao;
	
	@Value("${file.dir}")
	private String fileDir;
	
	//공지사항 리스트
	@GetMapping("/noticeList")
	public String noticeList(@ModelAttribute SearchVO search ,@RequestParam(value="pageNum", required = false, defaultValue = "1") int pageNum, Model model) {
		PageInfo<CommunityVO> p = new PageInfo<>(dao.noticeList(pageNum, search),10);
		model.addAttribute("nList", p);
		model.addAttribute("search", search);
		return "com/notice/noticeList";
	}
	
	//공지사항 등록 폼으로 이동
	@GetMapping("/noticeInsertForm")
	public String noticeInserForm() {
		return "com/notice/noticeInsertForm";
	}
	
	//공지사항 등록(파일까지)
	@ResponseBody
	@PostMapping("/noticeInsert")
	public CommunityVO noticeInsert(CommunityVO vo, @RequestParam("file") MultipartFile[] files) throws IllegalStateException, IOException {
		//file upload 처리
		List<FilesVO> list = new ArrayList<>();
		
		if(!files[0].isEmpty()) {
			String folder = "com"; //Temp안에 폴더명
			list = fdao.fileUpload(files, folder);
			vo.setFNm(list.get(0).getFNm());
			vo.setFPath(list.get(0).getFPath());
		}
		
		//긴급공지일 때 "1"
		if(vo.getEmerg() == null) {
			vo.setEmerg("0");
		}else {
			vo.setEmerg("1");
		}
		
		dao.noticeInsert(vo);
		
		return vo;
	}
	
	//공지사항 상세조회
	@GetMapping("/noticeDetail")
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
		int cnt = dao.noticeDelete(vo);
		if(cnt == 1) {
			File file = new File(fileDir + "\\" +vo.getFPath());
			file.delete();
		}
		return "redirect:/noticeList";
	}
	
	//간트 차트
	@ResponseBody
	@PostMapping("/ganttList")
	public List<BusinessVO> ganttList(BusinessVO vo){
		return dao.ganttList(vo);
	}
	

}
