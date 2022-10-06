package co.up.tune.prj.prjMng.web;


import java.io.Console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.up.tune.prj.prjMng.service.PrjMngService;
import co.up.tune.prj.propost.service.PropostService;
import co.up.tune.prj.vo.ProjectVO;
import co.up.tune.prj.vo.TeamVO;

@Controller
public class PrjMngController {
	@Autowired
	PrjMngService dao;
	@Autowired
	PropostService postDao;

	// 프로젝트 팀 리스트
	@GetMapping("/teamList")
	public String teamList(@RequestParam("prjNo") int prjNo, Model model) {
		ProjectVO vo = new ProjectVO();
		vo.setPrjNo(prjNo);
		model.addAttribute("empList", postDao.empList());
		model.addAttribute("teamList", dao.teamList(prjNo));
		// model.addAttribute("addTeamList", dao.addTeamList());
		model.addAttribute("authList", dao.authList(prjNo));
		model.addAttribute("prjSt", dao.prjSt(vo));
		model.addAttribute("s", dao.pjSelect(vo));
		return "prj/prjMng/teamList";
	}

	// 관리자 리스트
	@GetMapping("/authList")
	public String authList(@RequestParam("prjNo") int prjNo, Model model) {
		model.addAttribute("authList", dao.authList(prjNo));
		// model.addAttribute("addTeamList", dao.addTeamList());
		return "prj/prjMng/teamList";
	}

	// 멤버추가
	@PostMapping("/addTeam")
	public String addTeam(TeamVO vo, RedirectAttributes rttr) {
		dao.addTeam(vo);
		rttr.addAttribute("prjNo", vo.getPrjNo());
		return "redirect:/teamList";

	}

	// 멤버삭제
	@PostMapping("/removeTeam")
	public String removeTeam(TeamVO vo, Model model, RedirectAttributes rttr) {
		dao.removeTeam(vo);
		rttr.addAttribute("prjNo", vo.getPrjNo());
		return "redirect:/teamList";

	}

	// 관리자 추가
	@PostMapping("/teamAuth")
	public String teamAuth(TeamVO vo, RedirectAttributes rttr) {
		System.out.println("teamAuth vo:" + vo);
		dao.teamAuth(vo);
		rttr.addAttribute("prjNo", vo.getPrjNo());
		return "redirect:/teamList";

	}

	// 관리자 삭제
	@PostMapping("/removeAuth")
	public String removeAuth(TeamVO vo, RedirectAttributes rttr) {
		dao.removeAuth(vo);
		rttr.addAttribute("prjNo", vo.getPrjNo());
		return "redirect:/teamList";

	}

	// 프로젝트 상태 변경
	@PostMapping("/prjSt")
	public String prjSt(ProjectVO vo, RedirectAttributes rttr) {
		System.out.println(vo.getPrjNo() + vo.getSt()+"=====================");
		dao.prjSt(vo);
		rttr.addAttribute("prjNo", vo.getPrjNo());
		return "redirect:/teamList";

	}
	
	

}
