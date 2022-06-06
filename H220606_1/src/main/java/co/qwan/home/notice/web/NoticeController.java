package co.qwan.home.notice.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.qwan.home.notice.service.NoticeService;
import co.qwan.home.notice.vo.NoticeVO;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	@Autowired
	@Qualifier("noticeServiceImpl")
	NoticeService noticeService;
	
	@RequestMapping("/list")
	public String noticeList(Model model) throws Exception {
		List<NoticeVO> list = noticeService.selectList();
		if(true) {
//			throw new Exception("예외 발생!!");
		}
		
		model.addAttribute("list", list);
		return "notice.list";
	}
}
