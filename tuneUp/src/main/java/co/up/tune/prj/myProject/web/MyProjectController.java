package co.up.tune.prj.myProject.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import co.up.tune.prj.myProject.service.MyProjectService;
import co.up.tune.prj.vo.ProjectVO;

@Controller
public class MyProjectController {

	@Autowired
	MyProjectService dao;
	
	// 내 프로젝트 목록
	@RequestMapping("/myProject")
	public String myProject(@RequestParam(value="pageNum", required = false, defaultValue = "1") int pageNum,
							Model model, HttpSession session) {
		int empNo = Integer.parseInt((String) session.getAttribute("empNo"));
		PageInfo<ProjectVO> p = new PageInfo<>(dao.myPrjList(empNo, pageNum),10);
		model.addAttribute("myPrjList", p);
		return "prj/myProject";
	
		}
	
}
