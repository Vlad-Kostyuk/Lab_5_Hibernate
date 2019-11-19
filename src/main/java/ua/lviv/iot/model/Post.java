package ua.lviv.iot.model;

public class Post {
  private int postId;
  private int userId;
  private int typePostId;
  private int date;
  private String description;

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

	public int getTypePostId() {
		return typePostId;
	}

	public void setTypePostId(int typePostId) {
		this.typePostId = typePostId;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Post [id_post=" + postId + ", id_user=" + userId + ", id_type_post=" + typePostId + ", date=" + date
				+ ", description=" + description + "]" + "\n";
	}
}
