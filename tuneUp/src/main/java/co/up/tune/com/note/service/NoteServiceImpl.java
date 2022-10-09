package co.up.tune.com.note.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import co.up.tune.com.note.mapper.NoteMapper;
import co.up.tune.com.vo.NoteVO;
import co.up.tune.com.vo.SearchVO;

@Service
public class NoteServiceImpl implements NoteService {
	@Autowired
	NoteMapper map;
	
	
	@Override
	public Page<NoteVO> sNoteList(String empNo, int pageNo) {
		PageHelper.startPage(pageNo, 10);
		return map.sNoteList(empNo);
	}

	//받은 쪽지 리스트
	@Override
	public Page<NoteVO> rNoteList(String empNo, int pageNo) {
		PageHelper.startPage(pageNo, 10);
		return map.rNoteList(empNo); 
	}

	@Override
	public Page<NoteVO> kNoteList(String empNo, int pageNo) {
		PageHelper.startPage(pageNo, 10);
		return map.kNoteList(empNo);
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
		List<NoteVO> noteList = new ArrayList<>();
		int send = 0;
		
		//보낸사람들 이름[]
		String[] sender = vo.getSender().split(" ");
		//보낸사람들 사번[]
		String[] sEmpNo = vo.getSEmpNo().split(" ");
		
		for(int i = 0; i<sender.length; i++) {
			NoteVO nvo = new NoteVO();
			nvo.setSender(sender[i]);
			nvo.setSEmpNo(sEmpNo[i]);
			nvo.setReceiver(vo.getReceiver());
			nvo.setREmpNo(vo.getREmpNo());
			nvo.setCntn(vo.getCntn());
			noteList.add(nvo);
		}
		
		for(NoteVO n:noteList) {
			send = map.sendNote(n);
		}
		
		return send;
	}

	//쪽지 갯수
	@Override
	public int noteCount(NoteVO vo) {
		return map.noteCount(vo);
	}

	//쪽지 보관
	@Override
	public int noteKeep(NoteVO vo) {
		return map.noteKeep(vo);
	}

}
