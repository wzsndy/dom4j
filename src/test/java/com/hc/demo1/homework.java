package com.hc.demo1;



import java.io.FileWriter;
import java.io.InputStream;
import java.util.Scanner;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

public class homework {
		
	
	@Test
	public void testAddfile() throws Exception{
		Scanner scan=new Scanner(System.in);
		String id=scan.next();
		String name=scan.next();
		String sex=scan.next();
		String value=scan.next();
		SAXReader reader=new SAXReader();
		Document doc=null;
		doc=reader.read("src/main/resources/user.xml");
		Element root=doc.getRootElement();
		root.addElement("bean").addAttribute("id", id).addAttribute("name", name).addAttribute("sex", sex)
		.addAttribute("value", value);
		OutputFormat format=OutputFormat.createCompactFormat();
		format.setEncoding("utf-8");
		XMLWriter writer=new XMLWriter(new FileWriter("src/main/resources/user.xml"),format);
	 writer.write(doc);
	 writer.close();
	}
	public void testdeletfile() throws Exception{
	SAXReader reader=new SAXReader();
	Document doc=null;
	doc=reader.read("src/main/resources/user.xml");
	}
	
	
@Test(timeout=1000)
public void testadd(){
	int sum=1;
	System.out.println(sum);
	for(int i=1;i<100000;i++){
	sum=sum+i;
	System.out.println(sum);
	
	}
	
}
	
}

