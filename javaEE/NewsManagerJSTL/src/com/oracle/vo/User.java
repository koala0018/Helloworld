package com.oracle.vo;

public class User {

	private String userid;
	private String password;
	private String username;
	private int flag;
	public User(){}
	public User(String userid,String password,String username,int flag){
		this.setPassword(password);
		this.setUserid(userid);
		this.setUsername(username);
		this.setFlag(flag);
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
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", password=" + password + ", username=" + username + ", flag=" + flag + "]";
	}
	


}
