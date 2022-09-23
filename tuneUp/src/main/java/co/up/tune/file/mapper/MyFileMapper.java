package co.up.tune.file.mapper;

import java.util.List;

import co.up.tune.prj.vo.FilesVO;

public interface MyFileMapper {
	//내파일함 리스트
	List<FilesVO> myFileList(FilesVO vo);
	//내 파일함 추가 삭제
	int myFileInsert(FilesVO vo);
	int myFileDelete(FilesVO vo);
	
	//다운로드
	

}
