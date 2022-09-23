package co.up.tune.paging.vo;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.stereotype.Component;

import co.up.tune.com.free.web.Paging;
import lombok.Data;

@Component
@Data
public class pagingVO {
	
	int pageSize = 5; //화면 하단에 출력할 페이지사이즈 (버튼)
	int startPage; //pageSize 가 10이고, currentPageNo가 3이라면 1페이지를 의미합니다.
	int endPage; //pageSize 가 10이고, currentPageNo가 3이라면 10페이지를 의미합니다.
	int realEnd; //실제 마지막 page번호, endPage가 realEnd보다 클수 없다
	boolean prev, next; //prev:이전페이지 존재여부, 현재페이지가 3이면 첫페이지번호는 1, 첫페이지 번호가 1이면 false, 1이 아니면 true
	                            //next:endPage가 realEnd보다 작으면 true
	int total; //전체 데이터 갯수
	Paging paging; //페이지번호 계산에 필요한 Criteria클래스
	String val; //검색 값
	String keyword; //검색 유형(전체,제목,내용,작성자 등)
	
	public pagingVO() {}
	
	public pagingVO(int total, Paging paging) {
		this.total = total;
		this.paging = paging;
		
		this.endPage = (int)(Math.ceil(paging.getPageNum()*1.0/pageSize))*pageSize;
		this.startPage = endPage-(pageSize-1);
		
		realEnd = (int)(Math.ceil(total*1.0/paging.getPostNum()));
		
		if(endPage > realEnd) {
			endPage = realEnd == 0 ? 1 : realEnd;
		}
		
		prev = startPage > 1;
		next = endPage < realEnd;
	}
	
	
}
