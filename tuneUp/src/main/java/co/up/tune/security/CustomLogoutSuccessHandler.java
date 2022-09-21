package co.up.tune.security; 

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		//세션 삭제
		HttpSession session =  request.getSession();
		session.invalidate();
		
		request.setAttribute("logout", "logout");
		//request.getRequestDispatcher("/login").forward(request, response);
		response.sendRedirect("/login?logout=i");
		
		
		
	}



}
