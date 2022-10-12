package co.up.tune.file.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import co.up.tune.file.service.FileService;
import co.up.tune.prj.propost.service.PropostService;
import co.up.tune.prj.vo.FilesVO;

@Controller
public class ProPostFileController {

	@Autowired
	PropostService dao;
	
	@Autowired
	FileService fdao;
	
	@Value("${file.dir}")
	private String fileDir;
	
	@PostMapping("/fileUpload")
	public String fileUpload(FilesVO vo, MultipartFile file) throws IllegalStateException, IOException {
		return "prj/post/prjPostList";
	}
}

