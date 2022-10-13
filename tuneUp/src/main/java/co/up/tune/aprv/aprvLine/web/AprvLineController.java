package co.up.tune.aprv.aprvLine.web;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import co.up.tune.aprv.aprvLine.service.AprvLineService;
import co.up.tune.aprv.vo.AprvLineVO;

/**
 * 전자결재 결재라인 Controller
 * 
 * @author 윤정은
 * @date 2022.09.29
 * @version 1.0
 **/


@Controller
public class AprvLineController {

	@Autowired
	AprvLineService ls;

	// 결재선 추가
	@PostMapping("/aprvLineIn")
	public String aprvLineIn(AprvLineVO vo, HttpSession session) {
		String empNo = (String) session.getAttribute("empNo");
		String dept = (String) session.getAttribute("dept");
		vo.setDept(dept);
		vo.setEmpNo(empNo);
		ls.aprvLineIn(vo);

		return "redirect:aprvReq";
	}

}
