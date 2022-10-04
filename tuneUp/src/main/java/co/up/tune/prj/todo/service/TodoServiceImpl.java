package co.up.tune.prj.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.up.tune.com.vo.ReplyVO;
import co.up.tune.prj.todo.mapper.DemoTodoMapper;
import co.up.tune.prj.todo.mapper.TodoMapper;
import co.up.tune.prj.vo.DemoTodoVO;
import co.up.tune.prj.vo.TodoVO;

@Service
public class TodoServiceImpl implements TodoService {
	@Autowired
	TodoMapper map;
	
	@Autowired
	DemoTodoMapper dmap;
	
	@Override
	public List<TodoVO> todoList() {
		return map.todoList();
	}

	@Override
	public TodoVO todoSelect() {
		return map.todoSelect();
	}

	@Override
	public int todoInsert(TodoVO vo) {
//		int r= map.todoInsert(vo);
//		System.out.println("todoInsert r = " + r);
		
		vo.setDemoList(dmap.demoList());
//		System.out.println(cntn);
		
		//1. todo insert
//		int r = map.todoInsert(vo);
//		System.out.println(r);
		
//		//2. demo list 뿌리기
//		TodoDetailVO devo = new TodoDetailVO();
//		System.out.println("postno : " + vo.getPostNo());
//		int postNo = vo.getPostNo();
//		devo.setPostNo(postNo);
//		System.out.println("==============="+devo.getPostNo());
//		
//		DemoTodoVO dmvo = new DemoTodoVO();
//		dmvo.setEmpNo(vo.getEmpNo());
//		System.out.println("empNo============ : " + dmvo.getEmpNo());
//		//========================= 성공 ==========================
//		
////		 int result[] = new int[devo.getDemoList().size()];
////		 System.out.println(result);
//		
////		dmap.demoList().get(0).getCntn();
////		System.out.println(dmap.demoList().get(0).getCntn());
//		
////		devo.getDemoList().get(0).getCntn();
////		System.out.println("demo : " +devo.getDemoList().get(0).getCntn());
//		
//		dmap.demoList();
//		
//		System.out.println("=========demoList ========== " + dmap.demoList() );
//		
//		
//		//3. demo list -> detail 담기
//		devo.setDemoList(dmap.demoList());
//		devo.getDemoList();
//		System.out.println("=========="+devo.getDemoList());
//		
//		//4. detail insert
//		if(devo.getDemoList() != null) {
//			System.out.println("널이 아님");
////			for(int i = 0; i< devo.getDemoList().size(); i++) {
////				//devo.setCntn(devo.getDemo().get(i));
////				//devo.setTodoNo(devo.getDemo().get(i));
////				System.out.println("test" +i);
////			}
//		}else {
//			System.out.println("값이 없음");
//		}
//		//dmap.demoInsert();
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
	public List<ReplyVO> replyList() {
		return map.replyList();
	}

	@Override
	public ReplyVO replySelect(ReplyVO vo) {
		return map.replySelect(vo);
	}

	@Override
	public int replyInsert(ReplyVO vo) {
		return map.replyInsert(vo);
	}

	@Override
	public int replyUpdate(ReplyVO vo) {
		return map.replyUpdate(vo);
	}

	@Override
	public int replyDelete(ReplyVO vo) {
		return map.replyDelete(vo);
	}

}
