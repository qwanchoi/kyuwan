package com.proj.board;

import java.util.List;

public interface BoardService {
    public boolean insertBoard(Board board);
    public Board getBoard(int bno);
    public List<Board> boardList();
    public int boardLength();
    public boolean modifyBoard(Board board);
    public boolean removeBoard(int bno);
    public List<Board> searchBoard(String keyword);
    
    public boolean likeBoard(int bno);
    public List<Board> getChildBoard(int parentNo);
    public boolean hitBoard(int bno);
    public int getLastBoardNumber();
}
