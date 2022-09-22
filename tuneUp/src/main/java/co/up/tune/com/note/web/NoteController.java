package co.up.tune.com.note.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.up.tune.com.note.service.NoteService;


@Controller
public class NoteController {
	@Autowired
	NoteService dao;

		@RequestMapping("/noteHome")
		public String noteHome(Model model) {
			model.addAttribute("s", dao.sNoteList());
			model.addAttribute("r", dao.rNoteList());
			model.addAttribute("k", dao.kNoteList());
			return "com/note/noteHome";
		}
}
