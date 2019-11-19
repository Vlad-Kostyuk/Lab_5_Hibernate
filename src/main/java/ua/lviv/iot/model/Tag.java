package ua.lviv.iot.model;

public class Tag {
  private int userId;
  private int postId;
  private String tag;

	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getPostId() {
		return postId;
	}
	
	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getTag() {
		return tag;
	}
	
	public void setTag(String tag) {
		this.tag = tag;
	}

	@Override
	public String toString() {
		return "Tag [id_user=" + userId + ", id_post=" + postId + ", tag=" + tag + "]" + "\n";
	}
}
