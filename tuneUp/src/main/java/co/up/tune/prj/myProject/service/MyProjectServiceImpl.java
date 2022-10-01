package co.up.tune.prj.myProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import co.up.tune.prj.myProject.mapper.MyProjectMapper;
import co.up.tune.prj.vo.ProjectVO;

@Service
public class MyProjectServiceImpl implements MyProjectService {

	@Autowired
	MyProjectMapper map;
	
	//내프로젝트 리스트
	@Override
	public List<ProjectVO> myPrjList(int empNo, int pageNo) {
		PageHelper.startPage(pageNo, 10);
		return map.myPrjList(empNo);
	}

}
