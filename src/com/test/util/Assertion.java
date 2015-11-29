package com.test.util;

import org.testng.Assert;

public class Assertion {
	public static boolean flag = true;

	public static void verifyEquals(Object actual, Object expected) {
		try {
			Assert.assertEquals(expected, actual);
		} catch (Error e) {
			flag = false;
			Log.logError("数据对比错误-> 期望值为:" + expected + "实际值为:" + actual);
		}
	}

	public static void verifyEquals(Object actual, Object expected,
			String message) {
		try {
			Assert.assertEquals(expected, actual, message);
		} catch (Error e) {
			flag = false;
			Log.logError("数据对比错误-> 期望值为:" + expected + "实际值为:" + actual);
		}
	}
}
