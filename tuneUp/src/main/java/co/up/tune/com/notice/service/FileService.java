package co.up.tune.com.notice.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import co.up.tune.com.vo.CommunityVO;

@Service
public class FileService {

	@Value("${file.dir}")
	private String fileDir;
	
	public CommunityVO fileUpload(CommunityVO vo, @RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		
		//원래 파일 이름 추출
		String origName = file.getOriginalFilename();
		
		//파일 이름으로 쓸 uuid 생성
		String uuid = UUID.randomUUID().toString();
		
		//확장자 추출(ex:.png)
		String extension = origName.substring(origName.lastIndexOf("."));
		
		//uuid와 확장자 결함
		String saveName = uuid + extension;
		
		//파일을 불러올 때 사용할 파일 경로
		String savePath = fileDir + File.separator + saveName;
		
		//파일 vo
		vo.setFNm(origName);
		vo.setFPath(savePath);
		
		//실제 로컬에 uuid를 파일명으로 저장
		file.transferTo(new File(savePath));
		
		return vo;
	}
}
