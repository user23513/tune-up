package co.up.tune.file.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import co.up.tune.file.mapper.FileMapper;
import co.up.tune.prj.vo.FilesVO;

@Service
public class ProPostFileServiceImpl implements ProPostFileService {

	@Autowired
	FileMapper map;
	
	
	@Value("${file.dir}")
	private String fileDir;
	
	@Override
	public List<FilesVO> proPostFileList(FilesVO vo) {
		// TODO Auto-generated method stub
		return map.proPostFileList(vo);
	}
	
	
	@Override
	public int proPostFileInsert(FilesVO vo) {
		// TODO Auto-generated method stub
		return map.proPostFileInsert(vo);
	}
	
	
	@Override
	public int proPostFileDelete(FilesVO vo) {
		// TODO Auto-generated method stub
		return map.proPostFileDelete(vo);
	}

	@Override
	public FilesVO fileUpload(FilesVO vo,@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		//FilesVO vo = new FilesVO();
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
		//list.add(vo);
		vo.setFNm(origName);
		vo.setFPath(savePath);
		
		//실제 로컬에 uuid를 파일명으로 저장
		file.transferTo(new File(savePath));
		
		return vo;
		// TODO Auto-generated method stub
		
	}



	
//	public FilesVO ppfileUpload (FilesVO fvo,@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException{
//		//FilesVO fvo = new FilesVO();
//		String oFileName = file.getOriginalFilename();
//		String sFileName = UUID.randomUUID().toString() + oFileName.substring(oFileName.lastIndexOf("."));
//		String savePath = fileDir + File.separator + sFileName;
//		fvo.setFNm(oFileName);
//		fvo.setFPath(savePath);
//		file.transferTo(new File(savePath));
//		
//		
//		return fvo;
//			
//	}

//	@Override
//	public FilesVO ppfileUpload(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException{
//		FilesVO fvo = new FilesVO();
//		String oFileName = file.getOriginalFilename();
//		String sFileName = UUID.randomUUID().toString() + oFileName.substring(oFileName.lastIndexOf("."));
//		String savePath = fileDir + File.separator + sFileName;
//		fvo.setFNm(oFileName);
//		fvo.setFPath(savePath);
//		file.transferTo(new File(savePath));
//		
//		
//		return fvo;
			
	}

	
	