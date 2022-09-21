package co.up.tune.prj.propost.web;



import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import co.up.tune.com.vo.ReplyVO;
import co.up.tune.prj.propost.service.PropostService;
import co.up.tune.prj.vo.PostVO;


@Controller
public class PropostController {
	@Autowired
	PropostService dao;
 
	
//	//내 프로젝트 목록
//	@GetMapping("/myProject")
//	public String myProject() {
//		return "prj/post/myProject";
//	}
	
	
	
	// 내 프로젝트 - 글 리스트
	@GetMapping("/prjPostList")
	public String prjPostList(Model model,ReplyVO rvo,PostVO pvo) {
		model.addAttribute("prjPostList", dao.prjPostList());
		rvo.setPostNo(pvo.getPostNo());
		model.addAttribute("ppReplyList", dao.ppReplyList(rvo));
		return "prj/post/prjPostList";
	}

	//모달 고민쓰 - 글리스트
	@GetMapping("/prjPostt")
	public String prjPost2() {
		return "prj/prjPostm";
	}
	
	
	// 내 프로젝트 - 글 작성 폼 
	@GetMapping("/postInsertForm")
	public String prjPostInsertForm() {
		return "prj/post/postInsertForm";
	}
	
	// 내프로젝트 - 글 작성 post
//	  @PostMapping("/prjPostInsert") 
//	  public String prjPostInsert(PostVO vo) {
//	  dao.prjPostInsert(vo); 
//	  return "redirect:/prjPostList"; 
//	  }
	
	
	
	  
	  // @RequestPart(value="file",required = false), @RequestParam("file")
	
	  @PostMapping("/prjPostInsert")
		public String prjPostInsert(PostVO vo,  @RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
			
		  dao.prjPostInsert(vo);
			
			return "redirect:/prjPostList";
		}
		
	  
	  
	  
	  
	 
	  //내 프로젝트 - 글 삭제 post
	  @PostMapping("/prjPostDelete")
  	  public String prjPostDelete(PostVO vo) {
  		dao.prjPostDelete(vo);
  		return "redirect:/prjPostList";
  		  
  	  }
	  
	  
//	  @PostMapping("/prjPostDelete")
//		public String prjPostDelete(PostVO vo) {
//			dao.prjPostDelete(vo);
//			return "redirect:/prjPostList";
//		}
	  
	  
	//내 프로젝트 - 글 수정 폼 post
	  @PostMapping("/postUpdateForm")
		public String prjPostUpdateForm() {
			return "prj/post/postUpdateForm";
		}
	  
	  
	  //내 프로젝트 - 글 수정 post
	  @PostMapping("/prjPostUpdate")
		public String prjPostUpdate(PostVO vo) {
			dao.prjPostUpdate(vo);
			
			return "redirect:/prjPostList";
		}
	  
	  
	  
	  // ============================
	  
//	   //게시판 게시글 수정
//	    @RequestMapping(value = "/prjPostUpdate")
//	    public String boardUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
//	 
//	        return "board/boardUpdate";
//	    }
	  
	  
		
	  
//	  @RequestMapping("/prjPostDelete")
//	  public String prjPostDelete(PostVO vo, Model model) {
//		  dao.prjPostDelete(vo);
//		return "redirect:/prjPostList";
//	  }
	  
//	 @RequestMapping("prjPostDelete")
//	 public String prjPostDelete(PostVO vo, Model model) {
//		 int n = dao.prjPostDelete(vo);
//		 if( n != 0) {
//			 model.addAttribute("message", "삭제 되었습니다.");
//		 }
//		 return "redirect:/prjPostList"; 
//	 }
	
	
	
	
	// 내 프로젝트 - 관리자
	@GetMapping("/prjMng")
		public String prjMng() {
			return "prj/post/prjMng";
		}
	
	@GetMapping("aaa")
	public String aaa() {
		return"prj/post/test";
	}
	
	
	}

