package ua.lviv.iot.model;

public class PreferenceComment {
  private int commentId;
  private int userId;

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "PreferenceComment [id_comment=" + commentId + ", id_user=" + userId + "]" + "\n";
	}
}
