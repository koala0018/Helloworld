package com.oracle.demo1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileOperator {

	//定义一个File类型的属性，代表具体操作哪一个文件
	private File file;
	public FileOperator(){
		file = new File("d:"+File.separator+"person.txt");
	}
	public FileOperator(String filePath){
		file = new File(filePath);
	}
	//编写一个方法，用来对Person数组执行序列化操作
	public void writePersons(Person[] pers){
		//定义一个ObjectOutputStream对象
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(pers);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(oos!=null){
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	//编写一个方法用来执行反序列操作
	public Person[] readPersons(){
		//定义一个Person类型的数组
		Person[] pers = null;
		//定义一个ObjectInputStream对象
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			pers = (Person[])ois.readObject();
			Person.setCount(pers[pers.length-1].getId());
		} catch (FileNotFoundException e) {
			try {
				file.createNewFile();
				pers = new Person[0];
				writePersons(pers);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return pers;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(ois!=null){
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return pers;
	}
}
