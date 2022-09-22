package co.up.tune.emp.attd.web;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.up.tune.emp.attd.service.AttdService;
import co.up.tune.emp.vo.AttdVO;
@Controller
public class AttdController {
	@Autowired
	AttdService dao;
	
	@GetMapping("/attdUpForm")
	public String attdUpForm() {
		return "emp/attd/attdUpForm";
	}
	
	@GetMapping("/attdList")
	public String attdList() {
		return "emp/attd/attdList";
	}
	
	@RequestMapping(value="/excel")
	@ResponseBody
	public void excel(@ModelAttribute AttdVO a,HttpServletResponse res, HttpServletRequest req) throws Exception{
		dao.excel(a, res);
	}
	
	
}
