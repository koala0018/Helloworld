package Day2020_1104;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("C:"+File.separator+"java"+File.separator+"test.xml");
		//先创工厂
		DocumentBuilderFactory  factory = DocumentBuilderFactory.newInstance();//其构造是受保护的，只能用自己的方法实例化
		//建DocumentBuilder,应为document对象建立需要它的parse方法
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
			Document document =builder.parse(file);//此方法可以将需要读取的xml文件或流创一个document对象
			NodeList callman =  document .getElementsByTagName("callman");//找你需要的标签而不是最外层标签
			for(int i=0;i<callman.getLength();i++){
				Node linkman = callman.item(i);
				NamedNodeMap attrs = linkman.getAttributes();
				for(int j=0;j<attrs.getLength();j++){
					Attr attr = (Attr)attrs.item(j);//重要
					System.out.println(attr.getName()+"="+attr.getValue());
				}
				
				Node childs = callman.item(i);//按照下标找到nodelist里的node
				NodeList list = childs.getChildNodes();//里面都是我们要的的联系人信息标签
				for(int j =0;j<list.getLength();j++){
					Node child = list.item(j);
					if(!child.getNodeName().equals("#text")){
						System.out.println(child.getNodeName()+":"+child.getTextContent());
					}
					
				}
			}
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
