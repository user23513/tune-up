package co.up.tune.aprv.aprvReq.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import co.up.tune.aprv.aprvReq.service.AprvReqService;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.FormVO;
import co.up.tune.common.service.CommonService;

@RestController
public class AprvReqAjaxController {

	@Autowired
	CommonService cd;
	@Autowired
	AprvReqService ap;

	@RequestMapping("/aprvView")	
	public AprvVO aprvView(AprvVO vo) {
		
		vo= ap.aprvReqSelect(vo);
		
		return vo;
			
		}
		
		
	

}
