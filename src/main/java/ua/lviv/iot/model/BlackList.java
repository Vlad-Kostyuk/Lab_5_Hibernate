package ua.lviv.iot.model;

public class BlackList {
 private int userId;
 private int lockingUserId;
 private String lockingTime;
 
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getLockingUserId() {
		return lockingUserId;
	}

	public void setLockingUserId(int lockingUserId) {
		this.lockingUserId = lockingUserId;
	}

	public String getLockingTime() {
		return lockingTime;
	}

	public void setLockingTime(String lockingTime) {
		this.lockingTime = lockingTime;
	}

	@Override
	public String toString() {
		return "BlackList [userId=" + userId + ", lockingUserId=" + lockingUserId + ", lockingTime="
				+ lockingTime + "]" + "\n";
	}
}
