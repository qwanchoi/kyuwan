package co.dev.service;

import java.util.List;

import co.dev.dao.MemberDAO;
import co.dev.vo.MemberVO;

public class MemberService {
    MemberDAO dao = new MemberDAO(); // db CRUD작업.
    
    public void memberInsert(MemberVO member) {
	dao.insertMember(member);
    }

    public List<MemberVO> memberList() {
	return dao.listMember();
    }
}
