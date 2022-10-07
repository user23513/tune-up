package co.up.tune.security; 

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import co.up.tune.emp.mapper.EmpMapper;
import co.up.tune.emp.vo.EmpVO;

public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {
	
	@Autowired
	EmpMapper mapper;
	
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		//세션 삭제
		HttpSession session =  request.getSession();
		EmpVO vo = new EmpVO();
		vo.setEmpNo((String)(session.getAttribute("empNo")));
		vo.setSt("로그아웃");
		mapper.loginStUp(vo);
		
		
		session.invalidate();
		
		
		
		request.setAttribute("logout", "logout");
		//request.getRequestDispatcher("/login").forward(request, response);
		response.sendRedirect("/login?logout");
		
		
		
	}



}
