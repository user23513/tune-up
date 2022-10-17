package co.up.tune.emp.attd.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.up.tune.emp.attd.service.AttdService;
import co.up.tune.emp.vo.AttdVO;



@RestController
public class AttdAjaxController {
	
	  @Autowired AttdService service;
	
	
	@PostMapping("/startAttd/ajax")
	public String startAttdByAjax(@RequestBody Map<String, Object> map, HttpSession session) {
		AttdVO vo = new AttdVO();
		vo.setNm(map.get("nm").toString());
		vo.setEmpNo(map.get("empNo").toString());
		vo.setDept(map.get("dept").toString());
		vo.setPosition(map.get("position").toString());
		
		try {
			service.startAttd(vo);
			Date from = service.checkTime(vo).getAtdcDttm();
			session.setAttribute("checkTime", service.checkTime(vo).getAtdcDttm());
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			String to = transFormat.format(from);
			return to;
		
		}catch(Exception e) {
			e.printStackTrace();
			return "failed";
		}

	}
	
	
	@PostMapping("/endAttd/ajax")
	public String endAttdByAjax(@RequestBody Map<String, Object> map, HttpSession session) {
		AttdVO vo = new AttdVO();
		vo.setEmpNo(map.get("empNo").toString());
		
		try {
			service.endAttd(vo);
			Date from = service.checkBTime(vo).getAfwkDttm();
			session.setAttribute("checkBTime", service.checkBTime(vo).getAfwkDttm());
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			String to = transFormat.format(from);
			return to;
		
		}catch(Exception e) {
			e.printStackTrace();
			return "failed";
		}

	}

	
}
