package co.up.tune.prj.todo.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import co.up.tune.prj.todo.service.DemoTodoService;
import co.up.tune.prj.vo.DemoTodoVO;

@RestController
public class TodoAjaxController {
	@Autowired
	DemoTodoService dao;
	
	@PostMapping("/demoInsert")
	public DemoTodoVO demoInsert(DemoTodoVO vo) {
		dao.demoInsert(vo);
		String cntn = vo.getCntn();
		System.out.println(cntn);
		int no = vo.getNo();
		System.out.println(no);
		return vo;
	}
	
	@PostMapping("/demoDelete")
	public int demoDelete(DemoTodoVO vo) {
		dao.demoDelete(vo);
		int no = vo.getNo();
		return no;
	}
}