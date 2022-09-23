package co.up.tune.file.mapper;

import java.util.List;

import co.up.tune.prj.vo.FilesVO;


public interface AprvFileMapper {
	
	List<FilesVO> aprvFileList();
	
	int aprvFileInsert(FilesVO vo);
	int aprvFileUpdate(FilesVO vo);
	int aprvFileDelete(FilesVO vo);
	
	
	
}
