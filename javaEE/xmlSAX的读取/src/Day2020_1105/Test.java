package Day2020_1105;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = null;
		try {
			parser = factory.newSAXParser();
			parser.parse(new File("C:"+File.separator+"java"+File.separator+"sql xml.xml"), new MySax());
		} catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
