package com.oracle.demo2;
//3.按照“姓名：年龄：成绩|姓名：年龄：成绩”的格式定义字符串“张三：21:98|李四：22:89|王五：20:70”
//要求将每组值分别保存在Student对象中，并对这些对象进行排序，
//排序原则为：按照成绩由高到低进行排序，如果成绩相等，则按照年龄由低至高排序
public class Student {

	private String name;
	private int age;
	private int score;
	public Student(){}
	public Student(String name,int age,int score){
		this.setAge(age);
		this.setName(name);
		this.setScore(score);
	}
	/*
	 * 编写一个方法，用来比较两个学生之间的先后顺序，
	 * 如果调用方法的学生对象需要排在参数的学生对象之前则返回负数，
	 * 如果二者相同则返回0，
	 * 如果调用方法的学生对象需要排在参数对象的后面则返回正数
	 */
	public int compareTo(Student stu){
		if(this.getScore()>stu.getScore()){//判断调用方法的学生对象的成绩是否高于参数的学生的成绩
			return -1;
		}else if(this.getScore()<stu.getScore()){//判断调用方法的学生对象的成绩是否低于参数的学生的成绩
			return 1;
		}else{//判断调用方法的学生对象的成绩是否等于参数的学生的成绩
			if(this.getAge()>stu.getAge()){//判断调用方法的学生对象的年龄是否高于参数的学生的年龄
				return 1;
			}else if(this.getAge()<stu.getAge()){//判断调用方法的学生对象的年龄是否小于参数的学生的年龄
				return -1;
			}else{
				return 0;
			}
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", score=" + score + "]";
	}
	
}
