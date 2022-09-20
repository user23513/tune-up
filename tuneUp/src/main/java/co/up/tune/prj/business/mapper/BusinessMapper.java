package co.up.tune.prj.business.mapper;

import java.util.List;

import co.up.tune.com.vo.ReplyVO;
import co.up.tune.prj.vo.BusinessVO;

public interface BusinessMapper {
	List<BusinessVO> businessList();
	int businessInsert(BusinessVO vo);
	int businessUpdate(BusinessVO vo);
	int businessDelete(BusinessVO vo);
	
	List<ReplyVO> bReplyList(ReplyVO vo);
	int bReplyInsert(ReplyVO vo); 
	int bReplyDelete(ReplyVO vo);

}
