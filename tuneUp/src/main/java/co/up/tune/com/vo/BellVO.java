package co.up.tune.com.vo;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BellVO {
	 int bellNo;	//알림번호
	 Timestamp dttm;	//일시
	 String sender;		//보낸사람
	 String receiver;	//받는사람
	 String cntn;	//내용
	 String readYn;		//확인여부
	 int empNo; //사원번호
	 
}
