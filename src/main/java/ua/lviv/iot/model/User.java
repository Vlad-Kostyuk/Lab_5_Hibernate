package ua.lviv.iot.model;

public class User {
 private int userId;
 private String nickName;
 private String foto;
 private String lastActivity;
 
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getNickName() {
		return nickName;
	}
	
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public String getFoto() {
		return foto;
	}
	
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public String getLastActivity() {
		return lastActivity;
	}
	
	public void setLastActivity(String lastActivity) {
		this.lastActivity = lastActivity;
	}

	@Override
	public String toString() {
		return "User [id_user=" + userId + ", nick_name=" + nickName + ", foto=" + foto + ", last_activity="
				+ lastActivity + "]" + "\n";
	}
}
