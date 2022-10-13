package co.up.tune.prj.todo.web;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import co.up.tune.prj.todo.service.DemoTodoService;
import co.up.tune.prj.todo.service.TodoDetailService;
import co.up.tune.prj.todo.service.TodoService;
import co.up.tune.prj.vo.DemoTodoVO;
import co.up.tune.prj.vo.TodoDetailVO;
import co.up.tune.prj.vo.TodoVO;

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
		return r;
	}
	
	@PostMapping("/cmpltYnUpdate")
	public String cmpltYnUpdate(TodoDetailVO vo) {
		ddao.cmpltYnUpdate(vo);
		String yn = vo.getCmpltYn();
		return yn; 
	}
	
	@PostMapping("/todoPercent")
	public int todoPercent(TodoVO vo) {
		int perc = tdao.todoPercent(vo);
		return perc;
	}
}