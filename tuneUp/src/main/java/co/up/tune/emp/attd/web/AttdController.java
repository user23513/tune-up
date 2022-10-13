package co.up.tune.emp.attd.web;



import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	public String myAttdList(Model model, HttpServletRequest request){
		HttpSession session =  request.getSession();
		AttdVO vo = new AttdVO();
		String empNo = (String)session.getAttribute("empNo");
		model.addAttribute("wktmChart", dao.wktmChart(empNo));
		model.addAttribute("ovtmChart", dao.ovtmChart(empNo));
		
		vo.setEmpNo(empNo);
		// 만약 금일 출근 기록이 없거나 출근시간을 찍지 않았다면
		model.addAttribute("checkTime", (dao.checkTime(vo) == null || dao.checkTime(vo).getAtdcDttm() == null) ? null : dao.checkTime(vo).getAtdcDttm());
		// 퇴근시간을 찍지 않았다면
		model.addAttribute("checkBTime", (dao.checkBTime(vo) == null || dao.checkBTime(vo).getAfwkDttm() == null) ? null : dao.checkBTime(vo).getAfwkDttm());

		// 총 근무시간
		String totalWktm = dao.totalWktm(empNo);
		model.addAttribute("totalWktm", totalWktm);
		// 총 초과근무
		String totalOvtm = dao.totalOvtm(empNo);
		model.addAttribute("totalOvtm", totalOvtm);
		
		
		// 총 근무시간 + 총 초과근무시간
		int wkov = Integer.parseInt(totalOvtm) +  Integer.parseInt(totalWktm);
		model.addAttribute("wkov", wkov);
		

	
		return "emp/attd/myAttdList";
		
	}
	 /*
	 @GetMapping("/wkov")
	 public String wkov(AttdVO vo, Model model) {
		 model.addAttribute("wkov", dao.wkov(vo));
		return "emp/attd/myAttdList";
	 }
	 
	 @GetMapping("/totalWktm")
	 public String totalWktm(AttdVO vo, Model model) {
		 model.addAttribute("totalWktm", dao.totalWktm(vo));
		return "emp/attd/myAttdList";
	 }
	 
	 @GetMapping("/totalOvtm")
	 public String totalOvtm(AttdVO vo, Model model) {
		 model.addAttribute("totalOvtm", dao.totalOvtm(vo));
		return "emp/attd/myAttdList";
	 }
	 
 */
	// ===================================
	
	
	
	//엑셀
	@RequestMapping(value="/excel")
	public void excel(@ModelAttribute AttdVO a,HttpServletResponse res, HttpServletRequest req) throws Exception{
		dao.excel(a, res);
	}
}
