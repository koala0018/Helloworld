package com.oracle.demo1;
/**

2.使用File,获得一个文件是否存在,如果不存在,则创建.如果存在,则显示这个文件的大小,路径,最后修改时间.

3.创建一个多层目录 "f:/java/java1/java2"

4.File类,自学createTempFile方法的使用,在一个目录中，创建500个临时文件；

5.删除一个给定的目录,这上目录不为空目录,使用递归来实现

6.写一个方法,可以复制一个文件

7.写一个方法,可以复制一个目录,(此目录不为空)

8.写一个方法,可以将一个非空目录中的所有文件的层次显示出来；
*/
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		File srcFile = new File("d:"+File.separator+"java");
		File destFile = new File("d:"+File.separator+"javaDemo");
		

	}
	public static void test1(){
		File file = new File("d:"+File.separator+"demo.txt");
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("文件的大小:"+file.length());
		System.out.println("文件的路径:"+file.getAbsolutePath());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date(file.lastModified()));
		System.out.println("文件的最后修改时间:"+time);
	}
	public static void test2(){
		File file = new File("d:"+File.separator+"java"+File.separator+"java1"+File.separator+"java2");
		file.mkdirs();
	}
	public static void test3(){
		File file = new File("d:"+File.separator+"java"+File.separator+"java1"+File.separator+"java2");
		for(int i=0;i<500;i++){
			try {
				File.createTempFile("hello", ".java", file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void test4(File file){
		if(file.isDirectory()){
			System.out.println(file.getAbsolutePath());
			File[] files = file.listFiles();
			for(File f:files){
				test4(f);
			}
		}else{
			System.out.println(file.getAbsolutePath());
		}
	}
	public static void test5(File srcFile,File destFile){
		//判断目标参数destFile是否是一个文件夹
		if(destFile.isDirectory()){
			//判断目标文件夹是否存在你
			if(!destFile.exists()){
				destFile.mkdirs();
			}
			//创建一个字符串类型的对象，代表新创建文件的路径
			String filePath = destFile.getAbsolutePath()+File.separator+srcFile.getName();
			File newFile = new File(filePath);
			try {
				newFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			System.out.println("目标文件不是一个文件夹不能完成复制");
		}
	}
	
	public static void test6(File srcFile,File destFile){
		if(!destFile.exists()){
			System.out.println("目标文件夹不存在，不能复制");
			return ;
		}
		//判断目标文件是否是一个文件夹
		if(destFile.isDirectory()){
			//判断源文件是否是一个文件夹
			if(srcFile.isDirectory()){
				//在目标文件夹中创建当前的文件夹
				String filePath = destFile.getAbsolutePath()+File.separator+srcFile.getName();
				File file = new File(filePath);
				if(!file.exists()){
					file.mkdirs();
				}
				//获取源文件夹中的所有的子文件
				File[] files = srcFile.listFiles();
				//编写循环遍历每一个子文件
				for(File f:files){
					test6(f,file);
				}
			
			}else{
				//判断目标文件夹是否存在你
				if(!destFile.exists()){
					destFile.mkdirs();
				}
				//创建一个字符串类型的对象，代表新创建文件的路径
				String filePath = destFile.getAbsolutePath()+File.separator+srcFile.getName();
				File newFile = new File(filePath);
				try {
					newFile.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else{
			System.out.println("目标文件不是文件夹不能完成复制");
		}
	}

	public static void deleteFile(File file){
		if(file.isDirectory()){
			File[] files = file.listFiles();
			for(File f:files){
				deleteFile(f);
			}
			file.delete();
		}else{
			file.delete();
		}
	}
}
