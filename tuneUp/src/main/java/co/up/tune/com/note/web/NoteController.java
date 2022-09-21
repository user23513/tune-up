package co.up.tune.com.note.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoteController {

		@RequestMapping("/noteHome")
		public String noteHome() {
			return "";
		}
}
