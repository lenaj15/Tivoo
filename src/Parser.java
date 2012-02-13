import org.jdom.*;
import org.jdom.input.SAXBuilder;
import java.io.IOException;
import java.util.*;
import java.io.File;
import org.jdom.xpath.XPath;

public class Parser {
	
	public static void main (String[] args){

	SAXBuilder builder = new SAXBuilder();
	
	try {
		 
		Document document = (Document) builder.build("http://www.cs.duke.edu/courses/spring12/cps108/assign/02_tivoo/data/dukecal.xml");
		Element rootNode = document.getRootElement();
		List list = rootNode.getChildren("event");
		
		
		for (int i = 0; i < list.size(); i++) {
			
		   Element node = (Element) list.get(i);
		   String child = node.getChildText("summary");
		   if (child.contains("Duke")){
			   list.remove(i);
		   }
		   else{
		   System.out.println("Summary : " + child);
		   }
		}
 
	  } catch (Throwable e){
		  System.out.println(e);
	  }
	
}
	}
