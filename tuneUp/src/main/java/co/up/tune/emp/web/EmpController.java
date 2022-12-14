package co.up.tune.emp.web;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.up.tune.emp.singUp.email.RegisterMail;
import co.up.tune.emp.singUp.service.SignUpService;
import co.up.tune.emp.vo.EmpVO;

@Controller
public class EmpController {
	
	@Autowired
	private SignUpService ss;

	@Autowired
	private RegisterMail rm;
	
	
	//로그인
	@GetMapping("/login")
	public String loginForm() {
		return "member/loginForm";
	}
	//회원가입 폼
	@GetMapping("/signupform")
	public String signUpForm(EmpVO vo) {
		return "member/signUpForm";
	}
	
	
	//아이디 찾기
	@GetMapping("/findidform")
	public String findIdForm() throws Exception{
		return "member/findId";
	}
	
	//비밀번호 찾기
	@GetMapping("/findpassword")
	public String findPassword() {
		return "member/findPassword";
	}
	
	//에러페이지
	@GetMapping("/error404")
	public String error404() {
		return "error404";
	}
	
	
	//아이디 중복체크
	@ResponseBody
	@PostMapping("/idCheck")
	public int idCheck(String id) throws Exception{
		int result = ss.idCheck(id);
		return result;
	}
	
	//회원가입 성공하면 로그인폼으로 
	@PostMapping(value = "/signup")
	public String signup(EmpVO vo) {
		ss.empInsert(vo);
		return "redirect:/login";
		
	}
	//아아디 찾기(해당하는 계정이 있는지)
	@ResponseBody
	@PostMapping("/findid")
	public String findId(EmpVO vo){
		return ss.findId(vo);
	}
	
	// 이메일 인증
	@PostMapping("/sendCode")
	@ResponseBody
	public String mailConfirm(@RequestParam("email") String email, HttpSession session) throws Exception {
		String code = "";
		try {
			code = rm.sendSimpleMessage(email);
		}catch (Exception e ){
			e.printStackTrace();
		}
	   return code;
	}
	
	//비밀번호 성공하면 
	@PostMapping(value = "/pwUpdate")
	public String empUpdate(EmpVO vo) {
		ss.empUpdate(vo);
		return "redirect:/login";
	}
	

}
	

