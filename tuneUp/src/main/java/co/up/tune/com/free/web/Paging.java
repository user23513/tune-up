package co.up.tune.com.free.web;


import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Paging {
	
	private Integer pageNum; //현재 페이지 번호
	private int postNum = 10; //보여줄 게시글 개수
	int startNum; //시작하는 게시글 번호
	int endNum; //끝나는 게시글 번호
	
	public Paging() {}
	
	public Paging(Integer pageNum) {
		if(pageNum == null) {this.pageNum = 1;}
		this.pageNum = pageNum;
		this.startNum = (this.pageNum-1)*postNum+1;
		this.endNum = this.pageNum*postNum;
	}
	
	/*
	 * public Map<String, Integer> pagination(int pageNum) { int postNum = 10; //보여줄
	 * 게시글 갯수 int startNum = (pageNum-1)*postNum+1; //시작하는 게시글 번호 int endNum =
	 * pageNum*postNum; //끝나는 게시글 번호
	 * 
	 * Map<String, Integer> list = new HashedMap<String, Integer>();
	 * list.put("startNum", startNum); list.put("endNum", endNum);
	 * 
	 * return list; }
	 */
}
