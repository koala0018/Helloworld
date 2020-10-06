package com.oracle.demo2;

public class Operator {

	//定义一个输入类型的对象,此对象用来提供方法，对学生的信息进行输入
	private Input input;
	public Operator(){
		input = new Input();
	}
	public void operator(){
		//获取用户输入的学生的信息
		String str = input.getInputStudentInfo("请输入学生的成绩，格式为:姓名:年龄:成绩|姓名:年龄:成绩", "输入格式不正确，格式为:姓名:年龄:成绩|姓名:年龄:成绩");
		//将用户输入的学生信息按照|进行拆分
		String[] strs = str.split("\\|");
		//定义一个Student类型的数组，用来保存解析出来的每一个学生
		Student[] stus = new Student[strs.length];
		//定义一个变量代表学生数组的下标
		int index=0;
		//编写循环遍历拆分好的字符串数组，拆分好的字符串数组中的每一个字符串都是一个学生的信息
		for(String s:strs){
			/*
			 * 将每一个学生的信息按照:
			 * 进行拆分，会得到一个数组，这个数组中：
			 * 下标为0的字符串是学生的姓名，
			 * 下标为1的字符串是学生的年龄，
			 * 下标为2的字符串是学生的成绩
			 */
			String[] ss = s.split(":");
			//将等到信息用来创建学生对象
			Student stu = new Student(ss[0],Integer.parseInt(ss[1]),Integer.parseInt(ss[2]));
			//将创建好的学生对象保存到数组中
			stus[index] = stu;
			index++;
		}
		for(int i=0;i<stus.length-1;i++){
			for(int j=stus.length-1;j>i;j--){
				if(stus[j].compareTo(stus[j-1])<0){
					Student s = stus[j];
					stus[j] = stus[j-1];
					stus[j-1]=s;
					
				}
			}
		}
		for(Student s:stus){
			System.out.println(s);
		}
	}
}
