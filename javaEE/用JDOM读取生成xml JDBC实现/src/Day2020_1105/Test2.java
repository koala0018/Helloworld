package Day2020_1105;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Test2 {

	public static void main(String[] args) {
		//生成XML
		Document document = new Document();
		Emp emp = null;
		EmpDao dao = new EmpDao();
		Element employees = new  Element("employees");
		
		List<Emp> list = dao.selectAll();
	
		for(int i=0;i<list.size();i++){
			Element Emp = new  Element("Emp");
			Element empid = new  Element("empid");
			Element ename = new  Element("ename");
			Element job = new  Element("job");
			Element sal = new  Element("sal");
			Element hiretime = new  Element("hiretime");
			empid.setText(list.get(i).getEmpid()+"");
			ename.setText(list.get(i).getEname());
			job.setText(list.get(i).getJob());
			sal.setText(list.get(i).getSal()+"");
			hiretime.setText(list.get(i).getHiredate().toString());
			Emp.addContent(empid);
			Emp.addContent(ename);
			Emp.addContent(job);
			Emp.addContent(sal);
			Emp.addContent(hiretime);	
			employees.addContent(Emp);
		}
		
		try {
			
			document.addContent(employees);
			XMLOutputter out = new XMLOutputter();
			out.setFormat(Format.getCompactFormat().setEncoding("GBK"));
			out.output(document,new FileOutputStream(new File("C:"+File.separator+"java"+File.separator+"JDOM.xml")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
