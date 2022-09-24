package co.up.tune.file.mapper;

import java.util.List;

import co.up.tune.prj.vo.FilesVO;

public interface ProPostFileMapper {

	List<FilesVO> proPostFileList(FilesVO vo);

	int proPostFileInsert(FilesVO vo);

	int proPostFileUpdate(FilesVO vo);

	int proPostFileDelete(FilesVO vo);
}
