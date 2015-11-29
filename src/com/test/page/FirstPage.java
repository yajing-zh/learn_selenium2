package com.test.page;

import org.openqa.selenium.WebDriver;

import com.test.base.Page;

public class FirstPage extends Page {

	public FirstPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void linkToMobileList() {
		this.getActions().moveToElement(this.getElement("sjsmjdtx")).perform();
		this.getElement("sjplrk").click();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
