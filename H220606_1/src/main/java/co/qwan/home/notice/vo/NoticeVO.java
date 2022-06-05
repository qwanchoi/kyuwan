package co.qwan.home.notice.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeVO {
	private int id;
	private String name;
	private String password;
	private String title;
	private String contents;
	private Date createdAt;
}
