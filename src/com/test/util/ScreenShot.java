package com.test.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	public WebDriver driver;

	public ScreenShot(WebDriver driver) {
		this.driver = driver;
	}

	public void takeScreenShot(String screenPath) {
		try {
			File srcFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File(screenPath));
		} catch (IOException e) {
			System.out.println("Screen shot error: " + screenPath);
		}
	}

	public void takeScreenShot() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String screenName = String.valueOf(sdf.format(new Date().getTime())
				+ ".jpg");
		File dir = new File("test-output/snapshot");
		if (!dir.exists()) {
			dir.mkdir();
		}
		String screenPath = dir.getAbsolutePath() + File.separator + screenName;
		this.takeScreenShot(screenPath);
	}
}
