package co.up.tune.layout.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.up.tune.emp.attd.service.AttdService;
import co.up.tune.emp.vo.AttdVO;
import co.up.tune.layout.service.LayoutService;
import co.up.tune.prj.vo.TeamVO;

@Controller
public class LayoutController {
	
	@Autowired
	LayoutService dao;
	
	@Autowired
	AttdService adao;
	
	@ResponseBody
	@GetMapping("/prjTeamMembers")
	public List<TeamVO> prjTeamMembers(@RequestParam("dept")String dept, HttpSession session,Model model){
		AttdVO vo = new AttdVO();
		String empNo = (String)session.getAttribute("empNo");
		// 당일 출퇴근 기록이 없다면(출근기록)
		vo.setEmpNo(empNo);
		session.setAttribute("checkTime", (adao.checkTime(vo) == null || adao.checkTime(vo).getAtdcDttm() == null) ? null : adao.checkTime(vo).getAtdcDttm());
		session.setAttribute("checkBTime", (adao.checkBTime(vo) == null || adao.checkBTime(vo).getAfwkDttm() == null) ? null : adao.checkBTime(vo).getAfwkDttm());
				
		return dao.prjTeamMembers(empNo, dept);
	}

}
