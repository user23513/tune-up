package co.up.tune.file.prj.mapper;

import java.util.List;

import co.up.tune.file.vo.FileVO;

public interface PrjFileMapper {
	
	List<FileVO> prjFileList();
	
	FileVO prjFileSelect(FileVO vo);
	int prjFileInsert(FileVO vo);
	int prjFileUpdate(FileVO vo);
	int prjFileDelete(FileVO vo);
	
	
}
