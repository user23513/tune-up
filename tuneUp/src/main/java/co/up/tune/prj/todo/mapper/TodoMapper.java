package co.up.tune.prj.todo.mapper;

import java.util.List;

import co.up.tune.com.vo.ReplyVO;
import co.up.tune.prj.vo.TodoVO;

public interface TodoMapper {
	
	//할일
	List<TodoVO> todoList(); //할일 목록
	TodoVO todoSelect(); //할일 상세보기
	int todoInsert(TodoVO vo); //할일 추가
	int todoUpdate(TodoVO vo); // 할일 수정
	int todoDelete(TodoVO vo); //할일 삭제
	
	//댓글
	List<ReplyVO> replyList(); //댓글 리스트
	ReplyVO replySelect(ReplyVO vo); //댓글 조회
	int replyInsert(ReplyVO vo); //댓글 등록
	int replyUpdate(ReplyVO vo); //댓글 수정
	int replyDelete(ReplyVO vo); //댓글 삭제
}
