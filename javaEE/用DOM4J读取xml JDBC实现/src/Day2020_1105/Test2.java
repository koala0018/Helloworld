package Day2020_1105;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class Test2 {

	public static void main(String[] args) {
		// 生成xml
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd-:mm:ss");
		Document document = DocumentHelper.createDocument();
		Element employees = document.addElement("employees");
		EmpDao dao = new EmpDao();
		List<Emp>list =  dao.selectAll();
		
		for(Emp e:list){
			Element Emp = employees.addElement("Emp");
			//Element empid = Emp.element("empid");
			Element ename = Emp.addElement("ename");
			ename.setText(e.getEname());
			Element job = Emp.addElement("job");
			job.setText(e.getJob());
			Element sal = Emp.addElement("sal");
			sal.setText(e.getSal()+"");
			Element hiredate = Emp.addElement("hiredate");		
			hiredate.setText(time.format(e.getHiredate()));
			Emp.addAttribute("id", e.getEmpid()+"");		
		}
		//设置前导区
		OutputFormat format = new OutputFormat();
		format.setEncoding("GBK");
		//生成
		try {
			XMLWriter writer = new XMLWriter(new FileOutputStream(new File("C:"+File.separator+"java"+File.separator+"DOM4J.xml")), format);
			writer.write(document);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
