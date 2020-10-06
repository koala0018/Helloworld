package com.oracle.demo2;

import java.util.Scanner;

public class Input {

	//定义一个扫描器类型的属性
	private Scanner scan;
	public Input(){
		scan = new Scanner(System.in);
	}
	/*
	 * 定义一个方法用来获取用户输入字符串
	 * 此方法需要有一个参数，参数代表给用户的提示信息
	 */
	public String getInputString(String info){
		//打印提示信息
		System.out.println(info);
		//将用户输入的内容获取并返回
		return scan.nextLine();
	}
	/*
	 * 定义一个方法，用来获取用户输入的学生的信息
	 * 此方法需要两个参数：
	 * 1.info：给用户的提示信息
	 * 2.errorInfo:当用户输入错误的时候，给出的错误信息
	 * 
	 */
	public String getInputStudentInfo(String info,String errorInfo){
		//调用用户输入信息的方法，获取到用户输入的内容
		String str = getInputString(info);
		//编写循环，判断用户输入的内容是否满足我们需要的格式,如果不满足则重复输入
		while(!str.matches("(.{2,4}:\\d{2}:\\d{1,3}\\|{0,1})+")){//用户输入的信息的格式不满足我们需求的格式
			//给出错误信息
			System.out.println(errorInfo);
			//重新获取
			str = getInputString(info);
		}
		//将满足格式的信息进行返回
		return str;
	}
}
