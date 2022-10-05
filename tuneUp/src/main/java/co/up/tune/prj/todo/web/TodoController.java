package co.up.tune.prj.todo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.up.tune.com.vo.ReplyVO;
import co.up.tune.prj.todo.service.DemoTodoService;
import co.up.tune.prj.todo.service.TodoDetailService;
import co.up.tune.prj.todo.service.TodoService;
import co.up.tune.prj.vo.DemoTodoVO;
import co.up.tune.prj.vo.TodoDetailVO;
import co.up.tune.prj.vo.TodoVO;

@Controller
public class TodoController {
	@Autowired
	TodoService tdao;
	
	@Autowired
	TodoDetailService detail;
	
	@Autowired
	DemoTodoService demo;
	
	@RequestMapping("/todoInsert")
	public String todoInsert(TodoVO vo) {
		int r = tdao.todoInsert(vo);
		if(r != 0) {
			int postNo = vo.getPostNo();
			TodoDetailVO dtvo = new TodoDetailVO();
			dtvo.setPostNo(postNo);
			String[] cntn = vo.getCntn().split(",");

			for(String a : cntn) {
				dtvo.setCntn(a);
				detail.detailInsert(dtvo);
			}
		}
		return "redirect:prjPostList?prjNo=" + vo.getPrjNo();
	}
	
//	@RequestMapping("/detailList")
//	public List<TodoDetailVO> detailList() {
//		
//		return ;
//	}
}
