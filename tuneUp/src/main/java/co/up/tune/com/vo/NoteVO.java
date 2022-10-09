package co.up.tune.com.vo;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class NoteVO {
	 int noteNo;		//쪽지번호
	 String sender;		//받는사람
	 String sEmpNo;		//받는사람 사번
	 String receiver;	//보낸사람
	 String rEmpNo;		//보낸사람 사번
	 String cntn;		//내용
	 
	 @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	 Timestamp dttm;	//발송일시
	 String keep;		//보관여부
	 
	 String[] sEmpNoList; //받는사람들 사번
	 int sendConut; //쪽지 보냈을때 받는 int
	 int[] noteNoList;//삭제할 쪽지번호
}
