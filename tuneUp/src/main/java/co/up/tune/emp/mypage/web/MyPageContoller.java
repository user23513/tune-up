package co.up.tune.emp.mypage.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		
		String no= emp.getEmpNo();
		System.out.println(no);
		model.addAttribute("e", dao.empSelectOne(vo));
		return "emp/myPage/pwCheck";
	}
	
	// 내 프로필 클릭 시
    @RequestMapping("/profile")
    public String profile(Authentication auth, @RequestParam("pw") String pw, RedirectAttributes rttr,
    		EmpVO vo, Model model) {
    	EmpVO emp = dao.empSelectOne(vo);
    	String DBpw = emp.getPw(); //DB의 비밀번호
    	
    	//비밀번호 암호화
    	PasswordEncoder ps =new BCryptPasswordEncoder();
    	
    	//비밀번호 일치 시
        if(ps.matches(pw, DBpw)) {
            System.out.println("일치");
            
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
        //불일치 시
        else {
            return "emp/myPage/alert";

        }
    }
    
	// 비밀번호 인증 실패
	@RequestMapping("/alert")
	public String alert(EmpVO vo, Model model) {
		return "emp/myPage/pwCheck";
	}
	    
	// 프로필 수정 폼 이동
	@RequestMapping("/profileForm")
	public String profileForm(EmpVO vo, Model model) {
		model.addAttribute("e", dao.empSelectOne(vo));
		return "emp/myPage/profileForm";
	}

	// 프로필 업데이트+사진
	@RequestMapping("/profileUpdate")
	public String profileUpdate(EmpVO vo, Model model, @RequestParam("pic") MultipartFile pics) {
		System.out.println("test");
		EmpVO emp = new EmpVO();
		String test = emp.getPic();
		if(test == null) {
			System.out.println("null 이다.");
		}else if(test.equals("assets/img/default_profile.png")) {
			System.out.println("기본 프로필");
		}else {
			System.out.println(emp.getPic());
		}
		String pic = vo.getPic();
		if(pic == null) {
			System.out.println("null 이다.");
		}else if(pic.equals("assets/img/default_profile.png")) {
			System.out.println("기본 프로필");
		}else {
			System.out.println(vo.getPic());
		}
		
		MultipartFile test2 = pics;
		if(pics == null) {
			System.out.println("null 이다.");
		}else {
			System.out.println(pics);
		}
		
		//profile 사진
//		List<FilesVO> list = new ArrayList<>();
//		String folder = "profile";
//		System.out.println(vo.getPic());
//		if(pics.length != 0) {
//			list = fdao.fileUpload(pics, folder);
//			vo.setPic(list.get(0).getFPath());
//		}
		
		//서명 파일
//		List<FilesVO> list1 = new ArrayList<>();
//		String folder1 = "sign";
//		System.out.println(vo.getSign());
//		if(pics.length != 0) {
//			list1 = fdao.fileUpload(signs, folder1);
//			vo.setSign(list.get(0).getFPath());
//		}
		
		
//		EmpVO emp = dao.empSelectOne(vo);
//		int cnt = 0;
//		if (dao.profileUpdate(vo) != 0) {
//			model.addAttribute("e", dao.empSelectOne(vo));
//			return "emp/myPage/profileForm";
//		}else {
//			return "redirect:profileForm";
//		}
		
		return "";
	}
}
