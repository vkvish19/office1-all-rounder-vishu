package vishu.personal.main;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomXmlParserMain {

	public static void main(String[] args) {
		try{
			File xmlFile = new File("DomParseFile.xml");
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(xmlFile); 
			
			document.getDocumentElement().normalize();
			
			System.out.println("Root Element:- " +document.getDocumentElement().getNodeName());
			
			NodeList nList = document.getElementsByTagName("student");
			System.out.println("-------------------------------------------------");
			
			for(int i=0; i<nList.getLength(); i++){
				Node node = nList.item(i); 
				NodeList childList = node.getChildNodes();
				for(int j=0; j<childList.getLength(); j++){
					Node childNode = childList.item(j);
					System.out.println("Node Name:- " +childNode.getNodeName() +" and its value is:- " +childNode.getNodeValue());
					
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
