package jsp.board.comment.model;

import java.sql.Date;

public class CommentBean {
	private int commentNum;
	private int boardNum;
	private String commentID;
	private String commentCnt;
	private Date commentDate;
	
	public int getCommentNum() {
		return commentNum;
	}
	
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	
	public int getBoardNum() {
		return boardNum;
	}
	
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	
	public String getCommentID() {
		return commentID;
	}
	
	public void setCommentID(String commentID) {
		this.commentID = commentID;
	}
	
	public String getCommentCnt() {
		return commentCnt;
	}
	
	public void setCommentCnt(String commentCnt) {
		this.commentCnt = commentCnt;
	}
	
	public Date getCommentDate() {
		return commentDate;
	}
	
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	
	@Override
	public String toString() {
		return "CommentBean [commentNum=" + commentNum + ", boardNum=" + boardNum + ", commentID=" + commentID
				+ ", commentCnt=" + commentCnt + ", commentDate=" + commentDate + "]";
	}

}
