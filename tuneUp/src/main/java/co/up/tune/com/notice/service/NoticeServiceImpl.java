package co.up.tune.com.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import co.up.tune.com.notice.mapper.NoticeMapper;
import co.up.tune.com.vo.CommunityVO;
import co.up.tune.com.vo.SearchVO;
import co.up.tune.prj.vo.BusinessVO;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired 
	NoticeMapper map;
	
	@Override
	public Page<CommunityVO> noticeList(int pageNo, SearchVO search) {
		// 공지사항 전체조회
		PageHelper.startPage(pageNo, 10);
		return map.noticeList(search);
	}
	
	@Override
	public CommunityVO noticeSelect(CommunityVO vo) {
		// 공지사항 상세조회
		return map.noticeSelect(vo);
	}

	@Override
	public int noticeInsert(CommunityVO vo) {
		// 공지사항 입력
		return map.noticeInsert(vo);
	}

	@Override
	public int noticeUpdate(CommunityVO vo) {
		// 공지사항 수정
		return map.noticeUpdate(vo);
	}

	@Override
	public int noticeDelete(CommunityVO vo) {
		// 공지사항 삭제
		return map.noticeDelete(vo);
	}

	@Override
	public List<CommunityVO> noticeSearch(String key, String val) {
		// 공지사항 검색
		return noticeSearch(key, val);
	}

	@Override
	public int noticeHitUpdate(CommunityVO vo) {
		// 공지사항 조회수 업데이트
		return map.noticeHitUpdate(vo);
	}

	//===========================
	@Override
	public List<BusinessVO> ganttList(BusinessVO vo) {
		// TODO Auto-generated method stub
		return map.ganttList(vo);
	}

	

}
