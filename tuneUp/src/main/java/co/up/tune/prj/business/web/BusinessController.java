package co.up.tune.prj.business.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.up.tune.file.service.FileService;
import co.up.tune.prj.business.service.BusinessService;
import co.up.tune.prj.vo.BusinessVO;
import co.up.tune.prj.vo.FilesVO;

@Controller
public class BusinessController {

	@Autowired
	BusinessService dao;
	
	@Autowired
	FileService fileDao;
	
	//업무 등록
	@PostMapping("/businessInsert")
	public String businessInsert(BusinessVO vo, @RequestParam("file") MultipartFile[] files,
									HttpSession session, RedirectAttributes re) throws IllegalStateException, IOException {
		vo.setEmpNo((String)session.getAttribute("empNo"));
		vo.setWrtr((String)session.getAttribute("nm"));
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
			fvo.setPNm(vo.getBussTtl());
			fvo.setEmpNo(vo.getEmpNo());
			
		}
		dao.businessInsert(vo, fvo);
		re.addAttribute("prjNo", vo.getPrjNo());
		
		return "redirect:prjPostList";
	}
}
