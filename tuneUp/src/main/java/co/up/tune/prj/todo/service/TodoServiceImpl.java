package co.up.tune.prj.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.up.tune.prj.todo.mapper.DemoTodoMapper;
import co.up.tune.prj.todo.mapper.TodoMapper;
import co.up.tune.prj.vo.TodoVO;

@Service
public class TodoServiceImpl implements TodoService {
	@Autowired
	TodoMapper map;
	
	@Autowired
	DemoTodoMapper dmap;
	
	@Override
	public List<TodoVO> todoList(int prjNo) {
		return map.todoList(prjNo);
	}

	@Override
	public TodoVO todoSelect() {
		return map.todoSelect();
	}

	@Override
	public int todoInsert(TodoVO vo) {
		return map.todoInsert(vo);
	}

	@Override
	public int todoUpdate(TodoVO vo) {
		return map.todoUpdate(vo);
	}

	@Override
	public int todoDelete(TodoVO vo) {
		return map.todoDelete(vo);
	}

	@Override
	public int todoPercent(TodoVO vo) {
		return map.todoPercent(vo);
	}
}