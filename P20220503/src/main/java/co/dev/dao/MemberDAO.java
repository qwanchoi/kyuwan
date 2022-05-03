package co.dev.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.dev.DAO;
import co.dev.vo.MemberVO;

public class MemberDAO extends DAO {
    
    public List<MemberVO> listMember() {
	conn = getConnect();
	List<MemberVO> list = new ArrayList<MemberVO>();
	String sql = "SELECT * FROM member ORDER BY id";
	try {
	    psmt = conn.prepareStatement(sql);
	    rs = psmt.executeQuery();
	    while(rs.next()) {
		MemberVO vo = new MemberVO();
		vo.setId(rs.getString("id"));
		vo.setPasswd(rs.getString("passwd"));
		vo.setName(rs.getString("name"));
		vo.setEmail(rs.getString("email"));
		list.add(vo);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    disconnect();
	}	
	return list;
    }
    
    public void insertMember(MemberVO member) {
	conn = getConnect();
	String sql = "INSERT INTO member(id, name, passwd, email) VALUES(?, ?, ?, ?)";
	
	try {
	    psmt = conn.prepareStatement(sql);
	    psmt.setString(1, member.getId());
	    psmt.setString(2, member.getName());
	    psmt.setString(3, member.getPasswd());
	    psmt.setString(4, member.getEmail());
	    
	    int r = psmt.executeUpdate();
	    System.out.println(r + "건 입력.");
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    disconnect();
	}
    }
    
}
