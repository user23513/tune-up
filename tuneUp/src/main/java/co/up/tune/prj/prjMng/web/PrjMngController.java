package co.up.tune.prj.prjMng.web;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.up.tune.prj.prjMng.service.PrjMngService;
import co.up.tune.prj.vo.ProjectVO;
import co.up.tune.prj.vo.TeamVO;

@Controller
public class PrjMngController {
	@Autowired
	PrjMngService dao;

	// 프로젝트 팀 리스트
	@GetMapping("/teamList")
	public String teamList(@RequestParam("prjNo") int prjNo, Model model) {
		ProjectVO vo = new ProjectVO();
		vo.setPrjNo(prjNo);
		model.addAttribute("teamList", dao.teamList(prjNo));
		model.addAttribute("authList", dao.authList(prjNo));
		model.addAttribute("prj", dao.pjSelect(vo));
		model.addAttribute("mEmpList", dao.mEmpListByPrj(Integer.toString(prjNo)));
		return "prj/prjMng/teamList";
	}

	// 관리자 리스트
	@GetMapping("/authList")
	public String authList(@RequestParam("prjNo") int prjNo, Model model) {
		model.addAttribute("authList", dao.authList(prjNo));
		// model.addAttribute("addTeamList", dao.addTeamList());
		return "prj/prjMng/teamList";
	}

	/*// 멤버추가
	@PostMapping("/addTeam")
	public String addTeam(TeamVO vo, RedirectAttributes rttr) {
		dao.teamInsert(vo);
		rttr.addAttribute("prjNo", vo.getPrjNo());
		return "redirect:/teamList";

	}
	*/

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
		dao.prjSt(vo);
		rttr.addAttribute("prjNo", vo.getPrjNo());
		return "redirect:/teamList";

	}
	
	@PostMapping("/teamInsert")
	public String teamInsert(TeamVO vo, RedirectAttributes rttr) {
		//vo.setPrjNo(vo.getPrjNo());
		TeamVO addVo = new TeamVO();
		
		// 여러 사원을 추가할 경우
		if(vo.getEmpNo().contains(",")) {
			String empNoArr[] = vo.getEmpNo().split(",");
			String nmArr[] = vo.getNm().split(",");
			String deptArr[] = vo.getDept().split(",");
			
			// empNoArr갯수 == nmArr갯수 == deptArr갯수
			for(int i=0; i<empNoArr.length; i++) {
				addVo.setEmpNo(empNoArr[i]);
				addVo.setNm(nmArr[i]);
				addVo.setDept(deptArr[i]);
				addVo.setPrjNo(vo.getPrjNo());
				dao.teamInsert(addVo);
			}
		}else {
			dao.teamInsert(vo);
		}
		rttr.addAttribute("prjNo", vo.getPrjNo());
		
		return "redirect:/teamList";
		
	}
	
	

}
