package co.qwan.home.notice.dao;

import java.util.List;

import co.qwan.home.notice.vo.NoticeVO;

public interface NoticeMapper {
	List<NoticeVO> selectList();
	NoticeVO selectOne(NoticeVO vo);
	int insertOne(NoticeVO vo);
	int deleteOne(NoticeVO vo);
	int updateOne(NoticeVO vo);
}
