
public class Operator {

	private Input input = null;
	public Operator(){
		input = new Input();
	}
	public void operator(){
		//定义一个变量代表循环执行的条件
		boolean flag=true;
		//编写一个循环，用来显示菜单以及获取用户输入的信息，根据用户输入的信息判断执行哪一个功能，如果用户输入的选项不存在则重复显示菜单
		while(flag){
			//显示菜单
			Menu.showMenu();
			//获取用户输入的选项
			int n = input.getInt("请选择您要执行的操作:");
			//根据用户输入的内容判断执行某一项功能
			switch (n) {
				case 1://用户选择执行登录
					//定义一个变量代表输入用户名或密码的次数
					int count=3;
					//编写一个变量代表输入用户名与自己的循环的条件
					boolean f1 = true;
					while(f1){
						if(count<=0){
							System.out.println("尝试输入密码3次错误，程序结束");
							f1=false;
							flag=false;
							break;
						}
						
						String username = input.getString("请输入用户名:");
							
						String password = input.getString("请输入密码:");
						//判断用户名与密码是否正确
						if(username.equals("admin")&&password.equals("admin")){
							System.out.println("欢迎admin使用我们的XXX系统");
							flag=false;
							f1=false;
						}else{
							System.out.println("用户名或密码错误");		
							count--;
						}
							
					}
						
					break;
				case 2://用户选择退出
					System.out.println("程序执行结束，已退出");
					flag=false;
					break;

				default://用户输入了没有的选项
					System.out.println("当前没有这个选项");
					break;
				}
					
			}
				
	}
}
