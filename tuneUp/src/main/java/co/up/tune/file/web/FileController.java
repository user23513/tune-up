package co.up.tune.file.web;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.up.tune.file.service.FileService;
import co.up.tune.file.service.MyFilesService;
import co.up.tune.file.service.PrjFilesService;
import co.up.tune.prj.vo.FilesVO;

@Controller
public class FileController {
	
	@Autowired
	FileService fService;
	
	@Autowired
	PrjFilesService prjService;
	
	@Autowired
	MyFilesService myService;
	
	//내 파일함 페이지
	@GetMapping("/files")
	public String files(HttpSession session, Model model) {
		String empNo = (String) session.getAttribute("empNo");
		model.addAttribute("prjFileList", prjService.prjFileList(empNo));
		model.addAttribute("myFileList",myService.myFileList(empNo));
		return "file/file";
	}
	
	
	//파일함 폼
	@GetMapping("/fileUploadForm")
	public String myFileInsertForm() {
		return "file/myFileInsertForm";
	}
	
	
	//파일등록
//	 @PostMapping("/myFileInsert")
//	public String fileUpload(List<FilesVO> vo, @RequestParam("file") MultipartFile file) throws IllegalStateException, IOException { 
//		 //file upload 처리 
//		 if(!file.isEmpty()) { 
//		 	vo = fService.fileUpload(null, null)
//		}
	
	  //파일 삭제
	  @ResponseBody
	  @PostMapping("/filedelete") 
	  public int filedelete(FilesVO vo, HttpServletRequest request) throws Exception{
		  return prjService.fileDelete(vo); 
	  }
	 
		
	
		
	//파일다운로드
	@GetMapping("/myfileattach/{no}")
	public ResponseEntity<UrlResource> download(FilesVO vo ,@PathVariable("no") int no) {
		//파일 다운로드
		vo.setFileNo(no);
//		vo = (FilesVO) mdao.myFileSelect(vo); //(FilesVO) ???
		
		String filePath = vo.getFPath();
		File target = new File(filePath);
		HttpHeaders header = new HttpHeaders();
		UrlResource rs = null;
		if(target.exists()) {
			try {
				String mimeType = Files.probeContentType(Paths.get(target.getAbsolutePath()));
				if(mimeType == null) {
					mimeType = "octet-stream";
				}
				rs = new UrlResource(target.toURI());
				header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + rs.getFilename() + "\"");
				header.setCacheControl("no-cache");
				header.setContentType(MediaType.parseMediaType(mimeType));
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return new ResponseEntity<UrlResource>(rs, header, HttpStatus.OK);
	}

}
