package com.oracle.demo4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/*
 2008 北京奥运会男足参赛国家：
科特迪瓦，阿根廷，澳大利亚，塞尔维亚，荷兰，尼日利亚、日本，美国，中国，
新西兰，巴西，比利时，韩国，喀麦隆，洪都拉斯，意大利
*/
public class Test {

	public static void main(String[] args) {
		String[] names = {"科特迪瓦","阿根廷","澳大利亚","塞尔维亚","荷兰","尼日利亚","日本","美国","中国","新西兰","巴西","比利时","韩国","喀麦隆","洪都拉斯","意大利"};
		List<String> list = new ArrayList<String>();
		for(int i=0;i<names.length;i++){
			list.add(names[i]);
		}
		Random ran = new Random();
		for(int i=0;i<10;i++){
			int index1 = ran.nextInt(list.size());
			int index2 = ran.nextInt(list.size());
			String n = list.get(index1);
			list.set(index1, list.get(index2));
			list.set(index2, n);
		}
		
		String[][] strs = new String[4][4];
		for(int i=0;i<list.size();i++){
			strs[i/4][i%4]=list.get(i);
		}
		for(String[] str:strs){
			for(String s:str){
				System.out.print(s+"	");
			}
			System.out.println();
		}
		
		
	}

}
