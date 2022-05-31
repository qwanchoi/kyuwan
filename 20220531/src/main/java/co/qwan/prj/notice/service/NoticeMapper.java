package co.qwan.prj.notice.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.qwan.prj.notice.vo.NoticeVO;

public interface NoticeMapper {
	List<NoticeVO> noticeSelectList(
		@Param("state")int state, 
		@Param("key")String key
	);
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	
	int noticeHitUpdate(int id); // 조회수 변경
}
