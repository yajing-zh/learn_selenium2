package com.test.testcases;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.test.base.Locator;
import com.test.base.SeleniumDriver;
import com.test.base.TestBase;

public class Test1 extends TestBase {

	@Test(dataProvider = "providerMethod")
	public void testLogin(Map<String, String> param) {
		System.out.println(param.get("username"));
		System.out.println(param.get("password"));
		System.out.println(param.get("inputValue"));
		System.out.println(param.get("url"));
		System.out.println(param.get("key"));
	}

	@Test(dataProvider = "providerMethod")
	public void testLogout(Map<String, String> param) {
		System.out.println(param.get("username"));
		System.out.println(param.get("password"));
		System.out.println(param.get("inputValue"));
		System.out.println(param.get("url"));
		System.out.println(param.get("key"));

		SeleniumDriver selenium = new SeleniumDriver();
		WebDriver driver = selenium.getDriver();
		Locator l = new Locator(driver);
		driver.navigate().to(param.get("url"));
		WebElement element;
		// element = l.getElement(param.get("inputValue"));
		// String[] replace = new String[] { "k,w" };
		// System.out.println(replace);
		element = l.getElement("baidu_input", new String[] { "kw" });
		element.sendKeys(param.get("key"));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
