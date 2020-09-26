
public class Proxy implements Net{

	private Real real;
	private String username,password;
	public Proxy(Real real,String username,String password){
		this.real = real;
		this.username=username;
		this.password=password;
	}
	public void browse(){
		if(check(username,password)){
			real.browse();
		}else{
			System.out.println("用户名或密码错误");
		}
		
	}
	public boolean check(String username,String password){
		if(username.equals("admin")&&password.equals("admin")){
			return true;
		}else{
			return false;
		}
	}
}
