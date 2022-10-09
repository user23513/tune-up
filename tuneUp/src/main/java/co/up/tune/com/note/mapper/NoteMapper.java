package co.up.tune.com.note.mapper;

import com.github.pagehelper.Page;

import co.up.tune.com.vo.NoteVO;

public interface NoteMapper {
	
	Page<NoteVO> sNoteList(String empNo); //보낸 쪽지 리스트
	Page<NoteVO> rNoteList(String empNo); //받은 쪽지 리스트
	Page<NoteVO> kNoteList(String empNo); //보관함 쪽지 리스트
	int noteInsert(NoteVO vo); //쪽지 전송
	int noteDelete(NoteVO vo); //쪽지 삭제
	
	//현지
	int sendNote(NoteVO noteList); //쪽지 보내기
	int noteCount(NoteVO vo); //쪽지 갯수
	int noteKeep(NoteVO vo); //쪽지 보관
}
