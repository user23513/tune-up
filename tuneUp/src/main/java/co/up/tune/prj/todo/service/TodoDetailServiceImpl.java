package co.up.tune.prj.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.up.tune.prj.vo.TodoDetailVO;

@Service
public class TodoDetailServiceImpl implements TodoDetailService{
	@Autowired
	TodoDetailService map;
	
	@Override
	public List<TodoDetailVO> detailList() {
		return map.detailList();
	}

	@Override
	public int detailInsert(TodoDetailVO vo) {
		return map.detailInsert(vo);
	}

	@Override
	public int detailUpdate(TodoDetailVO vo) {
		return map.detailUpdate(vo);
	}

	@Override
	public int detailDelete(TodoDetailVO vo) {
		return map.detailDelete(vo);
	}

	@Override
	public int cmpltYnUpdate(TodoDetailVO vo) {
		return map.cmpltYnUpdate(vo);
	}

	@Override
	public TodoDetailVO detailSelect(TodoDetailVO vo) {
		return map.detailSelect(vo);
	}
}
