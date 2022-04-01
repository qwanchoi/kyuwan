package com.proj.board;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BoardApp {
    
    List<Board> list = new ArrayList<Board>();
    Scanner scn = new Scanner(System.in);
    BoardService service = new BoardServiceOracle();
    
    // 
    int currentPage = 1;
    int pageSize = 10;
    
    public void execute() {
	
	while(true) {
	    System.out.println("1.추가 2.리스트 3.조회 9.종료");
	    System.out.print("선택>> ");
	    int menu = scn.nextInt();
	    if( menu == 1 ) { // 추가
		showBoardInsertMenu();
	    } else if ( menu == 2 ) { // 리스트
		showBoardList(currentPage, pageSize);
	    } else if ( menu == 3) { // 조회
		
	    } else if ( menu == 9 ) { // 종료
		System.out.println("프로그램을 종료합니다.");
		break;
	    } else {
		
	    }
	}
    }
    
    private void showBoardInsertMenu() {
	List<Board> list = service.boardList();
	
	int bno = service.getLastBoardNumber()+1;
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
	System.out.println("암호>> ");
	board.setPassword(scn.next());
	
	if(service.insertBoard(board)) {
	    System.out.println("게시 성공");
	} else {
	    System.out.println("게시 실패");
	};
    } // end of insert
    
    private void showBoardList(int page, int size) {
	List<Board> list = service.boardList();
	int start = page * size;
	int max = start + size;
	
	if( max > list.size()) max = list.size();
	
	System.out.println("========== 게시물 리스트 ==========");
	System.out.println("||     NO" // 7s
		+ "||                     TITLE                     " // 45s
		+ "||         WRITER       " // 20s
		+ "||   DATE   "
		+ "||   LIKES  " // 10s
		+ "||   HITS   " // 10d
		+ "||  COM  " // 7s
		+ "||"); // 10s
	for(int i = start; i < max; i++) {
	    Board b = list.get(i);
	    if(b == null) break;
	    int childNum = service.getChildBoard(b.getNo()).size();
	    System.out.printf(
		    b.showList(), 
		    b.getNo(),
		    boardFormmater(45, b.getTitle()),
		    boardFormmater(20, b.getWriter()),
		    b.getDate().substring(0, 10),
		    b.getLike(),
		    b.getHit(),
		    childNum
	    );
	}
	showBoardListMenu();
	
    } // end of list
    
    private void showBoardListMenu() {
	System.out.println("|| 게시물 번호 입력 | 글쓰기(w) | 이전페이지(q) | 다음페이지(e)");
	System.out.print(">>");
	String menu = scn.next();
	if ( !isNumeric(menu) ) {
	    int bno = Integer.parseInt(menu);
	} else if( menu.equals("w") || menu.equals("W")) {
	    
	} else if(menu.equals("q") || menu.equals("Q")) {
	    
	} else if(menu.equals("e") || menu.equals("E")) {
	    
	} else {
	    System.out.println("!! 없는 메뉴 !!");
	}
    }
    
    private String getNowDate() {
	Date today = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
	String date = sdf.format(today);
	return date;
    }
    
    private String boardFormmater(int limit, String str) {
	String mStr = "";
	if(str == null) mStr = "";
	else mStr = str;
	
	byte[] bArr = null;
	try {
	    bArr = mStr.getBytes("EUC-KR");
	} catch (UnsupportedEncodingException e) {
	    e.printStackTrace();
	}
	String temp = mStr;
	for(int i = 0; i < limit-bArr.length; i++) {
	    temp += " ";
	}
	
	return temp;
    }
    
    private boolean isNumeric(String str) {
	try {
	    Double.parseDouble(str);
	    return true;
	} catch (NumberFormatException e) {
	    return false;
	}
    }
    
}
