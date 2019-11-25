package ua.lviv.iot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int userId;
 
 @Column (name = "nick_name")
 private String nickName;
 
 @Column (name = "foto")
 private String foto;
 
 @Column (name = "last_activity")
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
