package Day2020_1105;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MySax extends DefaultHandler{

	@Override
	public void startDocument() throws SAXException {
		System.out.println("开始读取文件");
	}

	@Override
	public void endDocument() throws SAXException {
		
		System.out.println("文件读取完成");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		//输出标签里的属性
		if(attributes.getLength()>0){
			System.out.print("<"+qName);
			for(int i =0;i<attributes.getLength();i++){
				System.out.print(" ");
				System.out.print(attributes.getQName(i)+" "+attributes.getValue(i)+">");		
			}
		}else{
			System.out.print("<"+qName+">");
		}
		
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("</"+qName+">");
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String str = new String(ch,start,length);
		System.out.print(str);
	}
	
}
