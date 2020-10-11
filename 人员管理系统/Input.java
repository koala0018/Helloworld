package com.oracle.demo1;

import java.util.Scanner;

public class Input {

	//定义一个扫描器类型的属性
	private Scanner scan;
	public Input(){
		scan = new Scanner(System.in);
	}
	//定义一个方法，用来获取用户输入的字符串的内容
	public String getString(String info){
		System.out.println(info);
		return scan.nextLine();
	}
	//定义一个方法，用来获取用户输入的整数
	public int getInt(String info,String errorInfo){
		//调用获取用户输入的字符串的方法
		String str = getString(info);
		//判断用户输入的字符串的格式是否满足整数的格式，如果满足则转变为整数，如果不满足则重新输入
		while(!str.matches("\\d+")){
			System.out.println(errorInfo);
			str = getString(info);
		}
		return Integer.parseInt(str);
	}
	//定义一个方法，用来获取用户输入的年龄
	public int getAge(String info,String errorInfo){
		//调用获取用户输入的字符串的方法
		String str = getString(info);
		//判断用户输入的字符串的格式是否满足整数的格式，如果满足则转变为整数，如果不满足则重新输入
		while(!str.matches("\\d{1,2}")){
			System.out.println(errorInfo);
			str = getString(info);
		}
		return Integer.parseInt(str);
	}
}
