package co.up.tune.prj.propost.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	// 내 프로젝트 - 관리자
	@GetMapping("/prjMng")
		public String prjMng() {
			return "prj/post/prjMng";
		}
	
	
	// 내 프로젝트 - 글 리스트
	@GetMapping("/prjPost")
	public String prjPost() {
		return "prj/post/prjPost";
	}

	//모달 고민쓰 - 글리스트
	@GetMapping("/prjPostt")
	public String prjPost2() {
		return "prj/prjPostm";
	}
	
	
	
	// 내 프로젝트 - 글 작성 폼 
	@GetMapping("/postInsertForm")
	public String postForm() {
		return "prj/post/postInsertForm";
	}

	@PostMapping("/postInsert")
	public String postInsert(PostVO vo) {
		dao.postInsert(vo);
		return "redirect:/prjPost";
	}
	
	}

