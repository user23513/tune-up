package co.up.tune.prj.todo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import co.up.tune.prj.todo.service.DemoTodoService;
import co.up.tune.prj.todo.service.TodoDetailService;
import co.up.tune.prj.todo.service.TodoService;
import co.up.tune.prj.vo.DemoTodoVO;

@RestController
public class TodoAjaxController {
	@Autowired
	DemoTodoService dao;
	
	@Autowired
	TodoDetailService ddao;
	
	@Autowired
	TodoService tdao;
	
	@PostMapping("/demoInsert")
	public DemoTodoVO demoInsert(DemoTodoVO vo) {
		dao.demoInsert(vo);
		return vo;
	}
	
	@PostMapping("/demoDelete")
	public int demoDelete(DemoTodoVO vo) {
		dao.demoDelete(vo);
		int no = vo.getNo();
		return no;
	}
	
	@PostMapping("/demoDeleteAll")
	public int demoDeleteAll(DemoTodoVO vo) {
		int r = dao.demoDeleteAll(vo);
		System.out.println("삭제완" + r);
		return r;
	}
}