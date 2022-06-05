package co.qwan.home.notice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.qwan.home.notice.vo.NoticeVO;

public interface NoticeService {
	public List<NoticeVO> selectList();
	public NoticeVO selectOne(NoticeVO vo);
	public int insertOne(NoticeVO vo);
	public int deleteOne(NoticeVO vo);
	public int updateOne(NoticeVO vo);
	
//	public boolean updateHits(NoticeVO vo);
	
}
