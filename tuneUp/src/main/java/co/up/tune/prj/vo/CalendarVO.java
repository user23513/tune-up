package co.up.tune.prj.vo;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalendarVO {
	 int calNo;		//캘린더 번호
	 String empNo;	//사번
	 String cntn;	//일정내용
	 
	 @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	 Date sdt;	//시작일
	 @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	 Date edt;	//종료일
	 
	 String calTyp;	//캘린더유형
	 String nm; //일정명
}
