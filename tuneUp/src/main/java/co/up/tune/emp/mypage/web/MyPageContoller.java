package co.up.tune.emp.mypage.web;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.up.tune.emp.mypage.service.MypageService;
import co.up.tune.emp.vo.EmpVO;

@Controller
public class MyPageContoller {
	@Autowired
	MypageService dao;

	// 비밀번호 인증
	@RequestMapping("/pwCheck")
	public String pwCheck(EmpVO vo, Model model) {
		EmpVO emp = new EmpVO();
		
		String no= emp.getEmpNo();
		System.out.println(no);
		model.addAttribute("e", dao.empSelectOne(vo));
		return "emp/myPage/pwCheck";
	}
	
	// 내 프로필

	    @RequestMapping("/profile")
	    public String postPrevModify(Authentication auth, @RequestParam("pw") String pw, RedirectAttributes rttr,
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
	        //불일치 시 (수정필요)
	        else {
	        	System.out.println("불일치");
	            rttr.addFlashAttribute("msg", "비밀번호가 일치하지 않습니다.");
	            return "redirect:profile";
	        }
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
		if (proPic != "assets/img/default_profile.png") {
			
		}

		return "";
	}
}
