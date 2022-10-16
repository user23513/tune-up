package co.up.tune.prj.prjMng.web;




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
	PropostService qdao;
	// 프로젝트 팀 리스트
	@GetMapping("/teamList")
	public String teamList(@RequestParam("prjNo") int prjNo, Model model) {
		ProjectVO vo = new ProjectVO();
		vo.setPrjNo(prjNo);
		model.addAttribute("teamList", dao.teamList(prjNo));
		model.addAttribute("authList", dao.authList(prjNo));
		model.addAttribute("prj", dao.pjSelect(vo));
		model.addAttribute("mEmpList", dao.mEmpListByPrj(Integer.toString(prjNo)));
		ProjectVO prjD = new ProjectVO();
		prjD.setPrjNo(prjNo);
		model.addAttribute("prjDetail", qdao.projectSel(prjD));
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
	
	// (teamList.html 316행과 이어짐)
	@PostMapping("/teamInsert")
	public String teamInsert(TeamVO vo, RedirectAttributes rttr) {
		//vo.setPrjNo(vo.getPrjNo());
		TeamVO addVo = new TeamVO();
		
		// 여러 사원을 추가했을 경우 밸류값에 따옴표가 포함되어있음
		if(vo.getEmpNo().contains(",")) {
			// 따옴표가 들어있는 밸류값을 꺼내어
			// 따옴표를 기준으로 나눔
			// split메서드를 쓰면 지정한 문자열을 기준으로 array를 반환함
			String empNoArr[] = vo.getEmpNo().split(","); 
			String nmArr[] = vo.getNm().split(",");
			String deptArr[] = vo.getDept().split(","); // 개발팀 회계팀 회계팀 운영팀 총 네개의 값이 들어있는 array
			
			// 사원을 추가 count == empNoArr, nmArr, deptArr length
			// 추가한 만큼 들어옴
			// (세 값 모두 같은 length이므로 empNoArr값으로 length체크하였음)
			for(int i=0; i< empNoArr.length; i++) {
				addVo.setEmpNo(empNoArr[i]);
				addVo.setNm(nmArr[i]);
				addVo.setDept(deptArr[i]);
				addVo.setPrjNo(vo.getPrjNo());
				
				dao.teamInsert(addVo); // 사원 추가한 만큼 Insert
			}
		}else {
			dao.teamInsert(vo); // 단일 사원 Insert
		}
		
		rttr.addAttribute("prjNo", vo.getPrjNo());
		
		return "redirect:/teamList";
		
	}
	
	

}
