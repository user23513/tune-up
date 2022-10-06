package co.up.tune.file.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.up.tune.file.mapper.FileMapper;
import co.up.tune.prj.vo.FilesVO;

@Service
public class MyFilesServiceImpl implements MyFilesService {
	
	@Autowired
	FileMapper map;
	
	@Override
	public List<FilesVO> myFileList(String empNo) {
		return map.myFileList(empNo);
	}

	//파일 업로드
	@Override
	public int myFileInsert(FilesVO vo) {
		return map.myFileInsert(vo);
	}

}
