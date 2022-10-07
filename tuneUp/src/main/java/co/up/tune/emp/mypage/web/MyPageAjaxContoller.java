package co.up.tune.emp.mypage.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import co.up.tune.emp.mapper.EmpMapper;
import co.up.tune.emp.mypage.service.MypageService;
import co.up.tune.emp.vo.EmpVO;
import co.up.tune.prj.vo.PostVO;

@RestController
public class MyPageAjaxContoller {
	@Autowired
	MypageService dao;
	@Autowired
	EmpMapper map;

	@PostMapping("/picUpdate")
	public String picUpdate(EmpVO vo) {
		dao.picUpdate(vo);

		String pic = vo.getPic();
		System.out.println(pic);

		return pic;
	}

	@PostMapping("/postView")
	public PostVO postView(PostVO vo) {

		return dao.postLook(vo);
	}
	

	@PostMapping("/empStChange")
	public int empStChange(EmpVO vo, HttpSession session) {
		
		vo.setEmpNo((String)(session.getAttribute("empNo")));
		session.setAttribute("st", vo.getSt());
		return map.loginStUp(vo);
	}

}
