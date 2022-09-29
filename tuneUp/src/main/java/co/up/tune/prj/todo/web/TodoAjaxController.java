package co.up.tune.prj.todo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import co.up.tune.prj.todo.service.TodoDetailService;
import co.up.tune.prj.todo.service.TodoService;
import co.up.tune.prj.vo.TodoDetailVO;

@RestController
public class TodoAjaxController {
	@Autowired
	TodoService tdao;
	@Autowired
	TodoDetailService ddao;
	
	@PostMapping("/detailInsert")
	public TodoDetailVO detaileInsert(TodoDetailVO vo) {
		
		ddao.detailInsert(vo);
		vo = ddao.detailSelect(vo);
		
		return vo;
	}
}