package com.oracle.demo5;
/*
（综合）有如下Student 对象
属性：name age score classNum
 
其中，classNum 表示学生的班号，例如“class05”。
有如下List
List list = new ArrayList();
list.add(new Student(“Tom”, 18, 100, “class05”));
list.add(new Student(“Jerry”, 22, 70, “class04”));
list.add(new Student(“Owen”, 25, 90, “class05”));
list.add(new Student(“Jim”, 30,80 , “class05”));
list.add(new Student(“Steve”, 28, 66, “class06”));
list.add(new Student(“Kevin”, 24, 100, “class04”));
在这个list 的基础上，完成下列要求：
1） 计算所有学生的平均年龄
2） 计算各个班级的平均分

*/
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("Tom", 18, 100, "class05"));
		list.add(new Student("Jerry", 22, 70, "class04"));
		list.add(new Student("Owen", 25, 90, "class05"));
		list.add(new Student("Jim", 30,80 , "class05"));
		list.add(new Student("Steve", 28, 66, "class06"));
		list.add(new Student("Kevin", 24, 100, "class04"));
		double sum=0.0;
		for(Student s:list){
			sum+=s.getAge();
		}
		System.out.println("平均年龄是:"+sum/list.size());
		
		List<String> classNums = new ArrayList<String>();
		for(Student s:list){
			if(!classNums.contains(s.getClassNum())){
				classNums.add(s.getClassNum());
			}
		}
		for(String classNum:classNums){
			//定义一个变量代表这个班的总成绩
			double s = 0.0;
			//定义一个变量代表这个班的学生的个数
			int s1=0;
			for(Student stu:list){
				if(classNum.equals(stu.getClassNum())){
					s+=stu.getScore();
					s1++;
				}
			}
			System.out.println(classNum+"的平均成绩是："+(s/s1));
		}
	}
}
