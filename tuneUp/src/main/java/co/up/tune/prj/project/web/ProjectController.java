package co.up.tune.prj.project.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.up.tune.com.vo.ReplyVO;
import co.up.tune.prj.project.service.ProjectService;
import co.up.tune.prj.propost.service.PropostService;
import co.up.tune.prj.vo.ProjectVO;

@Controller
public class ProjectController {

	@Autowired
	PropostService postDao;
	
	@Autowired
	ProjectService prjDao;

	//새 프로젝트 Form으로 이동
	@GetMapping("/newproject")
	public String newProjectForm(Model model) {
		model.addAttribute("empList", postDao.empList());
		return "prj/newProject";
	}
	
	//새 프로젝트 등록
	@PostMapping("/newProjectInsert")
	public String newProjectInsert(ProjectVO vo, HttpSession session, RedirectAttributes re) {
		vo.setLeaderEmpNo((String)session.getAttribute("empNo"));
		vo.getTeamEmpNo().add(vo.getLeaderEmpNo());
		prjDao.newProjectInsert(vo);
		re.addAttribute("prjNo", vo.getPrjNo());
		return "redirect:myProject";
	}
	
	@GetMapping("/file")
	public String attechmentFile() {
		return "file/file";
	}
	
	@RequestMapping("/myReply")
	public String myReply(ReplyVO vo, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String empNo = (String) session.getAttribute("empNo");
		vo.setEmpNo(empNo);
		model.addAttribute("reply", prjDao.myReply(vo));
		return "prj/myReply";
	}

}
