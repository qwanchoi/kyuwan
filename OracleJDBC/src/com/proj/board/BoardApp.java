package com.proj.board;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BoardApp {

	List<Board> list = new ArrayList<Board>();
	Scanner scn = new Scanner(System.in);
	BoardService service = new BoardServiceOracle();

	//
	int currentPage = 1;
	int pageSize = 5;
	
	Board curBoard = null;

	public void execute() {
		getAllBoardList();
		showBoardList(currentPage, pageSize);
	}

	private void showBoardInsertForm() {
		list = service.boardList();

		int bno = service.getLastBoardNumber() + 1;
		String date = getNowDate();

		Board board = new Board();
		board.setNo(bno);
		board.setDate(date);
		board.setModDate(date);
		board.setLike(0);
		board.setParent(0);
		board.setHit(0);

		scn.nextLine();
		System.out.print("제목>> ");
		board.setTitle(scn.nextLine());
		System.out.print("내용>> ");
		board.setContent(scn.nextLine());
		System.out.print("글쓴이>> ");
		board.setWriter(scn.nextLine());
		System.out.print("암호>> ");
		board.setPassword(scn.next());

		if (service.insertBoard(board)) {
			System.out.println("!!! 게시 성공 !!!");
		} else {
			System.out.println("!!! 게시 실패 !!!");
		}
		getAllBoardList();
		showBoardList(currentPage, pageSize);
	} // end of insert
	
	private void showBoardCommInsertForm() {
		list = service.boardList();

		int bno = service.getLastBoardNumber() + 1;
		String date = getNowDate();

		Board board = new Board();
		board.setNo(bno);
		board.setDate(date);
		board.setModDate(date);
		board.setLike(0);
		board.setParent(curBoard.getNo());
		board.setHit(0);

		scn.nextLine();
		System.out.print("내용>> ");
		board.setContent(scn.nextLine());
		System.out.print("글쓴이>> ");
		board.setWriter(scn.nextLine());
		System.out.println("암호>> ");
		board.setPassword(scn.next());

		if (service.insertBoard(board)) {
			System.out.println("게시 성공");
		} else {
			System.out.println("게시 실패");
		}
		showBoard(curBoard.getNo());
	} // end of comm insert
	
	private void showBoardList(int page, int size) {
		int start = (page - 1) * size;
		int max = start + size;

		if (max > list.size())
			max = list.size();

		System.out.println(" + ========== ========== ========== ========== ========== +++ 게시판 +++ ========== ========== ========== ========== ========== +");
		System.out.println("||    NO " // 7s
				+ "||                     TITLE                     " // 45s
				+ "||         WRITER        " // 21s
				+ "||   DATE   " + "||   LIKES  " // 10s
				+ "||   HITS   " // 10d
				+ "||  COM  " // 7s
				+ "||"); // 10s
		for (int i = start; i < max; i++) {
			Board b = list.get(i);
			if (b == null)
				break;
			int childNum = service.getChildBoard(b.getNo()).size();
			System.out.printf(b.showList(), b.getNo(), boardFormmater(45, b.getTitle()),
					boardFormmater(21, b.getWriter()), b.getDate().substring(0, 10), b.getLike(), b.getHit(), childNum);
		}
		System.out.println(" + ========== ========== ========== ========== ========== +++ ++++++ +++ ========== ========== ========== ========== ========== +");
		showBoardPaging();
		System.out.println();
		showBoardListMenu();

	} // end of list
	
	
	private void showBoardPaging() {
		int listSize = list.size();
		int maxPage = listSize / this.pageSize;
		if(listSize % this.pageSize != 0) maxPage+=1;
		String str = "| ";
		for(int i = 1; i <= maxPage; i++) {
			if(i == currentPage) {
				String temp = "["+i+"]";
				str += String.format("%6s", temp);
			} else {
				str += String.format("%5d ", i);				
			}
		}
		str += "    |";
		System.out.println(str);
	}
	
	private void getAllBoardList() {
		list = service.boardList();
	}
	
	private void getSearchBoardList(String keyword) {
		list = service.searchBoard(keyword);
	}

	private void showBoardListMenu() {
		System.out.println("* 게시물 번호 입력 | 글쓰기(w) |"
				+ " 이전페이지(q) | 다음페이지(e) | 전체리스트(a) | 제목 검색(s) |"
				+ " 종료(z) ");
		System.out.print(">>");
		String menu = scn.next();
		if (isNumeric(menu)) {
			int bno = Integer.parseInt(menu);
			showBoard(bno);
			showBoardListMenu();
		} else if (menu.equals("a") || menu.equals("A") || menu.equals("ㅁ")) {
			getAllBoardList();
			currentPage = 1;
			showBoardList(currentPage, pageSize);
		} else if (menu.equals("w") || menu.equals("W") || menu.equals("ㅈ") || menu.equals("ㅉ")) {
			showBoardInsertForm();
		} else if (menu.equals("q") || menu.equals("Q") || menu.equals("ㅂ") || menu.equals("ㅃ")) {
			prevPaging();
		} else if (menu.equals("e") || menu.equals("E") || menu.equals("ㄷ") || menu.equals("ㄸ")) {
			nextPaging();
		} else if (menu.equals("s") || menu.equals("S") || menu.equals("ㄴ")) {
			System.out.print("검색어 >>");
			scn.nextLine();
			String keyword = scn.nextLine();
			
			getSearchBoardList(keyword);
			currentPage = 1;
			showBoardList(currentPage, pageSize);
		} else if (menu.equals("z") || menu.equals("Z") || menu.equals("ㅋ")) {
			System.out.println("프로그램 종료...");
		} else {
			System.out.println("!! 없는 메뉴 !!");
			showBoardListMenu();
		}
	} // end of listmenu
	
	private void showBoard(int bno) {
		Board board = service.getBoard(bno);
		if(board == null || board.getParent() >= 1) {
			System.out.println("!!없는 게시번호 입니다!!");
			return;
		}
		curBoard = board;
		service.hitBoard(bno);
		board.setHit(board.getHit()+1);
		
		String str = "========== ========== ========== ========== ========== ========== =========="
				+ " ========== ========== ========== ========== ========== ========== ==========\n";
		str += String.format("|| +NO : %7d", board.getNo());
		str += " || "+boardFormmater(75, board.getTitle());
		str += " || "+boardFormmater(21, board.getWriter());
		str += " || "+board.getDate().substring(0, 10);
		str += " || +HITS | "+boardFormmater(10, Integer.toString(board.getHit())) + "||";
		str += "\n";
		str += "|| +CONTENTS | "+board.getContent();
		str += "\n";
		str += "|| +LIKES♡ : "+boardFormmater(board.getLike(), Integer.toString(board.getLike()));
		System.out.println(str);
		List<Board> comments = service.getChildBoard(board.getNo());
		
		System.out.printf(" ㄴ========== 댓글(%d) ========== ========== ========== ========== ========== ========== ========== \n", comments.size());
		if (comments.size() < 1) {
			System.out.println( "  | 댓글이 없습니다. 첫 댓글을 달아주세요! |" );
		}
		
		for(Board b : comments) {
			str = " ++ | -NO : "+String.format("%5d", b.getNo());
			str += " || -WRITER : "+boardFormmater(15, b.getWriter());
			str += " || -DATE : "+b.getDate().substring(0, 10);
			str += " || -COMMENT : "+b.getContent();
			System.out.println(str);
		}
		showBoardMenu();
	}
	
	private void showBoardMenu() {
		String str = "* 좋아요(q) | 댓글쓰기(e) | 목록으로(l) | 수정하기(w) | 삭제하기(d) | 댓글삭제하기(f)";
		System.out.println(str);
		System.out.print(">>");
		
		String menu = scn.next();
		if (menu.equals("w") || menu.equals("W") || menu.equals("ㅈ") || menu.equals("ㅉ")) {
			showModifyBoard();
		} else if (menu.equals("q") || menu.equals("Q") || menu.equals("ㅂ") || menu.equals("ㅃ")) {
			service.likeBoard(curBoard.getNo());
			showBoard(curBoard.getNo());
		} else if (menu.equals("e") || menu.equals("E") || menu.equals("ㄷ") || menu.equals("ㄸ")) {
			showBoardCommInsertForm();
		} else if (menu.equals("l") || menu.equals("L") || menu.equals("ㅣ")) {
			getAllBoardList();
			showBoardList(currentPage, pageSize);
		} else if (menu.equals("d") || menu.equals("D") || menu.equals("ㅇ")) {
			deleteBoard();
		} else if (menu.equals("f") || menu.equals("F") || menu.equals("ㄹ")) {
			showDeleteComment();
		} else {
			System.out.println("!! 없는 메뉴 !!");
			showBoard(curBoard.getNo());
		}
	}
	
	private void showDeleteComment() {
		System.out.println("* 삭제할 코멘트 번호를 입력하세요.");
		System.out.print(">>");
		int bno = scn.nextInt();
		if(checkBoardPassword(bno)) {
			service.removeBoard(bno);
			System.out.println("삭제 성공");
			showBoard(curBoard.getNo());
		} else {
			System.out.println("삭제 실패");
			showBoard(curBoard.getNo());
		}
	}
	
	private void showModifyBoard() {
		int bno = curBoard.getNo();
		if(checkBoardPassword(bno)) {
			String date = getNowDate();

			Board board = new Board();
			board.setNo(bno);
			board.setDate(curBoard.getDate());
			board.setModDate(date);
			board.setLike(curBoard.getLike());
			board.setParent(curBoard.getNo());
			board.setHit(curBoard.getHit());

			scn.nextLine();
			System.out.println("이전 제목: "+curBoard.getTitle());
			System.out.print("제목>> ");
			board.setTitle(scn.nextLine());
			System.out.println("이전 내용: "+curBoard.getContent());
			System.out.print("내용>> ");
			board.setContent(scn.nextLine());
			
			board.setWriter(curBoard.getWriter());
			board.setPassword(curBoard.getPassword());
			
			if (service.modifyBoard(board)) {
				System.out.println("수정 성공");
			} else {
				System.out.println("수정 실패");
			}
			
		}
		showBoard(bno);
		
	}
	
	private void deleteBoard() {
		int bno = curBoard.getNo();
		if(checkBoardPassword(bno)) {
			service.removeBoard(bno);
			System.out.println("삭제 성공");
			getAllBoardList();
			showBoardList(currentPage, pageSize);
		} else {
			System.out.println("삭제 실패");
			showBoard(curBoard.getNo());
		}
		
	}
	
	private boolean checkBoardPassword(int bno) {
		System.out.println("비밀번호를 입력해 주세요 >>");
		String pass = scn.next();
		Board board = null;
		board = service.getBoard(bno);
		
		if(board != null) {
			if ( board.getParent() < 1 ) {
				return false;
			}
			if(board.getPassword().equals(pass)) {
				return true;
			}
		}
		
		return false;
	}
	
	private void nextPaging() {
		int listSize = list.size();
		int maxPage = listSize / this.pageSize;
		if(listSize % this.pageSize != 0) maxPage++;
		
		if(currentPage < maxPage) {
			currentPage++;
		}
		showBoardList(currentPage, pageSize);
	}
	
	private void prevPaging() {
		if(currentPage > 1) {
			currentPage--;
		}
		showBoardList(currentPage, pageSize);
	}
	

	private String getNowDate() {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		String date = sdf.format(today);
		return date;
	}

	private String boardFormmater(int limit, String str) {
		String mStr = "";
		String result = "";
		if (str == null)
			mStr = "";
		else
			mStr = str;

		byte[] bArr = null;
		try {
			bArr = mStr.getBytes("EUC-KR");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// 짭ㄹ은 경우
		result = mStr;
		for (int i = 0; i < limit - bArr.length; i++) {
			result += " ";
		} 
		
		// 긴 경우
		if( bArr.length > limit ) {
			for(int i = 1; i < mStr.length(); i++) {
				try {
					bArr = mStr.substring(0, i).getBytes("EUC-KR");
					if(bArr.length == limit-2) {
						result = mStr.substring(0, i);
						result += "..";
						break;
					} else if(bArr.length > limit-2) {
						result = mStr.substring(0, i-1);
						result += ".. ";
						break;
					}
				} catch ( UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	private boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
