package co.up.tune.emp.attd.web;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import co.up.tune.emp.attd.service.AttdService;
import co.up.tune.emp.attdUp.service.AttdUpService;
import co.up.tune.emp.hr.service.HrService;
import co.up.tune.emp.vo.AttdUpVO;
import co.up.tune.emp.vo.AttdVO;
@Controller
public class AttdController {
	@Autowired
	AttdService dao;
	
	@Autowired
	AttdUpService udao;
	
	@Autowired
	HrService sdao;
	
	// 전체사원 근태 리스트 - 관리자
	@GetMapping("/attdList")
	public String attdList(Model model) {
		AttdUpVO vo = new AttdUpVO();
		model.addAttribute("attdList",dao.attdList());
		model.addAttribute("attdGoodList",dao.attdGoodList());
		model.addAttribute("attdBadList",dao.attdBadList());
		model.addAttribute("attdUpList", udao.attdUpList());
		model.addAttribute("attdUpSelect", udao.attdUpSelect(vo));	//검색조건 추가하기
		
		model.addAttribute("checkGood", dao.checkGood(null));
		model.addAttribute("checkBad", dao.checkBad(null));
		model.addAttribute("checkModi", udao.checkModi(null));
		return "emp/attd/attdList";
	}

	// 출근기록 저장
	@PostMapping("/startAttd")
	public String startAttd(AttdVO vo) {
		dao.startAttd(vo);
		return "redirect:main";

	}

	// 퇴근기록 저장
	@PostMapping("/endAttd")
	public String endAttd(AttdVO vo) {
		dao.endAttd(vo);
		return "redirect:main";
	}

	// 전체 사원 정상출근 리스트
	@PostMapping("/checkGood")		
	public String checkGood(AttdVO vo, Model model) throws Exception {
		int count = dao.checkGood(vo);
		model.addAttribute("checkGood", count);
		return "emp/attd/attdList";
	}
	
	//전체 사원 비정상 출근 리스트
	@PostMapping("/checkBad")
	public String checkBad(AttdVO vo, Model model) throws Exception {
		int count = dao.checkBad(vo);
		model.addAttribute("checkBad", count);
		return "emp/attd/attdList";
	}
	
	//출근 시간 체크
	 @GetMapping("/checkTime")
	 public String checkTime(AttdVO vo, Model model) {
		 model.addAttribute("checkTime", dao.checkTime(vo));
		return "emp/attd/myAttdList";
	 }
	 
	 // 퇴근 시간 체크
	 @GetMapping("/checkBTime")
	 public String checkBTime(AttdVO vo, Model model) {
		 model.addAttribute("checkBTime", dao.checkBTime(vo));
		return "emp/attd/myAttdList";
	 }
	 
	 // 나의 근태 보기
	@RequestMapping("/myAttdList")
	public String myAttdList(Model model){
		AttdVO vo = new AttdVO();
		model.addAttribute("checkTime", dao.checkTime(vo).getAtdcDttm());
		model.addAttribute("checkBTime", dao.checkBTime(vo).getAfwkDttm());
		return "emp/attd/myAttdList";
		
	}
	 
 
	// ===================================
	
	
	
	//엑셀
	@RequestMapping(value="/excel")
	public void excel(@ModelAttribute AttdVO a,HttpServletResponse res, HttpServletRequest req) throws Exception{
		dao.excel(a, res);
	}
}
