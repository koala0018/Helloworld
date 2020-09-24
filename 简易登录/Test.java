
public class Test {
/*

需求：
完成一个登录功能，在登录的时候需要显示菜单，菜单的格式如下：
欢迎使用甲骨文XXX系统
1.登录
2.退出
用户可以进行选择，选择2则程序直接停止，选择1进入到登录界面
登录界面如下：
用户名:

密码:

当用户输入完用户名和密码之后，我们需要验证用户名以及面，用户名:admin密码：admin,我们就登录成功，显示欢迎管理员，如果用户名或密码错误，则给出提示，重新回到菜单界面。

*/
	public static void main(String[] args) {
		Operator opr = new Operator();
		opr.operator();
		
	}

}
