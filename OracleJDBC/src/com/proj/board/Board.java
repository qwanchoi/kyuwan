package com.proj.board;

public class Board {
    private int no;
    private String title;
    private String content;
    private String writer;
    private String password;
    private String date;
    private String modDate;
    private int like;
    private int parent;
    private int hit;
    
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getModDate() {
        return modDate;
    }
    public void setModDate(String modDate) {
        this.modDate = modDate;
    }
    public int getLike() {
        return like;
    }
    public void setLike(int like) {
        this.like = like;
    }
    public int getParent() {
        return parent;
    }
    public void setParent(int parent) {
        this.parent = parent;
    }
    public int getHit() {
        return hit;
    }
    public void setHit(int hit) {
        this.hit = hit;
    }
    
    @Override
    public String toString() {
	return "Board [no=" + no + ", title=" + title + ", content=" + content + ", writer=" + writer + ", password="
		+ password + ", date=" + date + ", modDate=" + modDate + ", like=" + like + ", parent=" + parent
		+ ", hit=" + hit + "]";
    }
    
    public String showList() {
	String str = "";
	// |no| title | writer | mod_date | like | hit |
	str = "||%5d|		%s		|	%s	|	%s	| %4s | %10s ||";
	return str;
    }
    
}
