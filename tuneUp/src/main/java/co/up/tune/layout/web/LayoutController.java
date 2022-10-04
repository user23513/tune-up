package co.up.tune.layout.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.up.tune.layout.service.LayoutService;
import co.up.tune.prj.vo.TeamVO;

@Controller
public class LayoutController {
	
	@Autowired
	LayoutService dao;
	
	@ResponseBody
	@GetMapping("/prjTeamMembers")
	public List<TeamVO> prjTeamMembers(@RequestParam("dept")String dept, HttpSession session){
		String empNo = (String)session.getAttribute("empNo");
		return dao.prjTeamMembers(empNo, dept);
	}

}
