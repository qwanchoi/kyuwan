package co.dev.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberUpdateControl implements Control {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
	System.out.println("수정처리하는 컨트롤입니다.");
    }

}
