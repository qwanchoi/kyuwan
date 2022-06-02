package co.qwan.prj.notice.web;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import co.qwan.prj.notice.service.NoticeService;
import co.qwan.prj.notice.vo.NoticeVO;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeDao;
	
	@Autowired
	private String saveDir; // IoC 에서 저장된 것을 가져온다.
	
	@RequestMapping("/noticeList.do")
	public String noticeList(Model model) {
		model.addAttribute("notices", noticeDao.noticeSelectList(1, "전체"));
		return "notice/noticeList";
	}
	
	@RequestMapping("/noticeInsertForm.do") 
	public String noticeInsertForm(){
		return "notice/noticeInsertForm";
	}
	
	@PostMapping("/noticeInsert.do")
	public String noticeInsert(NoticeVO vo, MultipartFile file) {
		String fileName = file.getOriginalFilename();
		
//		vo.setNoticeAttach("");
//		vo.setNoticeDir("");
		if(fileName != null && !fileName.isEmpty() && fileName.length() != 0) {
			
			// uuid(범용 고유 식별자) 사용하여 파일 명 변경
			String uid = UUID.randomUUID().toString();
			String saveFileName = uid + fileName.substring(fileName.indexOf("."));
			
			File target = new File(saveDir, saveFileName);
			vo.setNoticeAttach(fileName); // 파일명
			vo.setNoticeDir(saveFileName); //실제저장경로
			try {
				FileCopyUtils.copy(file.getBytes(), target);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//파일이 있을경우 파일을 먼저 업로드하고 DB저장		
		noticeDao.noticeInsert(vo);
		
		return "redirect:noticeList.do";
	}
	
	@PostMapping("/getContent.do")
	public String getContent(NoticeVO vo, Model model) {
//	public String getContent(@RequestParam int noticeId) { // Get 방식일 경우 파라미터
		noticeDao.noticeHitUpdate(vo.getNoticeId());
		model.addAttribute("content", noticeDao.noticeSelect(vo));
		return "notice/noticeContent";
	}
	
	@RequestMapping("/downLoad.do")
	public void downLoad(@RequestParam("saveName")String saveName, 
			@RequestParam("fileName")String fileName,
			HttpServletResponse resp) {
		//file을 배열로 전환
		try {
			byte fileByte[] = org.apache.commons.io.FileUtils.readFileToByteArray(
					new File(saveDir + File.separator + saveName));
			//모든 타입의 데이터를 전송할 때 사용
			resp.setContentType("application/octet-stream");
			// 파일 길이만큼 사이즈 설정
			resp.setContentLength(fileByte.length);
			// 파일을 다운 받기위해 설정
			resp.setHeader("Content-Disposition", 
					"attachment; filename=\""
					+URLEncoder.encode(fileName, "UTF-8") + "\";");
			
			resp.getOutputStream().write(fileByte);
			resp.getOutputStream().flush();
			resp.getOutputStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/noticeDelete.do")
	public String noticeDelete(NoticeVO vo) {
		noticeDao.noticeDelete(vo);
		return "redirect:noticeList.do";
	}
	
	@RequestMapping("/noticeModifyForm.do")
	public String noticeModifyForm(NoticeVO vo, Model model) {
		model.addAttribute("notice", noticeDao.noticeSelect(vo));
		return "notice/noticeModifyForm";
	}
	
	@PostMapping("/noticeModify.do")
	public String noticeModify(NoticeVO vo, MultipartFile file) {
		
		String fileName = file.getOriginalFilename();
		
//		vo.setNoticeAttach("");
//		vo.setNoticeDir("");
		if(fileName != null && !fileName.isEmpty() && fileName.length() != 0) {
			
			// uuid(범용 고유 식별자) 사용하여 파일 명 변경
			String uid = UUID.randomUUID().toString();
			String saveFileName = uid + fileName.substring(fileName.indexOf("."));
			
			File target = new File(saveDir, saveFileName);
			vo.setNoticeAttach(fileName); // 파일명
			vo.setNoticeDir(saveFileName); //실제저장경로
			try {
				FileCopyUtils.copy(file.getBytes(), target);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		noticeDao.noticeUpdate(vo);
		
		return "redirect:noticeList.do";
	}
}













