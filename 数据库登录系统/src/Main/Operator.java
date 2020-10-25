package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Menu.LoginCheck;
import Menu.Menu;
import dao.T_Userdao;
import vo.T_User;

public class Operator {
	public static void register(){//注册
		Scanner scan = new Scanner(System.in);	
		T_Userdao t = new T_Userdao();
		System.out.println("输入你的用户名");
		String name = scan.nextLine();
		name = LoginCheck.checkname(name);
		if(name!=""){
			System.out.println("输入密码");
			String password = scan.nextLine();
			System.out.println("输入邮箱");
			String email = scan.nextLine();
			email = LoginCheck.checkemail(email);
			if(email!=""){
				T_User user = new T_User(name,password,email);
				t.insert(user);
				System.out.println("注册已完成");
			}else{
				register();
			}
			
		}else{
			register();
		}
	}
	public static boolean login(){
		List<T_User> list = new ArrayList<T_User>();
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		int index =  0;
		System.out.println("请输入你的用户名：");
		String name = scan.nextLine();
		Scanner scan1 = new Scanner(System.in);	
		System.out.println("请输入你的密码：");
		String pwd = scan1.nextLine();
		T_Userdao t = new T_Userdao();
		list = t.selectAll();
		for (int i = 0; i <list.size(); i++) {
			if(list.get(i).getUserName().equals(name)){
				index = i;
				if(list.get(index).getPwd().equals(pwd)){
					flag = true;
					break;
				}else{
					flag = false;
				}
			}else{			
				flag = false;												
			}
		}
		
		if(flag==false){
			System.out.println("用户名或者密码输入错误");
			return flag;
		}else{
			Menu.menu1();
			return flag;
		}	
	}
	
	
	public static void showByName(){
		Scanner scan = new Scanner(System.in);
		T_Userdao user = new T_Userdao();
		T_User t = new T_User();		
		System.out.println("再次输入你要查询的名字");
		String userName = scan.nextLine();
		t.setUserName(userName);//按照此名字查
		t = user.selectByname(t);
		System.out.println(t.toString());
	}
	public static void showAll(){
		
		T_Userdao user = new T_Userdao();
		List<T_User> list = new ArrayList<T_User>();
		list = user.selectAll();
		for (int i = 0; i < list.size(); i++) {
			System.out.println("id："+list.get(i).getId()+",Username:"+list.get(i).getUserName()+",Email:"+list.get(i).getEmail());//不显示密码
		}
		
	}
}
