package ua.lviv.iot.model;

public class UserLog {
  private int userId;
  private String dateEvent;
  private String log;
  
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getDateEvent() {
		return dateEvent;
	}
	
	public void setDateEvent(String dateEvent) {
		this.dateEvent = dateEvent;
	}
	
	public String getLog() {
		return log;
	}
	
	public void setLog(String log) {
		this.log = log;
	}

	@Override
	public String toString() {
		return "UserLog [user_id=" + userId + ", date_event=" + dateEvent + ", log=" + log  +"]" + "\n";
	}
}
