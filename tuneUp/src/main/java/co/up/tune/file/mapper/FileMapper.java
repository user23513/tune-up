package co.up.tune.file.mapper;

import java.util.List;

import co.up.tune.prj.vo.FilesVO;

public interface FileMapper {
	//내파일함 리스트
	List<FilesVO> myFileList(FilesVO vo);//내파일함
	//List<FilesVO> prjFileList(FilesVO vo);//프로젝트 파일함
	List<FilesVO> prjFileList(String empNo);//프로젝트 파일함
	
	int fileDelete(FilesVO vo);//파일 삭제
	List<FilesVO> myFileInsert();//파일 업로드 ?????
	
	//proPost 
	List<FilesVO> proPostFileList(FilesVO vo);
	int proPostFileInsert(FilesVO vo);
	int proPostFileUpdate(FilesVO vo);
	int proPostFileDelete(FilesVO vo);

}
