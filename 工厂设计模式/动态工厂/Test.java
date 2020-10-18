package com.oracle.demo7;

import java.util.ResourceBundle;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入想吃的水果:");
		String name = scan.nextLine();
		ResourceBundle rb = ResourceBundle.getBundle("fruit");
		try{
			String className = rb.getString(name);
			FruitFactory.createFruit(className);
		}catch(Exception e){
			System.out.println("这个东西是不能被生产为罐头的");
		}
		
	}

}
