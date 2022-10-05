package co.up.tune.file.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import co.up.tune.prj.vo.FilesVO;

@Service
public class FileService {

	@Value("${file.dir}")
	private String fileDir;
	
	public List<FilesVO> fileUpload( @RequestParam("file") MultipartFile[] files, String folder) throws IllegalStateException, IOException {
		List<FilesVO> list = new ArrayList<FilesVO>();
		
		for(MultipartFile file:files) {
			FilesVO vo = new FilesVO();
			//원래 파일 이름 추출
			String origName = file.getOriginalFilename();
			
			//파일 이름으로 쓸 uuid 생성
			String uuid = UUID.randomUUID().toString();
			
			//확장자 추출(ex:.png)
			String extension = origName.substring(origName.lastIndexOf("."));
			
			//uuid와 확장자 결함
			String saveName = folder + File.separator + uuid + extension;
			
			//파일을 불러올 때 사용할 파일 경로
			String savePath = fileDir + File.separator + saveName;
			
			//파일 vo
			list.add(vo);
			vo.setFNm(origName);
			vo.setFPath(saveName);
			vo.setFType(extension);
			
			//실제 로컬에 uuid를 파일명으로 저장
			file.transferTo(new File(savePath));
			
		}
		
		return list;
	}
}
