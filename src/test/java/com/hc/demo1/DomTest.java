package com.hc.demo1;

import java.io.FileWriter;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

public class DomTest {
	
	@Test
	// 读取 xml 文件 内容
	public void testReadFile() {
		// 1. 创建 对象 SAXreader();
		SAXReader reader = new SAXReader();
		// 2. read xml 文件
		Document doc = null; 
		try {
			doc = reader.read("src/main/resources/aaa.xml");
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		// 3. 取得 root 节点
		Element root = doc.getRootElement();
		System.out.println(root);
		// 4. 取得 具体的元素
		// teachers -> teacher -> name 
		Element name = root.element("teacher").element("name");
		System.out.println(name.getText());
		
		// list 的 遍历
		List<Element> list = root.elements();
		System.out.println(list);
		for(Element e : list) {
			System.out.println(e.element("name").getText());
			System.out.println(e.element("sex").getText());
		}

		// 取得  attribute  。
		Attribute attr = root.element("teacher").attribute("id");
		System.out.println(attr.getText());
	}
	
	@Test
	// 写一个 xml 文件
	public void testWriteXmlFile() throws Exception {
		// 1. 创建一个 document 对象
		Document doc = DocumentHelper.createDocument();
		// 2. 添加元素 root
		Element root = doc.addElement("beans");
		// 3 . 添加其他 元素
		root.addElement("bean").addAttribute("id", "userDao").
			addAttribute("class", "com.hc.dao.UserDaoImpl");
		root.addElement("bean").addAttribute("id", "itemsDao").
			addAttribute("class", "com.hc.dao.ItemsDaoImpl");
		// root.addElement("bean").addAttribute("id", "itemsDao").
			// addAttribute("class", "汉字测试");
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		// 4. 创建一个 XMLWriter 对象
		XMLWriter writer = new XMLWriter(
				new FileWriter("src/main/resources/applicationContext.xml"),
				format);

		// 5.  回写文件 （document 写入到 XMLWriter
		writer.write(doc);
		// 6.  关闭 xmlWriter
		writer.close();
	}
	
	@Test
	// 增加一个 节点一个 xml 文件 （ 添加到 末尾）
	public void testAddElementEnd() throws Exception {
		// 1. 创建 对象 SAXreader();
		SAXReader reader = new SAXReader();
		// 2. read xml 文件
		Document doc = null; 
		try {
			doc = reader.read("src/main/resources/applicationContext.xml");
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		// 3. 取得 root 节点
		Element root = doc.getRootElement();
		// 1. 创建一个 document 对象
		// 2. 添加元素 root
		// 3 . 添加其他 元素
		root.addElement("bean").addAttribute("id", "personDao").
			addAttribute("class", "com.hc.dao.PersonDaoImpl");
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		// 4. 创建一个 XMLWriter 对象
		XMLWriter writer = new XMLWriter(
				new FileWriter("src/main/resources/applicationContext.xml"),
				format);

		// 5.  回写文件 （document 写入到 XMLWriter
		writer.write(doc);
		// 6.  关闭 xmlWriter
		writer.close();
	}
	
	@Test
	// 增加一个 节点一个 xml 文件 （ 添加到 中间）
	public void testAddElementMiddle() throws Exception {
		// 1. 创建 对象 SAXreader();
		SAXReader reader = new SAXReader();
		// 2. read xml 文件
		Document doc = null; 
		try {
			doc = reader.read("src/main/resources/applicationContext.xml");
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		// 3. 取得 root 节点
		Element root = doc.getRootElement();

		@SuppressWarnings("unchecked")
		List<Element> list = root.elements();
		Element insert = DocumentHelper.createElement("bean");
		insert.addAttribute("id", "personDao");
		// 添加 元素
		list.add(2, insert);
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		// 4. 创建一个 XMLWriter 对象
		XMLWriter writer = new XMLWriter(
				new FileWriter("src/main/resources/applicationContext.xml"),
				format);

		// 5.  回写文件 （document 写入到 XMLWriter
		writer.write(doc);
		// 6.  关闭 xmlWriter
		writer.close();
	}
	
	@Test
	//  删除一个 节点一个 xml 文件 （ 添加到 中间）
	public void testDeleteElement() throws Exception {
		// 1. 创建 对象 SAXreader();
		SAXReader reader = new SAXReader();
		// 2. read xml 文件
		Document doc = null; 
		try {
			doc = reader.read("src/main/resources/aaa.xml");
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		// 3. 取得 root 节点
		Element root = doc.getRootElement();

		@SuppressWarnings("unchecked")
		List<Element> list = root.elements();
		Element  teacher2 = list.get(1);
		Element del = teacher2.element("sex");
		teacher2.remove(del);
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		// 4. 创建一个 XMLWriter 对象
		XMLWriter writer = new XMLWriter(
				new FileWriter("src/main/resources/aaa.xml"),
				format);

		// 5.  回写文件 （document 写入到 XMLWriter
		writer.write(doc);
		// 6.  关闭 xmlWriter
		writer.close();
	}
	
}


