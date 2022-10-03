package co.up.tune.prj.prjMng.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.up.tune.prj.prjMng.service.PrjMngService;
import co.up.tune.prj.vo.ProjectVO;
import co.up.tune.prj.vo.TeamVO;

@Controller
public class PrjMngController {
	@Autowired
	PrjMngService dao;
	
	
	// 프로젝트 팀 리스트
	@PostMapping("/teamList")
	public String teamList(@RequestParam("prjNo")int prjNo,Model model) {
		TeamVO vo = new TeamVO();
		model.addAttribute("teamList", dao.teamList(prjNo));
		model.addAttribute("addTeamList", dao.addTeamList());
		model.addAttribute("authList", dao.authList(prjNo));
		model.addAttribute("removeTeam", dao.removeTeam(vo));
		return "prj/prjMng/teamList";
	}
	
	// 관리자 리스트
	@PostMapping("/authList")
	public String authList(@RequestParam("prjNo")int prjNo,Model model) {
		model.addAttribute("authList", dao.authList(prjNo));
		model.addAttribute("addTeamList", dao.addTeamList());
		return "prj/prjMng/teamList";
	}
	
	
	//멤버추가
	@PostMapping("/addTeam")
	public String addTeam(TeamVO vo) {
		dao.addTeam(vo);
		return "prj/prjMng/teamList";
		
	}
	
	//멤버삭제
		@PostMapping("/removeTeam")
		public String removeTeam(TeamVO vo, Model model) {
			dao.removeTeam(vo);
			model.addAttribute("removeTeam", dao.removeTeam(vo));
			return "prj/prjMng/teamList";
			
		}
		
		//관리자 추가
		@PostMapping("/teamAuth")
		public String teamAuth(TeamVO vo) {
			dao.teamAuth(vo);
			return "prj/prjMng/teamList";
			
		}
		
		//관리자 삭제
		@PostMapping("/removeAuth")
		public String removeAuth(TeamVO vo) {
			dao.removeAuth(vo);
			return "prj/prjMng/teamList";
			
		}
		
		// 프로젝트 상태 변경
		@PostMapping("/prjSt")
		public String prjSt(ProjectVO vo) {
			dao.prjSt(vo);
			return "prj/prjMng/teamList";
			
		}
		
		
}
