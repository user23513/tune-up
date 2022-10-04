package co.up.tune.com.vo;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonFormat;

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
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date dttm;      //작성일시
	private String replyCat; //댓글 카테고리 (커뮤니티인지 프로젝트인지)
}
