// Write a program to access an XML Document using DOM Parser (Java API):

import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class DomBookParser
{
	public static void main(String[] args)
	{
		try
        	{
            		System.out.println("\nDOM Parser using Java API\n");

            		DocumentBuilderFactory fact1 = DocumentBuilderFactory.newInstance();
            		fact1.setValidating(true);
            		fact1.setIgnoringElementContentWhitespace(true);
            		DocumentBuilder build1 = fact1.newDocumentBuilder();

            		String book1 = "book.xml";
            		Document bookdoc = build1.parse(new File(book1));
            		Element bookele = bookdoc.getDocumentElement();
            		NodeList chapternodes = bookele.getChildNodes();

            		for(int i=0; i<chapternodes.getLength(); i++)
            		{
                		Element chapter = (Element)chapternodes.item(i);
                
                		NodeList numberlist = chapter.getElementsByTagName("chapNum");
                		NodeList namelist = chapter.getElementsByTagName("chapTitle");

                		Text number = (Text)numberlist.item(0).getFirstChild();
                		Text name = (Text)namelist.item(0).getFirstChild();
                
                		System.out.println("Tag Name: " + chapter.getNodeName());
                		System.out.println("\tChapter Number: " + number.getData());
                		System.out.println("\tChapter Name: " + name.getData() + "\n");
            		}
        	}
        	catch(Exception e)
        	{
            		System.err.println(e.getMessage());
        	}
	}
}