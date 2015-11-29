package com.test.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Page extends Locator {
	public Page(WebDriver driver) {
		super(driver);
		this.setYamlFile(this.getClass().getSimpleName());
		this.getYamlFile();
		this.driver = driver;
	}

	public Actions getActions() {
		return new Actions(driver);
	}

	public void switchWindowByIndex(int index) {
		Object[] handles = driver.getWindowHandles().toArray();
		if (index > handles.length) {
			return;
		}
		driver.switchTo().window(handles[index].toString());
	}

	public boolean isExist(WebElement element) {
		if (element == null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
