package co.up.tune.prj.propost.web;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import co.up.tune.com.vo.ReplyVO;
import co.up.tune.prj.propost.service.PropostService;


@RestController
public class PropostAjaxController {
	@Autowired
	PropostService dao;
 
	
	
	 @PostMapping("/ppReplyInsert") 
	 public ReplyVO ppReplyInsert(ReplyVO vo) {
	 dao.ppReplyInsert(vo); 
	 vo = dao.ppreplySelect(vo); 
	 return vo; 
	 }
	 
	
	
	

	//댓글 삭제
	@PostMapping("/ppReplyDelete")
	public int replyDelete(ReplyVO vo) {
		return dao.ppReplyDelete(vo);
	}

	
	
	}

