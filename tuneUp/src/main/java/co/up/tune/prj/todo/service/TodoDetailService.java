package co.up.tune.prj.todo.service;

import java.util.List;

import co.up.tune.prj.vo.TodoDetailVO;

public interface TodoDetailService {
	
	List<TodoDetailVO> detailList(); //할일 상세 리스트
	TodoDetailVO detailSelect(TodoDetailVO vo); //할일 상세 조회
	int detailInsert(TodoDetailVO vo); //할일 상세 추가
	int detailUpdate(TodoDetailVO vo); //할일 상세 수정
	int detailDelete(TodoDetailVO vo); //할일 상세 삭제
	int cmpltYnUpdate(TodoDetailVO vo); //할일 체크
}