package co.up.tune.paging.vo;

import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;

@Component
@Data
public class Criteria {

	private int pageNum; //현재 페이지 번호
	private int postNum = 10; //보여줄 게시글 갯수
	private String val; //검색 값
	private String keyword; //검색 유형(전체,제목,내용,작성자 등)
	
	//생성자로 무조건 1번으로 실행
	//기본페이지를 1페이지
	public Criteria() {
		this.pageNum = 1;
	}
	
	//매개변수로 들어오는 값을 이용해 조정
	public Criteria(int pageNum) {
		this.pageNum = pageNum;
	}
	
	//UricomponentsBuiler를 이용하여 링크 생성
	public String getListLink() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", pageNum)
				.queryParam("postNum", postNum);
		return builder.toUriString();
	}
	
	
	
}
