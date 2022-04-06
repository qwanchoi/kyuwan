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
	    System.out.println(board);
	    System.out.println(sql);
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
		+ "WHERE b_parent IS NULL "
		+ "OR b_parent < 1 "
		+ "ORDER BY b_no DESC ";
	
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
	    System.out.println(sql);
	    System.out.println("!!게시판 목록 불러오기 실패!!");
	} finally {
	    disconnect();
	}
	
	return list;
    }

    @Override
    public boolean modifyBoard(Board board) {
    	conn = this.getConnect();
    	String sql = "UPDATE board_table "
    			+ "SET b_title = ? "
    			+ ", b_content = ? "
    			+ "WHERE b_no = ? ";
    	try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, board.getTitle());
	    	psmt.setString(2, board.getContent());
	    	psmt.setInt(3,  board.getNo());
	    	int r = psmt.executeUpdate();
	    	if( r > 0 ) { return true; }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
    	return false;
    }

    @Override
    public boolean removeBoard(int bno) {
    	conn = getConnect();
    	String sql = "DELETE FROM board_table "
    			+ "WHERE b_no = ?";
    	try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bno);
			
			int r = psmt.executeUpdate();
			if( r > 0 ) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
    	return false;
    }

    @Override
    public List<Board> searchBoard(String keyword) {
    	List<Board> list = new ArrayList<Board>();
    	conn = getConnect();
    	String sql = "SELECT * FROM board_table "
    		+ "WHERE (b_parent IS NULL "
    		+ "OR b_parent < 1) "
    		+ "AND b_title LIKE '%'||?||'%' "
    		+ "ORDER BY b_no DESC ";
    	
    	try {
    	    psmt = conn.prepareStatement(sql);
    	    psmt.setString(1, keyword);
    	    
    	    rs = psmt.executeQuery();
    	    while( rs.next() ) {
	    		Board board = new Board();
	    		this.rsToBoard(rs, board);
	    		list.add(board);
    	    }
    	} catch (SQLException e) {
    	    e.printStackTrace();
    	    System.out.println(sql);
    	    System.out.println("!!게시판 목록 불러오기 실패!!");
    	} finally {
    	    disconnect();
    	}
    	
    	return list;
    }

    @Override
    public boolean likeBoard(int bno) {
    	Board board = this.getBoard(bno);
    	
    	conn = getConnect();
    	String sql = "UPDATE board_table "
    			+ "SET b_like = ? "
    			+ "WHERE b_no = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, board.getLike()+1);
			psmt.setInt(2, board.getNo());
			
			int r = psmt.executeUpdate();
			if(r > 0) { return true; }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
    	return false;
    }

    @Override
    public List<Board> getChildBoard(int parentNo) {
	List<Board> list = new ArrayList<Board>();
	conn = getConnect();
	String sql = "SELECT * FROM board_table "
		+ "WHERE b_parent = ? "
		+ "ORDER BY b_no DESC";
	try {
	    psmt = conn.prepareStatement(sql);
	    psmt.setInt(1, parentNo);
	    
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
    	Board board = this.getBoard(bno);
    	
    	conn = getConnect();
    	String sql = "UPDATE board_table "
    			+ "SET b_hit = ? "
    			+ "WHERE b_no = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, board.getHit()+1);
			psmt.setInt(2, board.getNo());
			
			int r = psmt.executeUpdate();
			if(r > 0) { return true; }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
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

    @Override
    public int getLastBoardNumber() {
	conn = getConnect();
	int number = 0;
	
	String sql = "SELECT MAX(b_no) FROM board_table";
	try {
	    psmt = conn.prepareStatement(sql);
	    
	    rs = psmt.executeQuery();
	    if(rs.next()) {
		number = rs.getInt("MAX(b_no)");
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    disconnect();
	}
	
	return number;
    }

    @Override
    public int boardLength() {
	conn = getConnect();
	int number = 0;
	
	String sql = "SELECT COUNT(b_no) FROM board_table";
	try {
	    psmt = conn.prepareStatement(sql);
	    
	    rs = psmt.executeQuery();
	    if(rs.next()) {
		number = rs.getInt("MAX(b_no)");
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    disconnect();
	}
	
	return number;
    }

}
