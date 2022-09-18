package co.up.tune.prj.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalendarVO {
	 int calNo;		//캘린더 번호
	 String empNo;	//사번
	 String cntn;	//일정내용
	 Date sdt;	//시작일
	 Date edt;	//종료일
	 String calTyp;	//캘린더유형
}
