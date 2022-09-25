package co.up.tune.emp.mypage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.up.tune.emp.mypage.service.MypageService;
import co.up.tune.emp.vo.EmpVO;

@Controller
public class MyPageContoller {
	@Autowired
	MypageService dao;

	// 비밀번호 인증
	@RequestMapping("/pwCheck")
	public String pwCheck(EmpVO vo, Model model) {
		model.addAttribute("e", dao.empSelectOne(vo));

		return "emp/myPage/pwCheck";
	}

	// 내 프로필
	@RequestMapping("/profile")
	public String profile(EmpVO vo, Model model) {
		EmpVO emp = dao.empSelectOne(vo);
		// 주소
		String addr = emp.getAddr();
		if (addr == null) {
			emp.setAddr("//");
		} else if (!addr.equals("//") && addr != null) {
			String arr[] = addr.split("/");
			String ad1 = arr[0];
			String ad2 = arr[1];
			String ad3 = arr[2];
			emp.setAd1(ad1);
			emp.setAd2(ad2);
			emp.setAd3(ad3);
		}
		model.addAttribute("e", emp);
		return "emp/myPage/profile";
	}

	// 프로필 수정 폼 이동
	@RequestMapping("/profileForm")
	public String profileForm(EmpVO vo, Model model) {
		EmpVO emp = dao.empSelectOne(vo);
		String proPic = emp.getPic();
		System.out.println(proPic);

		if (proPic == null) {
			emp.setPic("assets/img/default_profile.png");
		}

		model.addAttribute("e", dao.empSelectOne(vo));
		return "emp/myPage/profileForm";
	}

	// 프로필 업데이트 + 파일
	@RequestMapping("/profileUpdate")
	public String profileUpdate(EmpVO vo, Model model) {
		EmpVO emp = dao.empSelectOne(vo);
		String proPic = emp.getPic();
		if (proPic == null) {
			emp.setPic("assets/img/default_profile.png");
		}

		return "";
	}
}
