package com.test.bean;

import com.test.util.ParseXml;

public class Config {

	public static String Browser;
	public static int waitTime;

	// static是个静态写法，无论怎么执行，static只会执行一次
	static {
		ParseXml px = new ParseXml("config/config.xml");
		Browser = px.getElementText("/*/browser");
		// 强制转换为整型
		waitTime = Integer.valueOf(px.getElementText("/*/waitTime"));

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 把init改写成static之后就不用每次手动调用init方法了，会自动调用staic，其只会执行一遍。
		// config my = new config();
		// my.init();
		System.out.println(Browser);
		System.out.println(waitTime);
	}
}
