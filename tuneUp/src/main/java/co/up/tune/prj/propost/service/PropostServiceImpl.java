package co.up.tune.prj.propost.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.up.tune.prj.propost.mapper.PropostMapper;
import co.up.tune.prj.vo.PostVO;

@Service
public class PropostServiceImpl implements PropostService {
	@Autowired
	PropostMapper map;

	@Override
	public List<PostVO> prjPostList() {
		// 프로젝트 - 글 셀렉트 리스트
		return map.prjPostList();
	}

	@Override
	public int prjPostInsert(PostVO vo) {
		// 프로젝트 - 글 등록
		return map.prjPostInsert(vo);
	}

	@Override
	public int prjPostUpdate(PostVO vo) {
		// 프로젝트 - 글 수정
		return map.prjPostUpdate(vo);
	}

	@Override
	public int prjPostDelete(PostVO vo) {
		// 프로젝트 - 글 삭제
		return map.prjPostDelete(vo);
	}
	
	
}