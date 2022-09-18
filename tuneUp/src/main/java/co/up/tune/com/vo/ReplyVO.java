package co.up.tune.com.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyVO {

	private int replyNo;    //댓글 번호
	private int postNo;     //게시글 번호
	private String empNo;   //사원 번호
	private String wrtr;    //작성자
	private String cntn;    //댓글 내용
	private Date dttm;      //작성일시
	private String replyCat; //
}
