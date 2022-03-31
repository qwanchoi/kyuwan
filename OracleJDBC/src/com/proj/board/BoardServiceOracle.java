package com.proj.board;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardServiceOracle extends DAO implements BoardService {
    
    @Override
    public boolean insertBoard(Board board) {
	conn = getConnect();
	String sql = "INSERT INTO board_table "
		+ "(b_no, "
		+ "b_title, "
		+ "b_content, "
		+ "b_writer, "
		+ "b_password, "
		+ "b_date, "
		+ "b_mod_date, "
		+ "b_like, "
		+ "b_parent, "
		+ "b_hit) "
		+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
	
	try {
	    psmt = conn.prepareStatement(sql);
	    this.boardToPsmt(board, psmt);
	    
	    int r = psmt.executeUpdate();
	    System.out.println(r + "건 완료");
	    if ( r > 0 ) return true;
	} catch (SQLException e) {
	    e.printStackTrace();
	    System.out.println("!!! 입력 실패 !!!");
	} finally {
	    disconnect();
	}
	return false;
    }

    @Override
    public Board getBoard(int bno) {
	conn = getConnect();
	Board board = null;
	
	String sql = "SELECT * FROM board_table "
		+ "WHERE b_no = ?";
	
	try {
	    psmt = conn.prepareStatement(sql);
	    psmt.setInt(1, bno);
	    
	    rs = psmt.executeQuery();
	    if( rs.next() ) {
		board = new Board();
		this.rsToBoard(rs, board);
		return board;
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    disconnect();
	}
	return null;
    }

    @Override
    public List<Board> boardList() {
	List<Board> list = new ArrayList<Board>();
	conn = getConnect();
	String sql = "SELECT * FROM board_table "
		+ "ORDER BY b_no DESC";
	
	try {
	    psmt = conn.prepareStatement(sql);
	    rs = psmt.executeQuery();
	    while( rs.next() ) {
		Board board = new Board();
		this.rsToBoard(rs, board);
		list.add(board);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	    System.out.println("!!게시판 목록 불러오기 실패!!");
	} finally {
	    disconnect();
	}
	
	return list;
    }

    @Override
    public boolean modifyBoard(Board board) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean removeBoard(int bno) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public List<Board> searchBoard(String keyword) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public boolean likeBoard(int bno) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean insertReplyBoard(Board board) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public List<Board> getChildBoard(int parentNo) {
	List<Board> list = new ArrayList<Board>();
	conn = getConnect();
	String sql = "SELECT * FROM board_table"
		+ "WHERE b_parent = ? "
		+ "ORDER BY DESC ";
	
	try {
	    psmt = conn.prepareStatement(sql);
	    rs = psmt.executeQuery();
	    while(rs.next()) {
		Board board = new Board();
		this.rsToBoard(rs, board);
		
		list.add(board);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    disconnect();
	}
	
	return list;
    }

    @Override
    public boolean hitBoard(int bno) {
	return false;
    }
    
    private void rsToBoard(ResultSet rs, Board board) throws SQLException {
	board.setNo(rs.getInt("b_no"));
	board.setTitle(rs.getString("b_title"));
	board.setContent(rs.getString("b_content"));
	board.setWriter(rs.getString("b_writer"));
	board.setPassword(rs.getString("b_password"));
	board.setDate(rs.getString("b_date"));
	board.setModDate(rs.getString("b_mod_date"));
	board.setLike(rs.getInt("b_like"));
	board.setParent(rs.getInt("b_parent"));
	board.setHit(rs.getInt("b_hit"));
    }
    
    private void boardToPsmt(Board board, PreparedStatement psmt) throws SQLException {
	psmt.setInt(1, board.getNo());
	psmt.setString(2, board.getTitle());
	psmt.setString(3, board.getContent());
	psmt.setString(4, board.getWriter());
	psmt.setString(5, board.getPassword());
	psmt.setString(6, board.getDate());
	psmt.setString(7, board.getModDate());
	psmt.setInt(8, board.getLike());
	psmt.setInt(9, board.getParent());
	psmt.setInt(10, board.getHit());
    }

}
