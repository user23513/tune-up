package co.up.tune.com.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.up.tune.com.notice.mapper.NoticeMapper;
import co.up.tune.com.vo.CommunityVO;

@Service
public class NoticeServiceImpl implements NoticeService {

	
	
	 @Autowired 
	 NoticeMapper map;
	
	 
	
	@Override
	public List<CommunityVO> noticeList() {
		// 공지사항 전체조회
		return map.noticeList();
	}
	
	@Override
	public CommunityVO noticeSelect(CommunityVO vo) {
		// 공지사항 상세조회
		return null;
	}

	@Override
	public int noticeInsert(CommunityVO vo) {
		// 공지사항 입력
		return 0;
	}

	@Override
	public int noticeUpdate(CommunityVO vo) {
		// 공지사항 수정
		return 0;
	}

	@Override
	public int noticeDelete(CommunityVO vo) {
		// 공지사항 삭제
		return 0;
	}

	@Override
	public List<CommunityVO> noticeSearch(String key, String val) {
		// 공지사항 검색
		return null;
	}

	@Override
	public int noticeHitUpdate(CommunityVO vo) {
		// 공지사항 조회수 업데이트
		return 0;
	}

	

}
