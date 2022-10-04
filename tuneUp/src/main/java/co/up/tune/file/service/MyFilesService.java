package co.up.tune.file.service;

import java.util.List;

import co.up.tune.prj.vo.FilesVO;

public interface MyFilesService {
	List<FilesVO> myFileList(String empNo);

}
