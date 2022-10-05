package co.up.tune.com.free.service;

import java.util.List;

import com.github.pagehelper.Page;

import co.up.tune.com.vo.CommunityVO;
import co.up.tune.com.vo.ReplyVO;
import co.up.tune.com.vo.SearchVO;

public interface FreeService {
	
	//게시글
	Page<CommunityVO> freeList(int pageNo, SearchVO search); //자유게시판 전체조회
	CommunityVO freeSelect(CommunityVO vo); //자유게시판 상세조회
	int freeInsert(CommunityVO vo); //자유게시판 입력
	int freeUpdate(CommunityVO vo); //자유게시판 수정
	int freeDelete(CommunityVO vo); //자유게시판 삭제
	List<CommunityVO> freeSearch(String key, String val); //자유게시판 검색
	int freeHitUpdate(CommunityVO vo); //자유게시판 조회수증가
	int getTotal();
	
	//댓글
	List<ReplyVO> replyList(ReplyVO vo); //댓글 리스트
	ReplyVO replySelect(ReplyVO vo); //댓글 조회
	int replyInsert(ReplyVO vo); //댓글 등록
	int replyUpdate(ReplyVO vo); //댓글 수정
	int replyDelete(ReplyVO vo); //댓글 삭제
	

}
