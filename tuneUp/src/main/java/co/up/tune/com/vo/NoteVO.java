package co.up.tune.com.vo;

import java.sql.Timestamp;

public class NoteVO {
	 int note_no;		//쪽지번호
	 String sender;		//받는사람
	 String sEmpNo;		//받는사람 사번
	 String receiver;	//보낸사람
	 String rEmpNo;		//보낸사람 사번
	 String cntn;		//내용
	 Timestamp dttm;	//발송일시
	 String keep;		//보관여부
}
