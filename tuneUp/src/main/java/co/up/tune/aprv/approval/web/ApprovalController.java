package co.up.tune.aprv.approval.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import co.up.tune.aprv.approval.service.ApprovalService;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.common.service.CommonService;

@Controller
public class ApprovalController {
	
	@Autowired
	CommonService cd;
	@Autowired
	ApprovalService ap;
	
	
	
	@GetMapping("/approval")
	public String approval(AprvVO vo , Model model, HttpServletRequest request, @RequestParam(required = false, defaultValue = "1")int pageNum, @RequestParam(required = false, defaultValue = "10")int pageSize) {
		
		//세션사번
		HttpSession session = request.getSession();
		String empNo = (String) session.getAttribute("empNo");
		
	
		PageHelper.startPage(pageNum, pageSize);
		model.addAttribute("pageInfo", PageInfo.of(ap.approvalList(empNo, "전체")));
		
		
		// 공통코드
		model.addAttribute("cd", cd.commonList("승인상태"));
		return "aprv/approval/approval";
	}

	
	
	


}
