package co.up.tune.prj.todo.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.up.tune.com.vo.ReplyVO;
import co.up.tune.prj.todo.service.DemoTodoService;
import co.up.tune.prj.todo.service.TodoDetailService;
import co.up.tune.prj.todo.service.TodoService;
import co.up.tune.prj.vo.DemoTodoVO;
import co.up.tune.prj.vo.TodoDetailVO;
import co.up.tune.prj.vo.TodoVO;

@Controller
public class TodoController {
	@Autowired
	TodoService tdao;
	
	@Autowired
	TodoDetailService detail;
	
	@Autowired
	DemoTodoService demo;
	
	@RequestMapping("/todoList")
	public String todoList(TodoVO tvo,TodoDetailVO dvo, ReplyVO rvo, Model model) {
		
//		
		model.addAttribute("t", tdao.todoList());
		rvo.setPostNo(tvo.getPostNo());
		dvo.setPostNo(tvo.getPostNo());
		
//		model.addAttribute("d", detail.detailList());
		model.addAttribute("r", tdao.replyList());
		
		return "prj/todo/todoList";
	}
	
	@GetMapping("/todoInsertForm")
	public String todoInsertForm() {
		return "prj/todo/todoInsertForm";
	}
	
	@RequestMapping("/todoInsert")
	public String todoInsert(TodoVO vo, DemoTodoVO devo, HttpSession session) {
//		String empNo = (String) session.getAttribute("empNo");
//		devo.setEmpNo(empNo);
//		
//		vo.setDemoList(demo.demoList());
//		
//		System.out.println(vo.getDemoList());
		
		int r = tdao.todoInsert(vo);
		
		if(r != 0) {
			
			int postNo = vo.getPostNo();
			TodoDetailVO dt = new TodoDetailVO();
			dt.setPostNo(postNo);
			
			String[] cntn = vo.getCntn().split(",");

			for(String a : cntn) {
				dt.setCntn(a);
				detail.detailInsert(dt);
			}
			
		}
			
//			for(int i = 0; i < cntn.length; i++) {
//				dt.setCntn(cntn[i]);
//				System.out.println("cntn================" + cntn[i]);
//				System.out.println("detail cntn ================" + dt.getCntn());
//				//detail.detailInsert(dt);
//			}
		
//		demo.demoList();
//		int postNo = vo.getPostNo();
//		System.out.println("=====================" + postNo);
//		demo.demoList();
//		System.out.println("==================================================="+demo.demoList());
//		vo.setList(demo.demoList());
//		
//		System.out.println(vo.getList());
//		vo.getCntn() =
//		demo.getClass();
//		
//		System.out.println(demo.getClass());
//		String cntn = demo.getCntn();
//		System.out.println(cntn);
//		vo.getCntn();
//		System.out.println("cntn = " + vo.getCntn());
//		TodoDetailVO devo = new TodoDetailVO();
//		devo.setPostNo(postNo);
//		
//		if(vo.getCntn().contains(",")) {
//			String[] cntn = vo.getCntn().split(",");
//			for(String n : cntn) {
//				devo.setCntn(n);
//				detail.detailInsert(devo);
//			}
//		}else {
//			devo.setCntn(vo.getCntn());
//			detail.detailInsert(devo);
//		}
//		demo.demoList();
//		System.out.println("demo : "+demo.demoList());
		return "redirect:todoList";
	}

}
