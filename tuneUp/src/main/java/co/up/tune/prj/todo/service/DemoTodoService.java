package co.up.tune.prj.todo.service;

import java.util.List;

import co.up.tune.prj.vo.DemoTodoVO;

public interface DemoTodoService {
	List<DemoTodoVO> demoList(); //데모 리스트
	DemoTodoVO demoSelect(DemoTodoVO vo); //데모 한건 조회
	int demoInsert(DemoTodoVO vo); //데모 추가
	int demoDelete(DemoTodoVO vo); //데모 삭제
	int demoDeleteAll(DemoTodoVO vo); //전체 삭제
}
