package com.oracle.demo2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/*
编写一个22选5的彩票选号程序。每次选出不同的五组号码，并输出到控制台中。
*/
public class Test {

	public static void main(String[] args) {
		Random ran = new Random();
		List<Integer> list = new ArrayList<Integer>();
		for(int i=1;i<=10;i++){
			list.add(i);
		}
		System.out.println("打乱之后的结果:");
		for(int i=0;i<10;i++){
			//定义一个变量代表第一次获取的随机的下标
			int index1 = ran.nextInt(list.size());
			//定义一个变量代表第二次获取的随机的下标
			int index2 = ran.nextInt(list.size());
			//定义一个变量代表取出的index1下标的元素
			Integer n = list.get(index1);
			list.set(index1, list.get(index2));
			list.set(index2, n);
		}
		for(Integer i:list){
			System.out.println(i);
		}
		for(int i=0;i<list.size()-1;i++){
			for(int j=list.size()-1;j>i;j--){
				if(list.get(j)<list.get(j-1)){
					Integer n = list.get(j);
					list.set(j, list.get(j-1));
					list.set(j-1, n);
				}
			}
		}
		System.out.println("从小到大排序:");
		for(Integer i:list){
			System.out.println(i);
		}
		for(int i=0;i<list.size()-1;i++){
			for(int j=list.size()-1;j>i;j--){
				if(list.get(j)>list.get(j-1)){
					Integer n = list.get(j);
					list.set(j, list.get(j-1));
					list.set(j-1, n);
				}
			}
		}
		System.out.println("从大到小排序:");
		for(Integer i:list){
			System.out.println(i);
		}

/*
		//my method:

		LinkedList<Integer> list = new LinkedList<Integer>();
		LinkedList<Integer> list1 = new LinkedList<Integer>();

		// System.out.println(index);
		for (int i = 1; i <= 22; i++) {
			list.add(i);
		}
		int count = 0;
		int flag = 1;
		while (count < 5) {
			flag = 1;
			double randomtemp = 0.0;
			int index = 0;
			int index1 = 0;
			randomtemp = Math.random() * 22;
			index = (int) randomtemp;
			list1.add(list.get(index));
			for (int i = 0; i < list1.size(); i++) {

				for (int j = list1.size() - 1; j > i; j--) {
					if (list1.get(j) == list1.get(j - 1)) {
						flag = -1;
					}
				}

			}
			if (flag == -1) {
				continue;
			}
			count++;

		}

		System.out.println("号池数字为：" + list);
		System.out.println("选出的彩票号码是：" + list1);
*/

	}

}
