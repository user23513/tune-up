package co.up.tune.myReply.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.up.tune.com.vo.ReplyVO;
import co.up.tune.myReply.service.MyReplyService;

@Controller
public class MyReplyController {
	@Autowired
	MyReplyService dao;
	//내 댓글
	@RequestMapping("/myReply")
	public String myReply(HttpSession session, Model model) {
		ReplyVO vo = new ReplyVO();
		String empNo = (String)session.getAttribute("empNo");
		vo.setEmpNo(empNo);
		model.addAttribute("myReplyList", dao.myReplyList(vo));
		return "myReply/myReplyList";
	}
}
