package co.up.tune.prj.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.up.tune.prj.todo.mapper.DemoTodoMapper;
import co.up.tune.prj.vo.DemoTodoVO;

@Service
public class DemoTodoServiceImpl implements DemoTodoService{
	@Autowired
	DemoTodoMapper map;
	
	@Override
	public List<DemoTodoVO> demoList() {
		return map.demoList();
	}

	@Override
	public DemoTodoVO demoSelect(DemoTodoVO vo) {
		return map.demoSelect(vo);
	}

	@Override
	public int demoInsert(DemoTodoVO vo) {
		return map.demoInsert(vo);
	}

	@Override
	public int demoDelete(DemoTodoVO vo) {
		return map.demoDelete(vo);
	}

	public int demoDeleteAll(DemoTodoVO vo) {
		return map.demoDeleteAll(vo);
	}
}