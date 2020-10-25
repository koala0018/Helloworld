package Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.T_Userdao;
import vo.T_User;

public class LoginCheck {
	//private static boolean flag=true;
	private static Scanner scan = new Scanner(System.in);	
	
	
	public static String checkname(String name){
		T_Userdao user = new T_Userdao();
		List<T_User> list = new ArrayList<T_User>();
		boolean flag=true;
		list = user.selectAll();
		//int index = 0;
		for (int i = 0; i <list.size(); i++) {
			if(!list.get(i).getUserName().equals(name)){
				//System.out.println("没找到重复名字");
				
			}else{			
				//System.out.println("找到重复名字");
				flag = false;
				break;
			}
		}
		if(flag==false){
			System.out.println("用户名已存在,请重新注册");
			return name="";
		}else{
			return name;
		}	
		
	}
	public static String checkemail(String email){
		boolean flag=true;
		T_Userdao user = new T_Userdao();
		List<T_User> list = new ArrayList<T_User>();
		list = user.selectAll();
		//int index = 0;
		for (int i = 0; i <list.size(); i++) {
			if(!list.get(i).getEmail().equals(email)){
				flag = true;
			}else{			
				flag = false;												
			}
		}
		if(flag==false){
			System.out.println("邮箱被占用,请重新注册");
			return email="";
		}else{
			return email;
		}	
		
	}
}
