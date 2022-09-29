package co.up.tune.prj.todo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import co.up.tune.prj.todo.service.TodoDetailService;
import co.up.tune.prj.todo.service.TodoService;
import co.up.tune.prj.vo.DemoTodoVO;
import co.up.tune.prj.vo.TodoDetailVO;

@RestController
public class TodoAjaxController {
	@Autowired
	TodoService tdao;
	@Autowired
	TodoDetailService ddao;
	
	@PostMapping("/demoInsert")
	public DemoTodoVO demoInsert(DemoTodoVO vo) {
		ddao.demoInsert(vo);
		List<DemoTodoVO> list = ddao.demoList();
		return vo;
	}
}