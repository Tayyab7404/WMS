// Write a program to access an XML Document using SAX Parser (Java API):

import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class SAXBookParser extends DefaultHandler
{
	protected boolean pChapNum;
	protected boolean pChapTitle;
	protected StringBuffer cChapNum;
	protected StringBuffer cChapTitle;

	public static void main(String args[])
	{
		try
		{
			SAXParserFactory fact1 = SAXParserFactory.newInstance();
			fact1.setValidating(true);
			SAXParser build1 = fact1.newSAXParser();
			String book1 = "book.xml";
			SAXBookParser event = new SAXBookParser();
			build1.parse(new File(book1), event);
		}
		catch(Exception e)
		{
			System.err.println("Error Parsing: " + e.getMessage());
			System.exit(1);
		}
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes)
	{
		if(qName.compareTo("chapter") == 0)
		{
			cChapTitle = null;
			cChapNum = null;
		}
		else if(qName.compareTo("chapNum") == 0)
		{
			pChapNum = true;
			cChapNum = new StringBuffer();
		}
		else if(qName.compareTo("chapTitle") == 0)
		{
			pChapTitle = true;
			cChapTitle = new StringBuffer();
		}
	}

	public void characters(char[] cha, int start, int length)
	{
		if(pChapTitle)
		{
			cChapTitle.append(cha, start, length);
		}
		else if(pChapNum)
		{
			cChapNum.append(cha, start, length);
		}
	}

	public void endElement(String namespaceURI, String localName, String qName)
	{
		if(qName.compareTo("chapter") == 0)
		{
			System.out.print("Chapter ");

			if(cChapNum != null)
			{
				System.out.print(cChapNum.toString());
				System.out.print(": ");
			}
			if(cChapTitle != null)
			{
				System.out.print(cChapTitle.toString());
			}
			
			System.out.println();
		}
		else if(qName.compareTo("chapTitle") == 0)
		{
			pChapTitle = false;
		}
		else if(qName.compareTo("chapNum") == 0)
		{
			pChapNum = false;
		}
	}
}