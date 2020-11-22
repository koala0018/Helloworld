package Menu;

import java.util.Scanner;

import Main.Operator;

public class Menu {
	public static int choice;
	private static boolean flag = true;
	public static void menu(){
		Scanner scan = new Scanner(System.in);	
		while(flag){
			System.out.println("*****欢迎使用本系统*****");
			System.out.println("请选择：");
			System.out.println("1.注册	2.登录	3.退出");
			System.out.println("*******************");
			
			choice = scan.nextInt();
			switch(choice){
			case 1:
				Operator.register();
				break;
			case 2:
				flag = Operator.login();
				while(flag==false){
					flag = Operator.login();
				}
				break;
			case 3:
				System.out.println("系统已退出");
				flag = false;
				break;
		}
	}
				
}
	public static void menu1(){
		
		Scanner scan = new Scanner(System.in);	
		
		while(flag){
			System.out.println("*****登录成功*****");
			System.out.println("请选择：");
			System.out.println("1.查询当前用户	2.查询全部用户	3.返回上一级菜单");
			System.out.println("*******************");
			choice = scan.nextInt();
			switch(choice){
			case 1:
				Operator.showByName();
				break;
			case 2:
				Operator.showAll();
				
				break;
			case 3:
				flag = false;
				break;
			}
		}		
		
	}
	

}
