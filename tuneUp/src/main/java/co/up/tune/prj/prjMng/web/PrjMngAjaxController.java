package co.up.tune.prj.prjMng.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import co.up.tune.aprv.aprvLine.service.AprvLineService;
import co.up.tune.emp.vo.EmpVO;
import co.up.tune.prj.prjMng.service.PrjMngService;

@RestController
public class PrjMngAjaxController {
	
	@Autowired
	PrjMngService pServ;
	
	@Autowired
	AprvLineService ls;
	
	
	 @PostMapping("/tdeptList") public List<EmpVO> tdeptList(EmpVO vo) { return
	 pServ.tdeptList(vo); }
	 
	// 사원 조회
	/*
	 * @PostMapping("/mngEmpList") public List<EmpVO> mngEmpList(EmpVO vo,Model
	 * model) { model.addAttribute("mngEmpList", ls.aprvDeptList()); return
	 * pServ.mngEmpList(vo);
	 * 
	 * }
	 */
	
//		@GetMapping("/mngEmpList")
//		public String mngEmpList(Model model) {
//			// 부서조회
//			model.addAttribute("mngEmpList", ls.aprvDeptList());
//			return "prj/prjMng/t	eamList";
//		}
		
	 
	}

 
