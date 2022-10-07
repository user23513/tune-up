package co.up.tune.com.note.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.up.tune.aprv.aprvLine.service.AprvLineService;
import co.up.tune.com.note.service.NoteService;
import co.up.tune.com.vo.NoteVO;
import co.up.tune.emp.vo.EmpVO;

@Controller
public class NoteController {
	
	@Autowired
	NoteService dao;
	
	@Autowired
	AprvLineService ls;

	//쪽지 홈
	@RequestMapping("/noteHome")
	public String noteHome(Model model) {
		model.addAttribute("s", dao.sNoteList());
		model.addAttribute("r", dao.rNoteList());
		model.addAttribute("k", dao.kNoteList());
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
	
	//쪽지 클릭한 부서 사원들
	@ResponseBody
	@PostMapping("/deptEmp")
	public List<EmpVO> deptEmp(EmpVO vo){
		return ls.aprvEmpList(vo);

	}
	
	//쪽지 보내기
	@ResponseBody
	@PostMapping("/sendNote")
	public NoteVO sendNote(NoteVO vo, HttpSession session) {
		vo.setReceiver((String)session.getAttribute("nm"));
		vo.setREmpNo((String)session.getAttribute("empNo"));
		int cnt = dao.sendNote(vo);
		vo.setSendConut(cnt);
		return vo;

	}
}
