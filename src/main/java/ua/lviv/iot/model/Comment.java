package ua.lviv.iot.model;

public class Comment {
  private int commentId;
  private int answerId;
  private int postId;
  private int userId;
  private String text;

    public Comment() {

	}

	public Comment(int commentId, int answerId, int postId, int userId, String text) {
		this.commentId = commentId;
		this.answerId = answerId;
		this.postId = postId;
		this.userId = userId;
		this.text = text;
    }

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", answerId=" + answerId + ", postId=" + postId + ", userId="
				+ userId + ", text=" + text + "]" + "\n";
	} 
}
