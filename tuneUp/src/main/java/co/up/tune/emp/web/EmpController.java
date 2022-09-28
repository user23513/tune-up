package co.up.tune.emp.web;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;

import co.up.tune.TuneUpApplication;
import co.up.tune.emp.singUp.service.SignUpService;
import co.up.tune.emp.singUp.service.SignUpServiceImpl;
import co.up.tune.emp.vo.EmpVO;

@SpringBootApplication
@MapperScan(basePackages = "co.up.tune.**.mapper")
@Controller
public class EmpController {
	private static final String SignUpServiceImpl = null;
	public static void main(String[] args) {
		SpringApplication.run(TuneUpApplication.class, args);
	}
	
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
	//회원가입하면 로그인폼으로 
	@PostMapping("/signupform")
	public String signUp() {
		return "member/loginForm";
	}
	//아이디 찾기
	@GetMapping("/findid")
	public String findId() throws Exception{
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
	
	@Autowired
	private SignUpService ss;
	//join page
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public void registerGET() throws Exception{
	}
	//아이디 중복체크
	@ResponseBody
	@PostMapping("/idCheck")
	public int idCheck(String id) throws Exception{
		int result = ss.idCheck(id);
		return result;
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String registerPOST(EmpVO vo,String id) throws Exception{
		int idResult = ss.idCheck(id);
		try {
			if(idResult == 1) {
				return "/signup";
			}else if(idResult == 0) {
				ss.empInsert(vo);
				return "redirect:/login";
			}
		}catch(Exception e) {
			throw new RuntimeException();
		}
		return "redirect:/";
	}
}
	

