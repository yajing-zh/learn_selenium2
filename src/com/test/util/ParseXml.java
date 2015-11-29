package com.test.util;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/*
 * 读取xml配置文件
 * 	1. 加载
 * 	2. 解析
 */
public class ParseXml {

	private static Document document;
	private String filePath;

	// 为了简化代码，否则每次都要px.load
	public ParseXml(String filePath) {
		this.filePath = filePath;
		this.load(filePath);
	}

	public void load(String filePath) {
		// xml解析，首先载入xml文件，对这个文件对象进行xml分析处理
		File file = new File(filePath);
		if (file.exists()) {
			SAXReader saxReader = new SAXReader();
			try {
				document = saxReader.read(file);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				System.out.println("文件加载异常" + filePath);
			}
		} else {
			System.out.println("文件加载异常" + filePath);
		}
		// document.selectSingleNode(arg0)
	}

	// 读取xml结点
	public Element getElementObject(String elementPath) {
		return (Element) document.selectSingleNode(elementPath);
	}

	public String getElementText(String elementPath) {
		Element element = this.getElementObject(elementPath);
		if (element != null) {
			return element.getTextTrim();
		} else {
			return null;
		}
	}

	/*
	 * 判断结点是否为空
	 */
	public boolean isExist(String elementPath) {
		boolean flag = false;
		Element element = this.getElementObject(elementPath);
		if (element != null) {
			flag = true;
		}
		return flag;
	}

	/*
	 * 遍历结点
	 */
	// 加@是为了无视方法里边出现的警告
	@SuppressWarnings("unchecked")
	public List<Element> getElementObjects(String elementPath) {
		return document.selectNodes(elementPath);
	}

	// 遍历到map中
	@SuppressWarnings("unchecked")
	public Map<String, String> getChildrenInfoByElement(Element element) {
		Map<String, String> map = new HashMap<String, String>();
		List<Element> children = element.elements();
		for (Element e : children) {
			map.put(e.getName(), e.getText());
		}
		return map;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ParseXml px = new ParseXml();
		// px.load("config/config.xml");
		ParseXml px = new ParseXml("config/config.xml");
		String browser = px.getElementText("/*/browser");
		System.out.println(browser);
		String waitTime = px.getElementText("/*/waitTime");
		System.out.println(waitTime);

		// ParseXml px = new ParseXml("config/config.xml");
		// List<Element> elements = px.getElementObjects("/*/testUI");
		// Object[][] object = new Object[elements.size()][];
		// for (int i = 0; i < elements.size(); i++) {
		// Object[] temp = new Object[] { px.getChildrenInfoByElement(elements
		// .get(i)) };
		// object[i] = temp;
		// }
		// Object o = object[1][0];
		// System.out.println(((Map<String, String>) o).get("description"));

	}
}
