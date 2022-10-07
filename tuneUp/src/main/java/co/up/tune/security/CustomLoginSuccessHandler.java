package co.up.tune.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.github.pagehelper.PageInfo;

import co.up.tune.com.notice.service.NoticeService;
import co.up.tune.com.vo.CommunityVO;
import co.up.tune.com.vo.SearchVO;
import co.up.tune.emp.attd.service.AttdService;
import co.up.tune.emp.mapper.EmpMapper;
import co.up.tune.emp.vo.AttdVO;
import co.up.tune.emp.vo.EmpVO;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{

	@Autowired
	EmpMapper mapper;
	@Autowired
	NoticeService dao;
	
	@Autowired
	AttdService adao;
	
	//로그인 하고 세션처리 (우선)
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
			
			String username = authentication.getName();
			EmpVO vo = new EmpVO();
			vo.setId(username);
			vo = mapper.empSession(vo);
			
			HttpSession session =  request.getSession();
			session.setMaxInactiveInterval(7200000);
			session.setAttribute("empNo", vo.getEmpNo());
			session.setAttribute("nm", vo.getNm());
			session.setAttribute("dept", vo.getDept());
			session.setAttribute("auth", vo.getAuth());
			session.setAttribute("mng", vo.getMng());
			session.setAttribute("position", vo.getPosition());
			session.setAttribute("pic", vo.getPic());
			session.setAttribute("st", "온라인");
			
			PageInfo<CommunityVO> p = new PageInfo<>(dao.noticeList(1, new SearchVO()), 5);
			AttdVO at = new AttdVO();
			
			at.setEmpNo((String)session.getAttribute("empNo"));
			
			session.setAttribute("nList", p);
			
			// 당일 출퇴근 기록이 없다면(출근기록)
			session.setAttribute("checkTime", (adao.checkTime(at) == null || adao.checkTime(at).getAtdcDttm() == null) ? null : adao.checkTime(at).getAtdcDttm());
			session.setAttribute("checkBTime", (adao.checkBTime(at) == null || adao.checkBTime(at).getAfwkDttm() == null) ? null : adao.checkBTime(at).getAfwkDttm());
			
			
			response.addHeader("Access-Control-Allow-Origin", "*");
			
			response.sendRedirect("/main");	
	}
	
}
