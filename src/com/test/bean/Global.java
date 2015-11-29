package com.test.bean;

import java.util.Map;

import com.test.util.ParseXml;

public class Global {

	public static Map<String, String> global;
	static {
		ParseXml px = new ParseXml("test-data/global.xml");
		// 读取的为<url>
		global = px.getChildrenInfoByElement(px.getElementObject("/*"));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
