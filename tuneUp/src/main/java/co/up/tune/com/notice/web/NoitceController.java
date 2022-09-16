package co.up.tune.com.notice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import co.up.tune.com.notice.service.NoticeService;
import co.up.tune.com.vo.CommunityVO;

@Controller
public class NoitceController {
	
	@Autowired
	NoticeService dao;
	
	@GetMapping("/noticeList")
	public String noticeList(Model model) {
		model.addAttribute("noticeList", dao.noticeList());
		return "com/noticeList";
	}
	
	@GetMapping("/noticeInsertForm")
	public String noticeInserForm() {
		return "com/noticeInsertForm";
	}
	
	@PostMapping("/noticeInsert")
	public String noticeInsert(CommunityVO vo) {
		dao.noticeInsert(vo);
		return "redirect:/noticeList";
	}
	
	@PostMapping("/noticeSelect")
	public String noticeSelect(CommunityVO vo, Model model) {
		
		return "com/noticeSelect";
	}

}
