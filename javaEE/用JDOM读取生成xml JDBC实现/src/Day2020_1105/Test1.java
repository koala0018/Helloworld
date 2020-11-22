package Day2020_1105;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.DOMBuilder;
import org.xml.sax.SAXException;

public class Test1 {
	//JDOMd写入数据库,先读再写
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DOMBuilder builder  = new DOMBuilder();
		Date time = null;
		EmpDao dao =null;
		Attribute  arr = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {//此处是得到指定xml的document对象
			Document document = builder.build(factory.newDocumentBuilder().parse(new File("C:"+File.separator+"java"+File.separator+"sql xml.xml")));
			Element employees= document.getRootElement();
			//对跟标签获取子标签
			List<Element>Emps = employees.getChildren();
			for(int i=0;i<Emps.size();i++){
				Element child = Emps.get(i);
				List<Element> childs = child.getChildren();
				//child.setText("");				
				dao = new EmpDao();
				int empid = Integer.parseInt(childs.get(0).getValue());
//				arr = new Attribute("id",empid+"");
//				child.setAttribute(arr);
				String ename =childs.get(1).getValue();
				String job = childs.get(2).getValue();
				double sal = Double.parseDouble(childs.get(3).getValue());
				time = new SimpleDateFormat("yyyy-MM-dd-:mm:ss").parse(childs.get(4).getValue());
				dao.insertWithId(new Emp(ename,job,sal,time));
				
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}/*
	public static  void findChild(Element element){
		List<Element> child =  element.getChildren();
		System.out.println(child.size());
		if(child.size()>0){
			for(Element e:child){
				findChild(e);
			}
		}else{
			//System.out.println(element.getName()+":"+element.getValue());
			EmpDao dao = new EmpDao();
			int id = Integer.parseInt(element.getValue());
			dao.insertWithId(new Emp(id));
		}
	}*/
}
