package co.up.tune.emp.attd.web;



import java.util.List;

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

import com.google.gson.Gson;

import co.up.tune.emp.attd.service.AttdService;
import co.up.tune.emp.attdUp.service.AttdUpService;
import co.up.tune.emp.vo.AttdUpVO;
import co.up.tune.emp.vo.AttdVO;
@Controller
public class AttdController {
	@Autowired
	AttdService dao;
	
	@Autowired
	AttdUpService udao;
	
	// 전체사원 근태 리스트 - 관리자
	@GetMapping("/attdList")
	public String attdList(Model model) {
		AttdUpVO vo = new AttdUpVO();
		model.addAttribute("attdList",dao.attdList());
		model.addAttribute("attdGoodList",dao.attdGoodList());
		model.addAttribute("attdBadList",dao.attdBadList());
		model.addAttribute("attdUpList", udao.attdUpList());
		model.addAttribute("attdUpSelect", udao.attdUpSelect(vo));
		model.addAttribute("attdUpDel", udao.attdUpDel(vo));
		return "emp/attd/attdList";
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
		
	@GetMapping("/attdToday")
	public String myAttdList(){
		//vo.setWktm(vo.getAtdcDttm()-vo.getAfwkDttm());
		return "emp/attd/myAttdList";
		
	}
	
	@GetMapping("/afwkToday")
	public String afwkToday() {
		return "emp/attd/myAttdList";
	}
	
	
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
