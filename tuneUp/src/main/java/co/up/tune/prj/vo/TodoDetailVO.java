package co.up.tune.prj.vo;

import java.sql.Date;
import lombok.Data;

@Data
public class TodoDetailVO {
	 int todoNo;	//상세목록 번호
	 String cntn;	//내용
	 String cmpltYn;	//완료여부
	 Date edt;		//종료일
	 int postNo;	//게시글 번호
}