package com.oracle.demo2;

import java.io.File;
import java.io.IOException;
import java.security.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class write {
	public static void xmlWriteIntoSQL(){
		File file = new File("C:"+File.separator+"java"+File.separator+"sql xml.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		Date time =null;
		EmpDao dao = null;
		//DocumentBuilder builder = null;
		
		try {//将xml解析出来
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document =  builder.parse(file);
			NodeList Emps = document.getElementsByTagName("Emp");
			System.out.println(Emps.getLength());
			for(int i = 0 ;i<Emps.getLength();i++){
				Node Emp =  Emps.item(i);
				NodeList childs = Emp.getChildNodes();
				dao= new EmpDao();
				int id = Integer.parseInt(childs.item(0).getTextContent());
				double sals = Double.parseDouble(childs.item(3).getTextContent());			
				time = (new SimpleDateFormat("yyyy-MM-dd-:mm:ss")).parse(childs.item(4).getTextContent());
				dao.insertWithId(new Emp(id,childs.item(1).getTextContent(),childs.item(2).getTextContent(),sals,time));					
			} 

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (DOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
