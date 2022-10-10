package co.up.tune.com.note.web;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import co.up.tune.aprv.aprvLine.service.AprvLineService;
import co.up.tune.com.note.service.NoteService;
import co.up.tune.com.vo.NoteVO;

@Controller
public class NoteController {
	
	@Autowired
	NoteService dao;
	
	@Autowired
	AprvLineService ls;

	//쪽지 홈
	@RequestMapping("/noteHome")
	public String noteHome(@RequestParam(value="pageNum", required = false, defaultValue = "1") int pageNum, HttpSession session, Model model) {
		String empNo = (String)session.getAttribute("empNo");
		
		PageInfo<NoteVO> rNoteList = new PageInfo<>(dao.rNoteList(empNo, pageNum),10);
		PageInfo<NoteVO> sNoteList = new PageInfo<>(dao.sNoteList(empNo, pageNum),10);
		PageInfo<NoteVO> kNoteList = new PageInfo<>(dao.kNoteList(empNo, pageNum),10);
		
		model.addAttribute("sList", sNoteList); //보낸쪽지
		model.addAttribute("rList", rNoteList); //받는 쪽지
		model.addAttribute("kList", kNoteList); //보관함
		return "com/note/noteHome";
	}
	
	//쪽지 쓰기 팝업창
	@GetMapping("/noteForm")
	public String noteForm() {
		return "com/note/noteForm";
	}
	
	//쪽지 주소록 팝업창
	@GetMapping("/deptList")
	public String deptList(Model model) {
		// 부서조회
		model.addAttribute("dept", ls.aprvDeptList());
		return "com/note/deptList";
	}
	
}
