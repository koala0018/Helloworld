package Day2020_1104;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
public class Test1 {
	//老师代码，读取	
		public static void main(String[] args) {
			fun1();
		}
		public static void fun1(){
			//定义一个File对象代表要解析的XML文件
			File file = new File("C:"+File.separator+"java"+File.separator+"test.xml");
					//建立DocumentBuilderFactory对象
					DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
					//建立DocumentBuilder对象
					DocumentBuilder builder = null;
					try {
						builder = factory.newDocumentBuilder();
						//建立Document对象
						Document document = builder.parse(file);
						//获取标签
						NodeList linkmans = document.getElementsByTagName("callman");
						//编写循环遍历linkmans
						for(int i=0;i<linkmans.getLength();i++){
							Node linkman = linkmans.item(i);
							NamedNodeMap attrs = linkman.getAttributes();
							for(int j=0;j<attrs.getLength();j++){
								Attr attr = (Attr)attrs.item(j);
								System.out.println(attr.getName()+"="+attr.getValue());
							}
							
							NodeList childs = linkman.getChildNodes();
							for(int j=0;j<childs.getLength();j++){
								Node child = childs.item(j);
								if(!child.getNodeName().equals("#text")){
									
									System.out.println(child.getNodeName()+":"+child.getTextContent());
								}
							}
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
					}
			
		}
		public static void fun2(){
			
			//定义一个File对象代表要解析的XML文件
			File file = new File("C:"+File.separator+"java"+File.separator+"test.xml");
					//建立DocumentBuilderFactory对象
					DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
					//建立DocumentBuilder对象
					DocumentBuilder builder = null;
					try {
						builder = factory.newDocumentBuilder();
						//建立Document对象
						Document document = builder.parse(file);
						//获取标签
						NodeList linkmans = document.getElementsByTagName("linkman");
						//遍历所有的linkman标签
						for(int i=0;i<linkmans.getLength();i++){
							Element linkman = (Element)linkmans.item(i);
							System.out.println("id="+linkman.getAttribute("id"));
							System.out.println("tel="+linkman.getAttribute("tel"));
							
							NodeList names = linkman.getElementsByTagName("name");
							NodeList emails = linkman.getElementsByTagName("email");
							Element name = (Element)names.item(0);
							Element email = (Element)emails.item(0);
							
						
							System.out.println(name.getTagName()+":"+name.getTextContent());
							System.out.println(email.getTagName()+":"+email.getTextContent());
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
					}
		}

	}


