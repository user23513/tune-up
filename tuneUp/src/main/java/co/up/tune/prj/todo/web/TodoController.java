package co.up.tune.prj.todo.web;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.up.tune.com.vo.ReplyVO;
import co.up.tune.prj.todo.service.TodoDetailService;
import co.up.tune.prj.todo.service.TodoService;
import co.up.tune.prj.vo.TodoDetailVO;
import co.up.tune.prj.vo.TodoVO;

@Controller
public class TodoController {
	@Autowired
	TodoService tdao;
	
	@Autowired
	TodoDetailService detail;

	
	@RequestMapping("/todoList")
	public String todoList(TodoVO tvo,TodoDetailVO dvo, ReplyVO rvo, Model model) {
		
//		
		model.addAttribute("t", tdao.todoList());
		rvo.setPostNo(tvo.getPostNo());
		dvo.setPostNo(tvo.getPostNo());
		
//		model.addAttribute("d", detail.detailList());
		model.addAttribute("r", tdao.replyList());
		
		return "prj/todo/todoList";
	}
	
	@GetMapping("/todoInsertForm")
	public String todoInsertForm() {
		return "prj/todo/todoInsertForm";
	}
	
	@PostMapping("/todoInsert")
	public String todoInsert(TodoVO vo) {
		tdao.todoInsert(vo);
		return "redirect:/todoList";
	}
}
