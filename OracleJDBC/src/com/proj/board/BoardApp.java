package com.proj.board;

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
    
    public void execute() {
	
	while(true) {
	    System.out.println("1.추가 2.리스트 3.조회");
	    System.out.print("선택>> ");
	    int menu = scn.nextInt();
	    if( menu == 1 ) { // 추가
		showBoardInsertMenu();
	    } else if ( menu == 2 ) { // 리스트
		showBoardList();
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
	
	int bno = 1;
	if ( list.size() > 0 ) {
	    bno = list.get(list.size()-1).getNo()+1;
	}
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
	board.setWriter(scn.next());
	System.out.println("암호>> ");
	board.setPassword(scn.next());
	
	if(service.insertBoard(board)) {
	    System.out.println("게시 성공");
	} else {
	    System.out.println("게시 실패");
	};
    } // end of insert
    
    private void showBoardList() {
	List<Board> list = service.boardList();
	System.out.println("========== 게시물 리스트 ==========");
	System.out.println("||   NO"
		+ "|		TITLE		"
		+ "|	WRITER	"
		+ "|    DATE    "
		+ "| LIKES"
		+ "|     HITS   ||");
	for (Board b : list) {
	    System.out.printf(b.showList(), 
		    b.getNo(),
		    b.getTitle(),
		    b.getWriter(),
		    b.getDate().substring(0, 10),
		    b.getLike(),
		    b.getHit());
	}
    } // end of list
    
    private String getNowDate() {
	Date today = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
	String date = sdf.format(today);
	return date;
    }
}
