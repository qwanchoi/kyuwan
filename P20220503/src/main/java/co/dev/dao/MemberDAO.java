package co.dev.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.dev.DAO;
import co.dev.vo.MemberVO;

public class MemberDAO extends DAO {
    
    public boolean updateMember(MemberVO vo) {
	conn = getConnect();
	String sql = "UPDATE member SET name=?, passwd=?, email=? WHERE id=?";
	
	try {
	    psmt = conn.prepareStatement(sql);
	    psmt.setString(1, vo.getName());
	    psmt.setString(2, vo.getPasswd());
	    psmt.setString(3, vo.getEmail());
	    psmt.setString(4, vo.getId());
	    int r = psmt.executeUpdate();
	    if(r > 0) {
		return true;
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    disconnect();
	}
	return false;
    }
    
    public boolean deleteMember(String id) {
	conn = getConnect();
	String sql = "DELETE FROM member WHERE id=?";
	
	try {
	    psmt = conn.prepareStatement(sql);
	    psmt.setString(1, id);
	    int r = psmt.executeUpdate();
	    if( r > 0 ) {
		return true;
	    }
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    disconnect();
	}
	return false;
    }
    
    public MemberVO searchMember(String id) {
	conn = getConnect();
	String sql = "SELECT * FROM member WHERE id=?";
	try {
	    psmt = conn.prepareStatement(sql);
	    psmt.setString(1, id);
	    rs = psmt.executeQuery();
	    if(rs.next()) {
		MemberVO vo = new MemberVO();
		vo.setId(rs.getString("id"));
		vo.setName(rs.getString("name"));
		vo.setEmail(rs.getString("email"));
		vo.setPasswd(rs.getString("passwd"));
		return vo;
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    disconnect();
	}
	return null;
    }
    
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
		vo.setProfile(rs.getString("profile"));
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
	String sql = "INSERT INTO member(id, name, passwd, email, profile) VALUES(?, ?, ?, ?, ?)";
	
	try {
	    psmt = conn.prepareStatement(sql);
	    psmt.setString(1, member.getId());
	    psmt.setString(2, member.getName());
	    psmt.setString(3, member.getPasswd());
	    psmt.setString(4, member.getEmail());
	    psmt.setString(5, member.getProfile());
	    
	    int r = psmt.executeUpdate();
	    System.out.println(r + "건 입력.");
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    disconnect();
	}
    }
    
}
