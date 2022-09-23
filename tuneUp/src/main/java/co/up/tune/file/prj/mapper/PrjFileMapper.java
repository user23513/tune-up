package co.up.tune.file.prj.mapper;

import java.util.List;

import co.up.tune.prj.vo.FilesVO;


public interface PrjFileMapper {
	
	List<FilesVO> prjFileList();
	
	FilesVO prjFileSelect(FilesVO vo);
	int prjFileInsert(FilesVO vo);
	int prjFileUpdate(FilesVO vo);
	int prjFileDelete(FilesVO vo);
	
	
}
