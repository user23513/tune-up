package co.up.tune.emp.mypage.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.up.tune.com.vo.ReplyVO;
import co.up.tune.emp.mypage.service.MypageService;
import co.up.tune.emp.vo.EmpVO;
import co.up.tune.file.service.FileService;
import co.up.tune.prj.vo.FilesVO;

@Controller
public class MyPageContoller {
	@Autowired
	MypageService dao;

	@Autowired
	FileService fdao;

	// 비밀번호 인증
	@RequestMapping("/pwCheck")
	public String pwCheck(EmpVO vo, Model model) {
		EmpVO emp = new EmpVO();

		String no = emp.getEmpNo();
		System.out.println(no);
		model.addAttribute("e", dao.empSelectOne(vo));
		return "emp/myPage/pwCheck";
	}

	// 비밀번호 확인
	@RequestMapping("/pwConfirm")
	public String checkPw(Authentication auth, @RequestParam("pw") String pw, RedirectAttributes rttr, EmpVO vo,
			Model model) {
		EmpVO emp = dao.empSelectOne(vo);
		String DBpw = emp.getPw(); // DB의 비밀번호

		// 비밀번호 암호화
		PasswordEncoder ps = new BCryptPasswordEncoder();

		// 비밀번호 일치 시
		if (ps.matches(pw, DBpw)) {
			System.out.println("일치");
			return "emp/myPage/profile";
		}
		// 불일치 시
		else {
			return "emp/myPage/alert";
		}
	}

	// 비밀번호 인증 실패
	@RequestMapping("/alert")
	public String alert(EmpVO vo, Model model) {
		return "emp/myPage/pwConfirm";
	}

	// 비밀번호 인증 성공, 내 프로필
	@RequestMapping("/profile")
	public String profile(EmpVO vo, Model model) {
		EmpVO emp = dao.empSelectOne(vo);
		// 주소
		System.out.println("test");
		String addr = emp.getAddr();
		System.out.println("주소 : " + addr);
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
		model.addAttribute("e", dao.empSelectOne(vo));
		return "emp/myPage/profileForm";
	}

	// 프로필 업데이트+사진
	@RequestMapping("/profileUpdate")
	public String profileUpdate(EmpVO vo, Model model, @RequestParam("file") MultipartFile[] files)
			throws IllegalStateException, IOException {
		EmpVO emp = dao.empSelectOne(vo);
		// profile 사진 upload
		List<FilesVO> list = new ArrayList<>();
		System.out.println("vo.getPic : " + vo.getPic());
		System.out.println("emp : " + emp.getPic());
		System.out.println("files : " + files);
		if (files.length != 0) {
			String folder = "profile";
			list = fdao.fileUpload(files, folder);
			vo.setPic(list.get(0).getFPath());
		}

		if (dao.profileUpdate(vo) != 0) {
			model.addAttribute("e", dao.empSelectOne(vo));
			return "emp/myPage/profile";
		} else {
			return "redirect:profileForm";
		}
	}

	// 프로필 수정 폼 이동
	@RequestMapping("/myReply")
	public String myReply(ReplyVO vo, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String empNo = (String) session.getAttribute("empNo");
		vo.setEmpNo(empNo);
		model.addAttribute("reply", dao.myReply(vo));
		return "emp/myPage/myReply";
	}
}
