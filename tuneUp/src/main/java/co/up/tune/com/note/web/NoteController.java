package co.up.tune.com.note.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.up.tune.com.note.service.NoteService;


@Controller
public class NoteController {
	@Autowired
	NoteService dao;

		//쪽지 홈
		@RequestMapping("/noteHome")
		public String noteHome(Model model) {
			model.addAttribute("s", dao.sNoteList());
			model.addAttribute("r", dao.rNoteList());
			model.addAttribute("k", dao.kNoteList());
			return "com/note/noteHome";
		}
		
		//쪽지 쓰기 폼
		@GetMapping("/noteForm")
		public String noteForm() {
			return "com/note/noteForm";
		}
		
		//쪽지 주소록 멤버 리스트
		@GetMapping("/deptList")
		public String deptList() {
			return "com/note/deptList";
		}
}
