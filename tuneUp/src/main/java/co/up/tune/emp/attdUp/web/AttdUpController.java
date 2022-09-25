package co.up.tune.emp.attdUp.web;


import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import co.up.tune.emp.attdUp.service.AttdUpService;
import co.up.tune.emp.vo.AttdUpVO;

@Controller
public class AttdUpController {
	@Autowired
	AttdUpService dao;
	
	//근태 수정 신청 - 사원
	@PostMapping("/attdUpInsert")
	public String attdUpInsert(AttdUpVO vo) {
		dao.attdUpInsert(vo);
		return "redirect:/attdToday";
	}
	
	//근태수정 신청폼
	@GetMapping("/attdUpForm")
	public String attdUpForm() {
		return "emp/attdUp/attdUpForm";
	}
	
	//근태 수정 신청 리스트 - 사원
	/*
	 * @GetMapping("/myAttdUpList") public String myAttdUpList(Model model) {
	 * model.addAttribute("myAttdUpList",dao.myAttdUpList()); return
	 * "emp/attdUp/myAttdUpList"; }
	 */
	
	// 근태 수청 요청 리스트 - 관리자
	@GetMapping("/attdUpList")
	public String attdUpList(Model model) {
		model.addAttribute("attdUpList", dao.attdUpList());
		return "emp/attdUp/attdList";
	}
	
	// 수정 상세조회 ( 폼띄워서 보기 )
	// 수정 상세조회 ( 폼띄워서 보기 )
	@PostMapping("/attdUpSelect")
	public String attdUpSelect(AttdUpVO vo,Model model) {
		model.addAttribute("attdUpSelect", dao.attdUpSelect(vo));
		return "emp/attdUp/attdUpSelect";
	}
	// 근태 업데이트 - 관리자
	
	
	
	// 수정리스트 - 대기
	// 수정리스트 - 완료	

}
