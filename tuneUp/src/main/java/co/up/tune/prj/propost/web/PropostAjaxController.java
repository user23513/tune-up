package co.up.tune.prj.propost.web;

import java.io.File;
import java.util.Date;

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
			if(fPath != "0") {
				File file = new File(fileDir + "\\" + fPath);
				file.delete();
			}
		}
		return cnt;
	}
	
	//=======댓글==========
		//댓글 등록
		@PostMapping("/pjReplyInsert")
		public ReplyVO pjReplyInsert(ReplyVO vo) {
			dao.pjReplyInsert(vo);
			vo = dao.pjReplySelect(vo);
			return vo;
		}
		
		//댓글 수정
		@PostMapping("/pjReplyUpdate")
		public Date pjReplyUpdate(ReplyVO vo) {
			dao.pjReplyUpdate(vo);
			System.out.println(vo.getDttm());
			return vo.getDttm();
		}
		
		//댓글 삭제
		@PostMapping("/pjReplyDelete")
		public int pjReplyDelete(ReplyVO vo) {
			return dao.pjReplyDelete(vo);
		}

	
	
}

