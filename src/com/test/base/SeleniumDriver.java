package com.test.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
			// File file = new File("files/firebug-2.0.7-fx.xpi");
			// FirefoxProfile profile = new FirefoxProfile();
			// try {
			// profile.addExtension(file);
			// } catch (IOException e) {
			// e.printStackTrace();
			// }
			// profile.setPreference("extensions.firebug.currentVersion",
			// "2.0.7");
			// // active firebug extensions
			// profile.setPreference("extensions.firebug.allPagesActivation",
			// "on");
			// driver = new FirefoxDriver(profile);
			driver = new FirefoxDriver();
		} else if ("ie".equals(Config.Browser)) {

		} else if ("chrome".equals(Config.Browser)) {

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
