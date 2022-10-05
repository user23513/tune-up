package co.up.tune.emp.attd.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.up.tune.emp.attd.service.AttdService;
import co.up.tune.emp.vo.AttdVO;



@RestController
public class AttdAjaxController {
	
	
	  @Autowired AttdService dao;
	 
	  @RequestMapping("/wktmChart")
		public List<AttdVO> wktmChart(Model model, AttdVO vo) throws Exception{
			List<AttdVO> wktmChart = dao.wktmChart(vo);
			model.addAttribute("wktmChart", wktmChart);
			return wktmChart;
			
		}

	
}
