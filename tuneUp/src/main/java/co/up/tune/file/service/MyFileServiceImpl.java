package co.up.tune.file.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.up.tune.file.mapper.MyFileMapper;
import co.up.tune.prj.vo.FilesVO;

@Service
public class MyFileServiceImpl implements MyFileService {
	
	@Autowired
	MyFileMapper map;
	
	@Override
	public List<FilesVO> myFileSelect(FilesVO vo) {
		return map.myFileList(vo);
	}

	@Override
	public int myFileInsert(FilesVO vo) {
		return map.myFileInsert(vo);
	}

	@Override
	public int myFileDelete(FilesVO vo) {
		return map.myFileDelete(vo);
	}

}
