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
	public String demoInsert(DemoTodoVO vo) {
		dao.demoInsert(vo);
		String cntn = vo.getCntn();
		System.out.println(cntn);
		return cntn;
	}
}