package co.up.tune.file.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.up.tune.file.mapper.FileMapper;
import co.up.tune.prj.vo.FilesVO;

@Service
public class PrjfilesServiceImpl implements PrjFilesService {
	
	@Autowired
	FileMapper map;

	@Override
	public List<FilesVO> prjFileList(String empNo) {
		return map.prjFileList(empNo);
	}

	@Override
	public int fileDelete(FilesVO vo) {
		return map.fileDelete(vo);
	}



}
