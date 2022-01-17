package jsp.board.model;

import java.sql.Date;

public class BoardBean {
	private int boardNum;
	private String boardID;
	private String boardSubject;
	private String boardContent;
	private String boardFile;
	private int boardCount;
	private Date boardDate;
	

	public int getBoardNum() {
		return boardNum;
	}
	
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	
	public String getBoardID() {
		return boardID;
	}
	
	public void setBoardID(String boardID) {
		this.boardID = boardID;
	}
	
	public String getBoardSubject() {
		return boardSubject;
	}
	
	public void setBoardSubject(String boardSubject) {
		this.boardSubject = boardSubject;
	}
	
	public String getBoardContent() {
		return boardContent;
	}
	
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	
	public String getBoardFile() {
		return boardFile;
	}
	
	public void setBoardFile(String boardFile) {
		this.boardFile = boardFile;
	}
	
	public int getBoardCount() {
		return boardCount;
	}
	
	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}
	
	public Date getBoardDate() {
		return boardDate;
	}
	
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	
	@Override
	public String toString() {
		return "BoardDAO [boardNum=" + boardNum + ", boardID=" + boardID + ", boardSubject=" + boardSubject
				+ ", boardContent=" + boardContent + ", boardFile=" + boardFile + ", boardCount=" + boardCount
				+ ", boardDate=" + boardDate + "]";
	}
	

}