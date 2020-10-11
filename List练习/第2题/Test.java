package com.oracle.demo3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/*
已知有十六支男子足球队参加2008 北京奥运会。写一个程序，把这16 支球队随机分为4 个组。
注：参赛球队列表见附录
注2：使用Math.random 来产生随机数。（也可以使用其它方法）
*/
public class Test {
	public static void main(String[] args) {
		test2();
	}
	public static void test1(){
		List<Integer> list = new ArrayList<Integer>();
		for(int i=1;i<=22;i++){
			list.add(i);
		}
		Random ran = new Random();
		for(int i=0;i<10;i++){
			int index1 = ran.nextInt(list.size());
			int index2 = ran.nextInt(list.size());
			Integer n = list.get(index1);
			list.set(index1, list.get(index2));
			list.set(index2, n);
		}
		
		for(int i=0;i<5;i++){
			System.out.println(list.get(i));
		}
	}
	public static void test2(){
		List<Integer> list = new ArrayList<Integer>();
		Random ran = new Random();
		while(list.size()<5){
			int number = ran.nextInt(22)+1;
			if(!list.contains(number)){
				list.add(number);
			}
		}
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
}
