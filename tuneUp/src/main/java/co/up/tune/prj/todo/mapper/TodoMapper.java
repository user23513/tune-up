package co.up.tune.prj.todo.mapper;

import java.util.List;
import co.up.tune.prj.vo.TodoVO;

public interface TodoMapper {
	
	//할일
	List<TodoVO> todoList(int prjNo); //할일 목록
	TodoVO todoSelect(); //할일 상세보기
	int todoInsert(TodoVO vo); //할일 추가
	int todoUpdate(TodoVO vo); // 할일 수정
	int todoDelete(TodoVO vo); //할일 삭제
	int todoPercent(TodoVO vo); //완료 퍼센트 조회
}
