package Day2020_1104;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

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

public class Test2 {
	//生成xml
	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		Transformer former = null;
		try {
			builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();
			Element contactName =  document.createElement("contactName");
			Element linkman =  document.createElement("linkman");
			Element name =  document.createElement("name");
			Element email =  document.createElement("email");
			linkman.setAttribute("id", "001");
			name.setTextContent("张三");
			email.setTextContent("111@qq.com");
			//标签设置完成，开始装入
			linkman.appendChild(name);
			linkman.appendChild(email);
			contactName.appendChild(linkman);
			document.appendChild(contactName);
			//装入完成开始转化
			TransformerFactory tf = TransformerFactory.newInstance();
			former = tf.newTransformer();
			former.setOutputProperty(OutputKeys.ENCODING, "GDK");//OutputKeys是个类，OutputKeys为静态方法
			DOMSource domSource = new  DOMSource(document);//传入一个Node参数，因为要转化的是次参数的资源			
			StreamResult sr = new StreamResult(new FileOutputStream(new File("C:"+File.separator+"java"+File.separator+"test3.xml")));
			former.transform(domSource,sr);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
/*老师代码：
 public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();
			Element addresslist = document.createElement("addresslist");
			Element linkman = document.createElement("linkman");
			Element name = document.createElement("name");
			Element tel = document.createElement("tel");
			Element email = document.createElement("email");
			
			linkman.setAttribute("id", "001");
			name.setTextContent("张三");
			tel.setTextContent("13456789098");
			email.setTextContent("10001@qq.com");
			
			linkman.appendChild(name);
			linkman.appendChild(tel);
			linkman.appendChild(email);
			
			addresslist.appendChild(linkman);
			document.appendChild(addresslist);
			
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer tt = tf.newTransformer();
			tt.setOutputProperty(OutputKeys.ENCODING, "GBK");
			DOMSource domSource = new DOMSource(document);
			StreamResult sr = new StreamResult(new FileOutputStream(new File("d:"+File.separator+"create.xml")));
			tt.transform(domSource, sr);
			} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
 * */
