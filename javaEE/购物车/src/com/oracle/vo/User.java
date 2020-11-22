package com.oracle.vo;

public class User {

	private String userid;
	private String password;
	private String username;
	public User(){}
	
	public User(String userid, String password, String username) {
		super();
		this.userid = userid;
		this.password = password;
		this.username = username;
	}

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "Usre [userid=" + userid + ", password=" + password + ", username=" + username + "]";
	}
	
	
}
