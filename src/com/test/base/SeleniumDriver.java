package com.test.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.test.bean.Config;

public class SeleniumDriver {
	public WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	// 初始化
	public SeleniumDriver() {
		this.initDriver();
	}

	private WebDriver initDriver() {
		if ("firefox".equals(Config.Browser)) {
			driver = new FirefoxDriver();
		} else if ("ie".equals(Config.Browser)) {
			System.setProperty("webdriver.ie.driver",
					"files/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if ("chrome".equals(Config.Browser)) {
			System.setProperty("webdriver.chrome.driver",
					"files/chromedriver.exe");
			driver = new ChromeDriver();
			// Navigation navigation = driver.navigate();
			// navigation.to("https://www.baidu.com");
		} else {
			System.out.println("浏览器匹配值错误" + Config.Browser);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts()
				.pageLoadTimeout(Config.waitTime, TimeUnit.SECONDS);
		return driver;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 定义对象的时候同时初始化，因为有构造函数
		SeleniumDriver selenium = new SeleniumDriver();
		WebDriver driver = selenium.getDriver();
		driver.navigate().to("http://www.baidu.com");
		driver.close();
	}

}
