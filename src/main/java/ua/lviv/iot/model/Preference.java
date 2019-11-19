package ua.lviv.iot.model;

public class Preference {
  private int userId;
  private int postId;
  private String date;
  
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

	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Preference [id_user=" + userId + ", id_post=" + postId + ", date=" + date + "]" + "\n";
	}
}
