package co.up.tune.com.note.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.up.tune.com.note.mapper.NoteMapper;
import co.up.tune.com.vo.NoteVO;

@Service
public class NoteServiceImpl implements NoteService {
	@Autowired
	NoteMapper map;
	
	
	@Override
	public List<NoteVO> sNoteList() {
		return map.sNoteList();
	}

	@Override
	public List<NoteVO> rNoteList() {
		return map.rNoteList();
	}

	@Override
	public List<NoteVO> kNoteList() {
		return map.kNoteList();
	}

	@Override
	public int noteInsert(NoteVO vo) {
		return map.noteInsert(vo);
	}

	@Override
	public int noteDelete(NoteVO vo) {
		return map.noteDelete(vo);
	}
	
	//쪽지 보내기
	@Override
	public int sendNote(NoteVO vo) {
		
		//보낸사람들 이름[]
        //vo.setSenderList(vo.getSender().split(" "));
		String[] sender = vo.getSender().split(" ");
		//보낸사람들 사번[]
        //vo.setSEmpNoList(vo.getSEmpNo().split(" "));
		String[] sEmpNo = vo.getSEmpNo().split(" ");
		
		return 0;
	}

}
