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

	/*
	 * //출근기록 저장 - 에러메세지 뜨게 수정해야함~~
	 * 
	 * @PostMapping("/startAttd") public String startAttd(AttdVO vo) { return
	 * "main/main";
	 * 
	 * }
	 * 
	 * 
	 * 
	 * //퇴근기록 저장
	 * 
	 * @PostMapping("/endAttd") public Date endAttd(AttdVO vo) { //dao.endAttd(vo);
	 * return vo.getAfwkDttm(); }
	 */
	
	
}
