package co.up.tune.prj.myProject.web;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import co.up.tune.prj.myProject.service.MyProjectService;
import co.up.tune.prj.vo.ProjectVO;
import co.up.tune.prj.vo.TeamVO;

@Controller
public class MyProjectController {

	@Autowired
	MyProjectService dao;
	
	// 내 프로젝트 목록
	@RequestMapping("/myProject")
	public String myProject(@RequestParam(value="pageNum", required = false, defaultValue = "1") int pageNum,
							Model model, HttpSession session) {
		TeamVO vo = new TeamVO();
		int empNo = Integer.parseInt((String) session.getAttribute("empNo"));
		int count = dao.checkTeam(vo);
		PageInfo<ProjectVO> p = new PageInfo<>(dao.myPrjList(empNo, pageNum),10);
		model.addAttribute("myPrjList", p);
		model.addAttribute("checkTeam", count);
		return "prj/myProject";
	
		}
	
	//프로젝트 멤버 수 카운트
	@GetMapping("/checkTeam")
	public String checkTeam(TeamVO vo, Model model) throws Exception{
		int count = dao.checkTeam(vo);
		model.addAttribute("checkTeam", count);
		return "prj/myProject";
	}
}
