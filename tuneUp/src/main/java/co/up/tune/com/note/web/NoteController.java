package co.up.tune.com.note.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import co.up.tune.aprv.aprvLine.service.AprvLineService;
import co.up.tune.com.note.service.NoteService;
import co.up.tune.com.vo.CommunityVO;
import co.up.tune.com.vo.NoteVO;
import co.up.tune.com.vo.SearchVO;
import co.up.tune.emp.vo.EmpVO;

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
		
		model.addAttribute("sList", sNoteList); //보낸쪽지
		model.addAttribute("rList", rNoteList); //받는 쪽지
		model.addAttribute("k", dao.kNoteList());
		return "com/note/noteHome";
	}
	
	//받는쪽지 페이징 ajax
	@ResponseBody
	@GetMapping("/ajaxNoteHome")
	public PageInfo<NoteVO> ajaxNoteHome(@RequestParam(value="pageNum", required = false, defaultValue = "1") int pageNum, HttpSession session, Model model) {
		String empNo = (String)session.getAttribute("empNo");
		
		PageInfo<NoteVO> rNoteList = new PageInfo<>(dao.rNoteList(empNo, pageNum),10);
		
		return rNoteList;
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
	
	//쪽지 갯수
	@ResponseBody
	@PostMapping("/noteCount")
	public int noteCount(NoteVO vo) {
		return dao.noteCount(vo);
	}
	
	//쪽지 삭제
	@ResponseBody
	@PostMapping("/noteDelete")
	public int noteDelete(NoteVO vo) {
		return dao.noteDelete(vo);
	}
}
