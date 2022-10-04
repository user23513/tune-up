package co.up.tune.prj.todo.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.up.tune.prj.todo.service.DemoTodoService;
import co.up.tune.prj.todo.service.TodoDetailService;
import co.up.tune.prj.todo.service.TodoService;
import co.up.tune.prj.todo.service.TodoServiceImpl;
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
//		String cntn = vo.getCntn();
//		System.out.println(cntn);
//		int no = vo.getNo();
//		System.out.println(no);
//		String empNo = vo.getEmpNo();
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
		System.out.println("삭제완" + r);
		return r;
	}
	
//	@PostMapping("/cntnList")
//	public 
//	
//	@PostMapping("/todoInsert")
//	public TodoVO todoInsert(TodoVO vo,@RequestParam Map<String, Object> paramMap) throws Exception {
//		tdao.todoInsert(vo);
//		vo.getEmpNo()
//		return vo;
//	}
//	
//	@PostMapping("/detailInsert")
//	public String detailInsert(TodoDetailVO vo, HttpSession session) {
//		String empNo = (String) session.getAttribute("empNo");
//		String cntn = vo.getCntn();
//		System.out.println(cntn);
//		ddao.detailInsert(vo);
//		return cntn;
//	}
	
}