package ua.lviv.iot.model;

public class UserSecurity {
  private int userId;
  private String password;
  private String phone;
  
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "UserSecurity [user_id=" + userId + ", password=" + password + ", phone=" + phone + "]" + "\n";
	}
}
