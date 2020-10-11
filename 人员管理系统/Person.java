package com.oracle.demo1;

import java.io.Serializable;

public class Person implements Serializable{

	private int id;
	private String name;
	private int age;
	private static int count;
	public Person(){
		count++;
		id=count;
	}
	public Person(String name,int age){
		this();
		this.setAge(age);
		this.setName(name);
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "编号:"+this.getId()+"姓名:"+this.getName()+",年龄:"+this.getAge();
	}
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Person.count = count;
	}
	
}
