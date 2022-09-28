package co.up.tune.prj.todo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.up.tune.com.vo.ReplyVO;
import co.up.tune.prj.todo.service.TodoDetailService;
import co.up.tune.prj.todo.service.TodoService;
import co.up.tune.prj.vo.TodoVO;

@Controller
public class TodoController {
	@Autowired
	TodoService tdao;
	
	/*
	 * @Autowired TodoDetailService ddao;
	 */
	
	@RequestMapping("/todoList")
	public String todoList(TodoVO tvo, ReplyVO rvo, Model model) {
		model.addAttribute("todoList", tdao.todoList());
		rvo.setPostNo(tvo.getPostNo());
		model.addAttribute("tdReplyList", tdao.replyList());
		return "prj/todo/todoList";
	}
}
