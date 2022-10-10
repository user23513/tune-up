package co.up.tune.com.note.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

import co.up.tune.aprv.aprvLine.service.AprvLineService;
import co.up.tune.com.note.service.NoteService;
import co.up.tune.com.vo.NoteVO;
import co.up.tune.emp.vo.EmpVO;

@RestController
public class NoteAjaxController {
	
	@Autowired
	NoteService dao;
	
	@Autowired
	AprvLineService ls;

	//받는쪽지 페이징 ajax
	@GetMapping("/ajaxRNoteList")
	public PageInfo<NoteVO> ajaxRNoteList(@RequestParam(value="pageNum", required = false, defaultValue = "1") int pageNum, HttpSession session, Model model) {
		String empNo = (String)session.getAttribute("empNo");
		
		PageInfo<NoteVO> rNoteList = new PageInfo<>(dao.rNoteList(empNo, pageNum),10);
		
		return rNoteList;
	}
	
	//보낸쪽지 페이징 ajax
	@GetMapping("/ajaxSNoteList")
	public PageInfo<NoteVO> ajaxSNoteList(@RequestParam(value="pageNum", required = false, defaultValue = "1") int pageNum, HttpSession session, Model model) {
		String empNo = (String)session.getAttribute("empNo");
		
		PageInfo<NoteVO> sNoteList = new PageInfo<>(dao.sNoteList(empNo, pageNum),10);
		
		return sNoteList;
	}
	
	//보관함 페이징 ajax
	@GetMapping("/ajaxKNoteList")
	public PageInfo<NoteVO> ajaxKNoteList(@RequestParam(value="pageNum", required = false, defaultValue = "1") int pageNum, HttpSession session, Model model) {
		String empNo = (String)session.getAttribute("empNo");
		
		PageInfo<NoteVO> kNoteList = new PageInfo<>(dao.kNoteList(empNo, pageNum),10);
		
		return kNoteList;
	}
	
	//쪽지 클릭한 부서 사원들
	@PostMapping("/deptEmp")
	public List<EmpVO> deptEmp(EmpVO vo){
		return ls.aprvEmpList(vo);
	}
	
	//쪽지 보내기
	@PostMapping("/sendNote")
	public NoteVO sendNote(NoteVO vo, HttpSession session) {
		vo.setReceiver((String)session.getAttribute("nm"));
		vo.setREmpNo((String)session.getAttribute("empNo"));
		int cnt = dao.sendNote(vo);
		vo.setSendConut(cnt);
		return vo;
	}
	
	//쪽지 갯수
	@PostMapping("/noteCount")
	public int noteCount(NoteVO vo) {
		return dao.noteCount(vo);
	}
	
	//쪽지 삭제
	@PostMapping("/noteDelete")
	public int noteDelete(NoteVO vo) {
		return dao.noteDelete(vo);
	}
	
	//쪽지 보관
	@PostMapping("/noteKeep")
	public int noteKeep(NoteVO vo) {
		return dao.noteKeep(vo);
	}
	
}
