package co.up.tune.emp.singUp.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AccountController {
	@Autowired
	private RegisterMail rm;
	
	// 이메일 인증
	@PostMapping("/sendCode")
	@ResponseBody
	public String mailConfirm(@RequestParam("email") String email) throws Exception {
		String code = "";
		try {
			code = rm.sendSimpleMessage(email);
		}catch (Exception e ){
			e.printStackTrace();
		}
	   System.out.println("인증코드 : " + code);
	   return code;
	}
}
