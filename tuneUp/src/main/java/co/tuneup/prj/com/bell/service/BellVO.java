package co.tuneup.prj.com.bell.service;

import java.sql.Timestamp;

public class BellVO {
	 int bellNo;	//알림번호
	 Timestamp dttm;	//일시
	 String sender;		//받는사람
	 String receiver;	//보낸사람
	 String cntn;	//내용
	 String readYn;		//확인여부
}
