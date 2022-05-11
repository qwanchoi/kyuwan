package co.test.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.test.vo.BookVO;

public class BookDAO extends DAO {

	public List<BookVO> bookList() {
	    List<BookVO> list = new ArrayList<BookVO>();
	    
	    conn();
	    String sql = "SELECT * FROM book_info ORDER BY 1";
	    try {
		psmt = conn.prepareStatement(sql);
		rs = psmt.executeQuery();
		while(rs.next()) {
		    BookVO vo = new BookVO(
			    rs.getString("book_code"),
			    rs.getString("book_title"),
			    rs.getString("book_author"),
			    rs.getString("book_press"),
			    rs.getInt("book_price"));
		    list.add(vo);
		}
	    } catch (SQLException e) {
		e.printStackTrace();
	    } finally {
		disconn();
	    }
	    
	    return list;
	}

	public BookVO selectBook(String bookCode) {
	    conn();
	    String sql = "SELECT * FROM book_info WHERE book_code = ?";
	    BookVO vo = new BookVO();
	    
	    try {
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, bookCode);
		rs = psmt.executeQuery();
		if(rs.next()) {
		    vo.setBookCode(rs.getString("book_code"));
		    vo.setBookTitle(rs.getString("book_title"));
		    vo.setBookAuthor(rs.getString("book_author"));
		    vo.setBookPress(rs.getString("book_press"));
		    vo.setBookPrice(rs.getInt("book_price"));
		}
	    } catch (SQLException e) {
		e.printStackTrace();
	    } finally {
		disconn();
	    }

	    return vo;
	}

	public void insertBook(BookVO book) {
	    conn();
	    String sql = "INSERT INTO book_info "
	    	+ "(book_code, book_title, book_author, book_press, book_price) "
	    	+ "VALUES "
	    	+ "(create_bookcode, ?, ?, ?, ? )";
	    
	    try {
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, book.getBookTitle());
		psmt.setString(2, book.getBookAuthor());
		psmt.setString(3, book.getBookPress());
		psmt.setInt(4, book.getBookPrice());
		int r = psmt.executeUpdate();
		
		System.out.println(r + "건 등록.");
		    
	    } catch (SQLException e) {
		e.printStackTrace();
	    } finally {
		disconn();
	    }
	}

	public void updateBook(BookVO book) {
	    conn();
	    String sql = "UPDATE book_info SET "
	    	+ "book_title = ?, "
	    	+ "book_author = ?, "
	    	+ "book_press = ?, "
	    	+ "book_price = ? "
	    	+ "WHERE book_code = ?";
	    
	    try {
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, book.getBookTitle());
		psmt.setString(2, book.getBookAuthor());
		psmt.setString(3, book.getBookPress());
		psmt.setInt(4, book.getBookPrice());
		psmt.setString(5, book.getBookCode());
		
		int r = psmt.executeUpdate();
		System.out.println(r + "건 업데이트.");
	    } catch (SQLException e) {
		e.printStackTrace();
	    } finally {
		disconn();
	    }
	    
	}

	public void deleteBook(String bookCode) {
	    conn();
	    String sql = "DELETE FROM book_info WHERE book_code = ?";
	    
	    try {
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, bookCode);
		int r = psmt.executeUpdate();
		System.out.println(r + "건 삭제.");
	    } catch (SQLException e) {
		e.printStackTrace();
	    } finally {
		disconn();
	    }
	}
}
