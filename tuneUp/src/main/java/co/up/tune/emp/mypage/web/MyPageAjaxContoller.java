package co.up.tune.emp.mypage.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import co.up.tune.emp.mypage.service.MypageService;
import co.up.tune.emp.vo.EmpVO;
import co.up.tune.prj.vo.PostVO;

@RestController
public class MyPageAjaxContoller {
	@Autowired
	MypageService dao;

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

}
