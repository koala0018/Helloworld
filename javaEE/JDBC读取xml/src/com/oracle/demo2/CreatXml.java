package com.oracle.demo2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreatXml {
	public static void Create(List<Emp> list){
		
			if(list.size()>0){//若查出的数据没有就不需要创建xml了
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = null;
				SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd-:mm:ss");
				try {
					builder = factory.newDocumentBuilder();
					Document document = builder.newDocument();
					Element employees = document.createElement("employees");
					//数据库查出数据写入标签
					for(Emp e:list){//list里面是emp对象，有几个对象就循环几次，每次给标签赋值，第二次循环标签就失效了，所以重复赋值不会覆盖之前的标签
						Element Emp = document.createElement("Emp");
						Element empid = document.createElement("empid");
						Element ename = document.createElement("ename");
						Element job = document.createElement("job");
						Element sals = document.createElement("sals");
						Element hiredate = document.createElement("hiredate");
						empid.setTextContent(e.getEmpid()+"");
						ename.setTextContent(e.getEname());
						job.setTextContent(e.getJob());
						sals.setTextContent(e.getSal()+"");
						hiredate.setTextContent(time.format(e.getHiredate()));//将Date类型转为SimpleDateFormat的字符串型
						//设计每个标签的关系
						Emp.appendChild(empid);
						Emp.appendChild(ename);
						Emp.appendChild(job);
						Emp.appendChild(sals);
						Emp.appendChild(hiredate);
						employees.appendChild(Emp);
						
					} 
					document.appendChild(employees);
					//开始转化
					TransformerFactory tf = TransformerFactory.newInstance();
					Transformer former = tf.newTransformer();
					former.setOutputProperty(OutputKeys.ENCODING,"GBK");
					DOMSource domSource = new DOMSource(document);
					StreamResult sr = new StreamResult(new FileOutputStream(new File("C:"+File.separator+"java"+File.separator+"sql xml.xml")));
					former.transform(domSource, sr);//记住dom方式解析中，transform需要两个参数，一个Source资源，一个StreamResult，Source是接口，用其实现类domSource（需要传入你要转化的document），
													//StreamResult类，直接实例化，构造方法用文件输出流对象
					
				} catch (TransformerConfigurationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (TransformerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParserConfigurationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			
		
	}
	}
	
