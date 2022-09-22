package co.up.tune.file.aprv.mapper;

import java.util.List;

import co.up.tune.file.vo.FileVO;

public interface AprvFileMapper {
	
	List<FileVO> aprvFileList();
	
	int aprvFileInsert(FileVO vo);
	int pprvFileUpdate(FileVO vo);
	int aprvFileDelete(FileVO vo);
	
	
	
}
