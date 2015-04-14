/**
* ReadInputFromXML --- program to print "Fibonacci Numbers".
* @author Jananjoy 
* 
*/
package com.main.code;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ReadInputFromXML {

	private int firstElement;  // First  Number of the Fibonacci number
	private int secondElement; // second Number of the Fibonacci number
	private int totalElement;  // total  Number of the Fibonacci number
	
	/**
	   * To read the Data from the XML parser 
	   * @param no arguments. 
	   * @exception Any exception
	   * @return an integer value(first element of the series)
	   */
    public int getFirstElement() {
	
    	return firstElement;
    	
	}

	/**
	   * To read the Data from the XML parser 
	   * @param no arguments. 
	   * @exception Any exception
	   * @return an integer value(second element of the series)
	   */
	public int getSecondElement() {
	
		return secondElement;
		
	}

	/**
	   * To read the Data from the XML parser 
	   * @param no arguments. 
	   * @exception Any exception
	   * @return an integer value(total element of the series)
	   */
	public int getTotalElement() {
		
		return totalElement;
		
	}
	
	/**
	   * To read the Data from the XML parser 
	   * @param no arguments. 
	   * @exception Any exception
	   * @return No return value
	   */
	void readData() {	
		
	    try {
	    	
			File fXmlFile = new File( "DataSource/fibonacci.xml" );
			DocumentBuilderFactory dbFactoryref = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactoryref.newDocumentBuilder();
			Document documentRef = dBuilder.parse( fXmlFile );
			documentRef.getDocumentElement().normalize();
			System.out.println("Root element :" + documentRef.getDocumentElement().getNodeName());
			NodeList nList = documentRef.getElementsByTagName( "Fibonacci" );
			System.out.println("----------------------------");
				for (int index = 0; index < nList.getLength(); index++) {
					
					Node myNode = nList.item( index );
					System.out.println("\nCurrent Element :" + myNode.getNodeName());
					
					if (myNode.getNodeType() == Node.ELEMENT_NODE) {
						
						Element eElement = (Element) myNode;
						System.out.println("Fibonacci id : " + eElement.getAttribute("id"));
						System.out.println("FirstNumber: " + eElement.getElementsByTagName("firstElement").item(0).getTextContent());
						System.out.println("SecondNumber: " + eElement.getElementsByTagName("secondElement").item(0).getTextContent());
						System.out.println("TotalElement: " + eElement.getElementsByTagName("totalElement").item(0).getTextContent());
					
						firstElement  = Integer.parseInt(eElement.getElementsByTagName("firstElement").item(0).getTextContent());
						secondElement = Integer.parseInt(eElement.getElementsByTagName("secondElement").item(0).getTextContent());
						totalElement  = Integer.parseInt(eElement.getElementsByTagName("totalElement").item(0).getTextContent());
						
					}// End of the If() condition 
					
				}// End of the for loop
				
	    	}// End of the try case 
	    	catch(Exception e) {
	    		
			e.printStackTrace();
			
	    	} // End of the catch() condition 
	    
	    } // End of the readData() method

} // End of the class ReadInputFromXML
