package 数据库登录;

public class T_User {
	private int id;
	private String userName;
	private String  pwd;
	private String email;
	public T_User(){}
	public T_User(int id, String userName, String pwd, String email) {
		this.id = id;
		this.userName = userName;
		this.pwd = pwd;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
