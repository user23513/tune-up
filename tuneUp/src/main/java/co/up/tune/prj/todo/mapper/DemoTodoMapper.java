package co.up.tune.prj.todo.mapper;

import java.util.List;

import co.up.tune.prj.vo.DemoTodoVO;

public interface DemoTodoMapper {
	List<DemoTodoVO> demoList(); //데모 리스트
	DemoTodoVO demoSelect(DemoTodoVO vo); //데모 한건 조회
	int demoInsert(DemoTodoVO vo); //데모 추가
	int demoDelete(DemoTodoVO vo); //데모 삭제
}
