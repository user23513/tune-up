package co.up.tune.com.note.service;

import java.util.List;

import co.up.tune.com.vo.NoteVO;

public interface NoteService {
	
	List<NoteVO> sNoteList(); //보낸 쪽지 리스트
	List<NoteVO> rNoteList(); //받은 쪽지 리스트
	List<NoteVO> kNoteList(); //보관함 쪽지 리스트
	int noteInsert(NoteVO vo); //쪽지 전송
	int noteDelete(NoteVO vo); //쪽지 삭제
	
	//현지
	int sendNote(NoteVO vo); //쪽지 보내기
	
}
