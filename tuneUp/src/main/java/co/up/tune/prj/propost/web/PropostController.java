package co.up.tune.prj.propost.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageInfo;

import co.up.tune.com.vo.ReplyVO;
import co.up.tune.file.service.FileService;
import co.up.tune.file.service.ProPostFileService;
import co.up.tune.prj.myProject.service.MyProjectService;
import co.up.tune.prj.propost.service.PropostService;
import co.up.tune.prj.schedule.service.ScheduleService;
import co.up.tune.prj.todo.service.TodoDetailService;
import co.up.tune.prj.todo.service.TodoService;
import co.up.tune.prj.vo.FilesVO;
import co.up.tune.prj.vo.PostVO;
import co.up.tune.prj.vo.ProjectVO;
import co.up.tune.prj.vo.ScheduleVO;
import co.up.tune.prj.vo.TodoVO;

@Controller
public class PropostController {
	@Autowired
	PropostService dao;
	
	@Autowired
	ProPostFileService fdao;
	
	@Autowired
	FileService fileDao;
	
	@Autowired
	MyProjectService myDao;
	
	@Autowired
	ScheduleService sDao;
	
	/**
	 * 은지 추가 
	 * 2022.10.05
	 */
	@Autowired
	TodoService tServ;

	@Autowired
	TodoDetailService detail;
	
	@Value("${file.dir}") 
	private String fileDir;
	
	//내프로젝트에서 클릭한 프로젝트로 이동
	@RequestMapping("/prjPostList")
	public String prjPostList(TodoVO vo ,@RequestParam(value="pageNum", required = false, defaultValue = "1") int pageNum, 
								@RequestParam("prjNo")int prjNo, Model model, HttpServletRequest request) {
		
		model.addAttribute("prjNo", prjNo);
		//관리자버튼 empNo세션값
		HttpSession session =  request.getSession();
		
		String empNo =(String)session.getAttribute("empNo");
		
		/* 일정 */
		PageInfo<ScheduleVO> s = new PageInfo<>(sDao.scheduleList(pageNum, prjNo),10); //페이징
		model.addAttribute("scheduleList", s);
		
		model.addAttribute("scheduleMember", dao.scheduleMemberList(prjNo));
		
		/* 글 */
		model.addAttribute("postList", dao.prjPostList(prjNo));
		
		/* 업무 */
		model.addAttribute("businessList", dao.businessList(prjNo));
		
		/* 댓글 */
		model.addAttribute("replyList", dao.prjReplyList());
		
		/* 파일 */
		model.addAttribute("postFiles", dao.prjPostFiles(prjNo));
		
		/* 할일 */
		/**
		 * 은지 추가 
		 * 2022.10.05
		 */
		model.addAttribute("todoList", tServ.todoList(prjNo));
		model.addAttribute("detailList", detail.detailList());
		
		//프로젝트 관리버튼 권한체크
		/**
		 * 현진 추가 
		 * 2022.10.07
		 */
		model.addAttribute("isAuth", dao.isAuth(empNo, prjNo));
		
		//프로젝트 상세정보 10.09 정은 추가
		ProjectVO prjD = new ProjectVO();
		prjD.setPrjNo(prjNo);
		model.addAttribute("prjDetail", dao.projectSel(prjD));
	
		return "prj/post/prjPostList";
	}
	
	// 프로젝트- 글 상세조회
	@PostMapping("/prjPostSelect")
	public String prjPostSelect(PostVO pvo, ReplyVO rvo, Model model) {
		model.addAttribute("p", dao.prjPostSelect(pvo));

		// 댓글 리스트
		rvo.setPostNo(pvo.getPostNo());
		model.addAttribute("pjReplyList", dao.pjReplyList(rvo));
		return "prj/post/prjPostSelect";
	}
	
	// 내 프로젝트 - 게시글 작성 폼으로 이동
	@PostMapping("/postInsertForm")
	public String prjPostInsertForm(@RequestParam("prjNo")int prjNo, HttpSession session, Model model) {
		model.addAttribute("empList", dao.empList((String)session.getAttribute("empNo")));
		model.addAttribute("prjNo", prjNo);
		return "prj/post/postInsertForm";
	}
	
	//내프로젝트 글 등록(파일까지)
	@PostMapping("/prjPostInsert") 
	public String prjPostInsert(PostVO vo, @RequestParam("file") MultipartFile[] files, 
								RedirectAttributes re) throws IllegalStateException, IOException { 
		//file upload 처리
		FilesVO fvo = new FilesVO();
		List<FilesVO> list = new ArrayList<>();

		if(files.length != 0 && files[0] != null && files[0].getSize() > 0) {

			String folder = "prj"; //Temp안에 폴더명
			list = fileDao.fileUpload(files, folder);
			fvo.setFNm(list.get(0).getFNm());
			fvo.setFPath(list.get(0).getFPath());
			fvo.setFType(list.get(0).getFType());
			
			//프로젝트 제목
			ProjectVO prjD = new ProjectVO();
			prjD.setPrjNo(vo.getPrjNo());
			prjD = dao.projectSel(prjD);
			
			fvo.setFCat("PROJECT");
			fvo.setPNm(prjD.getNm());
			fvo.setEmpNo(vo.getEmpNo());
		}
		
		dao.prjPostInsert(vo, fvo);
		re.addAttribute("prjNo", vo.getPrjNo());
		
		return "redirect:prjPostList";
	}
	
	//내프로젝트 글 수정
	@PostMapping("/prjPostUpdate")
	public String prjPostUpdate(PostVO vo, @RequestParam("file") MultipartFile[] files, RedirectAttributes re) throws IllegalStateException, IOException {
		//file upload 처리
		FilesVO fvo = new FilesVO();
		List<FilesVO> list = new ArrayList<>();
		if(!files[0].isEmpty()) {
			String folder = "prj"; //Temp안에 폴더명
			list = fileDao.fileUpload(files, folder);
			fvo.setFNm(list.get(0).getFNm());
			fvo.setFPath(list.get(0).getFPath());
			fvo.setFType(list.get(0).getFType());
			fvo.setFCat("PROJECT");
			fvo.setPNm(vo.getTtl());
		}
		
		dao.prjPostUpdate(vo, fvo);
		
		re.addAttribute("prjNo", vo.getPrjNo());
		
		return "redirect:prjPostList";
	}
	
	//내프로젝트 업무 수정
	@PostMapping("/prjBusinessUpdate")
	public String prjBusinessUpdate(PostVO vo, @RequestParam("file") MultipartFile[] files, RedirectAttributes re) throws IllegalStateException, IOException {
		//file upload 처리
		FilesVO fvo = new FilesVO();
		List<FilesVO> list = new ArrayList<>();
		if(!files[0].isEmpty()) {
			String folder = "prj"; //Temp안에 폴더명
			list = fileDao.fileUpload(files, folder);
			fvo.setFNm(list.get(0).getFNm());
			fvo.setFPath(list.get(0).getFPath());
			fvo.setFType(list.get(0).getFType());
			fvo.setFCat("PROJECT");
			fvo.setPNm(vo.getTtl());
		}
		
		re.addAttribute("prjNo", vo.getPrjNo());
		
		return "redirect:prjPostList";
	}
	
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

