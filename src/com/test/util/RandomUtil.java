package com.test.util;

public class RandomUtil {

	private static int getRandom(int count) {
		return (int) Math.round(Math.random() * (count));
	}

	private static String string = "0123456789abcdefghijklmn"
			+ "opqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ";

	private static String getRandomString(int length) {
		StringBuffer sb = new StringBuffer();
		int len = string.length();
		for (int i = 0; i < length; i++) {
			sb.append(string.charAt(getRandom(len - 1)));
		}
		return sb.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomUtil ru = new RandomUtil();
		for (int i = 0; i < 10; i++) {
			System.out.println(RandomUtil.getRandomString(6));
		}
	}
}
