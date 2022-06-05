package co.qwan.home.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.qwan.home.notice.dao.NoticeMapper;
import co.qwan.home.notice.vo.NoticeVO;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeMapper noticeMap;
	
	@Override
	public List<NoticeVO> selectList() {
		return noticeMap.selectList();
	}

	@Override
	public NoticeVO selectOne(NoticeVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertOne(NoticeVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOne(NoticeVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOne(NoticeVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
