package co.up.tune.prj.propost.web;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.up.tune.com.vo.ReplyVO;
import co.up.tune.prj.propost.service.PropostService;

@RestController
public class PropostAjaxController {
	
	@Autowired
	PropostService dao;
	
	@Value("${file.dir}") 
	private String fileDir;
	
	//게시글 삭제
	@PostMapping("/postDelete")
	public int prjPostDelete(@RequestParam("postNo")int postNo, @RequestParam("type")String type, @RequestParam("fPath")String fPath) {
		int cnt = dao.postDelete(postNo, type); //성공하면 -1이 반환됨
		if(cnt != 0) {
			File file = new File(fileDir + "\\" + fPath);
			file.delete();
		}
		return cnt;
	}
	
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

