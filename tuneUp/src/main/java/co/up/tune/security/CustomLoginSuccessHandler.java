package co.up.tune.security;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import co.up.tune.emp.mypage.service.MypageService;
import co.up.tune.emp.vo.EmpVO;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{

	@Autowired
	MypageService my;
	
	//로그인 하고 세션처리 (우선)
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
			
			String username = authentication.getName();
			EmpVO vo = new EmpVO();
			vo.setId(username);
			my.empSelectOne(vo);
		
			request.getSession().setAttribute("empNo", vo.getEmpNo());
			request.getSession().setAttribute("nm", vo.getNm());
			request.getSession().setAttribute("dept", vo.getDept());
			request.getSession().setAttribute("auth", vo.getAuth());
			request.getSession().setAttribute("mng", vo.getMng());
			
			response.sendRedirect("/main");	
	}
	
}
