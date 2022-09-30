package co.up.tune.prj.propost.web;



import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import co.up.tune.com.vo.ReplyVO;
import co.up.tune.file.service.ProPostFileService;
import co.up.tune.prj.propost.service.PropostService;
import co.up.tune.prj.vo.FilesVO;
import co.up.tune.prj.vo.PostVO;


@Controller
public class PropostController {
	@Autowired
	PropostService dao;
	
	@Autowired
	ProPostFileService fdao;
	
//	@Autowired
//	testService fdao;
	
	  @Value("${file.dir}") 
	  private String fileDir;
	 
	

//	@Autowired	
//	//내 프로젝트 목록
//	@GetMapping("/myProject")
//	public String myProject() {
//		return "prj/post/myProject";
//	}
	
	//내프로젝트에서 클리하면 나오는 해당 프로젝트 '현지수정'
	@PostMapping("/prjPostList")
	public String prjPostList(@RequestParam("prjNo")int prjNo, Model model) {
		model.addAttribute("prjNo", prjNo);
		model.addAttribute("scheduleList", dao.scheduleList(prjNo));
		model.addAttribute("scheduleMember", dao.scheduleMemberList(prjNo));
		return "prj/post/prjPostList";
	}
	
	// 내 프로젝트 - 글 리스트
	@GetMapping("/prjPostList")
	public String prjPostList(Model model,ReplyVO rvo,PostVO pvo) {
		model.addAttribute("prjPostList", dao.prjPostList());
		
		//model.addAttribute("p", dao.freeSelect(cvo));
		
		rvo.setPostNo(pvo.getPostNo());
		model.addAttribute("ppReplyList", dao.ppReplyList(rvo));
		return "prj/post/prjPostList";
	}
	
	
	// 프로젝트- 글 상세조회
		@PostMapping("/prjPostSelect")
		public String prjPostSelect(PostVO pvo, ReplyVO rvo, Model model) {
			//dao.freeHitUpdate(cvo);
			
			model.addAttribute("p", dao.prjPostSelect(pvo));

			// 댓글 리스트
//			rvo.setPostNo(pvo.getPostNo());
//			model.addAttribute("ppReplyList", dao.ppReplyList(rvo));
			return "prj/post/prjPostSelect";
		}
	
	

	//모달 고민쓰 - 글리스트
	@GetMapping("/prjPostt")
	public String prjPost2() {
		return "prj/prjPostm";
	}
	
	
	// 내 프로젝트 - 게시글 작성 폼 
	@PostMapping("/postInsertForm")
	public String prjPostInsertForm(@RequestParam("prjNo")int prjNo, Model model) {
		model.addAttribute("empList", dao.empList());
		model.addAttribute("prjNo", prjNo);
		return "prj/post/postInsertForm";
	}
	
	
	 @PostMapping("/prjPostInsert") 
	 public String prjPostInsert(PostVO vo,@RequestParam("file") MultipartFile file) throws IllegalStateException,
	 IOException { 
		 FilesVO fvo = new FilesVO();
		 dao.prjPostInsert(vo);
		 if (!file.isEmpty()) {
			 fdao.fileUpload(fvo, file);
			 
		 }
		return "redirect:/prjPostList";
	 
	 }
	
	
	// 내프로젝트 - 글 작성 post
//	  @PostMapping("/prjPostInsert") 
//	  public String prjPostInsert(PostVO vo) {
//	  dao.prjPostInsert(vo); 
//	  return "redirect:/prjPostList"; 
//	  }
	
	
	
	  
	  // @RequestPart(value="file",required = false), @RequestParam("file")
	
	//내 프로젝트 - 글 작성 백업
	/*
	 * @PostMapping("/prjPostInsert") public String prjPostInsert(PostVO
	 * vo, @RequestParam("file") MultipartFile file) throws IllegalStateException,
	 * IOException { if (!file.isEmpty()) {
	 * 
	 * } dao.prjPostInsert(vo); //fdao.proPostFileInsert(fvo); return
	 * "redirect:/prjPostList"; }
	 */
	
	
	
	
	
	
	
	
		//파일 등록은 이거로 백업
//	@PostMapping("/prjPostInsert")
//	public String proPostFileInsert(PostVO vo,@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException{
//		FilesVO fvo = new FilesVO();
//		String oFileName = file.getOriginalFilename();
//		String sFileName = UUID.randomUUID().toString() + oFileName.substring(oFileName.lastIndexOf("."));
//		String savePath = fileDir + File.separator + sFileName;
//		if(!oFileName.isEmpty()) {
//			fvo.setFNm(oFileName);
//			fvo.setFPath(savePath);
//		}
//		dao.prjPostInsert(vo);
//		return "redirect:/prjPostList";
//	}
	
//	@PostMapping("/prjPostInsert")
//	public String prjPostInsert(PostVO vo, @RequestParam("file") MultipartFile file) 
//	throws IllegalStateException, IOException{
//		FilesVO fvo = new FilesVO();
//		String saveFolder = fileDir;
//		File sfile = new File(saveFolder);
//		String oFileName = file.getOriginalFilename();
//		
//		 
//		if(!oFileName.isEmpty()) {
//			String sFileName = UUID.randomUUID().toString() + oFileName.substring(oFileName.lastIndexOf("."));
//			String savePath = saveFolder + File.separator + sFileName;
//		file.transferTo(new File(sfile,sFileName));
//		//vo.setAtchNo(savePath);
//		}
//		System.out.println();
//		ffdao.ppfileUpload(fvo);
//		dao.prjPostInsert(vo);
//		System.out.println("================="+vo);
//		System.out.println("================="+fvo);
//		return "redirect:/prjPostList";
//		
//	}
	
	

	
	
	
	
	
	//  등록(파일까지)
//	@PostMapping("/prjPostInsert")
//	public String prjPostInsert(@RequestParam("file")) {
//		return null;
//		
//	}
	

	
	
	
	

	  
	  
	 
	  //내 프로젝트 - 글 삭제 post
	  @PostMapping("/prjPostDelete")
  	  public String prjPostDelete(PostVO vo) {
  		dao.prjPostDelete(vo);
  		return "redirect:/prjPostList";
  		  
  	  }
	  
	  
	  
	//내 프로젝트 - 글 수정 폼 post
	  @PostMapping("/postUpdateForm")
		public String prjPostUpdateForm(PostVO vo, Model model) {
		  model.addAttribute("pj", dao.prjPostSelect(vo));
		  //dao.prjPostUpdate(vo);
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
		
//		  @PostMapping("/ppReplyInsert") 
//		  public String ppReplyInsert(ReplyVO vo) {
//		  dao.ppReplyInsert(vo); 
//		  return "redirect:/prjPostList";
//		  
//		  }
		 
	
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

