package co.test.service;

import java.util.List;

import co.test.dao.BookDAO;
import co.test.vo.BookVO;

public class BookService {

	BookDAO dao;

	public BookService() {
		dao = new BookDAO();
	}

	// 목록
	public List<BookVO> bookList() {
		return dao.bookList();
	}

	// 단건조회
	public BookVO findBook(String bookCode) {
		return dao.selectBook(bookCode);
	}

	// 수정
	public void modifyBook(BookVO book) {
		dao.updateBook(book);
	}

	// 삭제
	public void removeBook(String bookCode) {
		dao.deleteBook(bookCode);
	}

	// 입력
	public void addBook(BookVO book) {
		dao.insertBook(book);
	}

}
