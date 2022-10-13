package co.up.tune.prj.todo.web;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import co.up.tune.prj.todo.service.TodoDetailService;
import co.up.tune.prj.todo.service.TodoService;
import co.up.tune.prj.vo.TodoDetailVO;
import co.up.tune.prj.vo.TodoVO;

@Controller
public class TodoController {
	@Autowired
	TodoService tServ;
	
	@Autowired
	TodoDetailService detail;
	
	@RequestMapping("/todoInsert")
	public String todoInsert(TodoVO vo) {
		int r = tServ.todoInsert(vo);
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
}