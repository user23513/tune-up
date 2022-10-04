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
import org.springframework.web.bind.annotation.ResponseBody;


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
		AttdVO dvo = new AttdVO();
		model.addAttribute("attdList",dao.attdList());
		model.addAttribute("attdGoodList",dao.attdGoodList());
		model.addAttribute("attdBadList",dao.attdBadList());
		model.addAttribute("attdUpList", udao.attdUpList());
		model.addAttribute("attdUpSelect", udao.attdUpSelect(vo));
		model.addAttribute("checkGood", dao.checkGood(dvo));
		model.addAttribute("checkBad", dao.checkBad(dvo));
		model.addAttribute("checkModi", udao.checkModi(vo));
		return "emp/attd/attdList";
	}
	
	
	//출근기록 저장 - 에러메세지 뜨게 수정해야함~~
		@PostMapping("/startAttd")
		public String startAttd(AttdVO vo) {
			dao.startAttd(vo);
			return "redirect:main";
			
		}
		 
		//퇴근기록 저장
		@PostMapping("/endAttd")
		public String endAttd(AttdVO vo) {
			dao.endAttd(vo);
			return "redirect:main";
		}
	
	
	
	@PostMapping("/checkGood")
	public String checkGood(AttdVO vo, Model model) throws Exception {
		int count = dao.checkGood(vo);
		model.addAttribute("checkGood", count);
		return "emp/attd/attdList";
	}
	
	@PostMapping("/checkBad")
	public String checkBad(AttdVO vo, Model model) throws Exception {
		int count = dao.checkBad(vo);
		model.addAttribute("checkBad", count);
		return "emp/attd/attdList";
	}
	
	 @GetMapping("/checkTime")
	 public String checkTime(AttdVO vo, Model model) {
		 model.addAttribute("checkTime", dao.checkTime(vo));
		return "emp/attd/myAttdList";
	 }
	 
	 
	// 전체사원 근태 정상 리스트 - 관리자
//	@GetMapping("/attdGoodList")
//	public String attdGoodList(Model model) {
//		model.addAttribute("attdGoodList",dao.attdGoodList());
//		System.out.println(model);
//		return "emp/attd/attdList";
//	}
	
//	// 전체사원 근태 이상 리스트 - 관리자
//		@GetMapping("/attdBadList")
//		public String attdBadList(Model model) {
//			model.addAttribute("attdBadList",dao.attdBadList());
//			return "emp/attd/attdList";
//		}
		
	
	// ===================================
		
	@RequestMapping("/myAttdList")
	public String myAttdList(Model model){
		AttdVO vo = new AttdVO();
		model.addAttribute("checkTime", dao.checkTime(vo).getAtdcDttm());
		return "emp/attd/myAttdList";
		
	}
	
	
	//차트
	/*
	 * @RequestMapping("/wktmChart") public List<AttdVO> wktmChart(Model model,
	 * AttdVO vo) throws Exception{ List<AttdVO> wktmChart = dao.wktmChart(vo);
	 * model.addAttribute("wktmChart", wktmChart); return wktmChart;
	 * 
	 * }
	 */
	
	
	/* public String workChart() {
		List<AttdVO> logList = 

		Gson gson = new Gson();
		JsonArray jArray = new JsonArray();
				
		Iterator<LogVO> it = logNameList.iterator();
		while(it.hasNext()) {
			LogVO curVO = it.next();
			JsonObject object = new JsonObject();
			String userid = curVO.getLog_userid();
			int cnt = curVO.getCnt();
			
		    object.addProperty("ID", userid);
			object.addProperty("Count", cnt);
			jArray.add(object);
		}
				
		String json = gson.toJson(jArray);
		model.addAttribute("json", json);
		
		return null;
		
	} */
	
	// ===================================
	
	
	
	//엑셀
	@RequestMapping(value="/excel")
	@ResponseBody
	public void excel(@ModelAttribute AttdVO a,HttpServletResponse res, HttpServletRequest req) throws Exception{
		dao.excel(a, res);
	}
}
