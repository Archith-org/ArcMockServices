package com.archith.mockServices.to;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


public class UserTo {
	
	private int userId;
	private String userName;
	private String userActive;
	public String UserEmail;
	private long userPhoneNumber;
	private char userIsAdmin;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserActive() {
		return userActive;
	}
	public void setUserActive(String userActive) {
		this.userActive = userActive;
	}
	public String getUserEmail() {
		return UserEmail;
	}
	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}
	public long getUserPhoneNumber() {
		return userPhoneNumber;
	}
	public void setUserPhoneNumber(long userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}
	public char getUserIsAdmin() {
		return userIsAdmin;
	}
	public void setUserIsAdmin(char userIsAdmin) {
		this.userIsAdmin = userIsAdmin;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
	
	

}
