package com.test.testcases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.page.FirstPage;
import com.test.page.LoginPage;
import com.test.util.Assertion;
import com.test.util.Log;

public class Login extends TestBase {

	@Test(dataProvider = "providerMethod")
	public void testLogin(Map<String, String> param)
			throws InterruptedException {
		Assertion.flag = true;
		this.goTo(param.get("url"));
		Thread.sleep(5);

		// ((JavascriptExecutor) this.driver).executeScript("login();");
		FirstPage fp = new FirstPage(driver);
		Log.logInfo("在首页点击登录按钮");
		fp.getElement("login_link").click();
		LoginPage lp = new LoginPage(driver);
		Log.logInfo("登录用户名为：" + param.get("username"));
		lp.getElement("login_name").sendKeys(param.get("username"));
		Log.logInfo("登录密码为：" + param.get("password"));
		lp.getElement("login_pwd").sendKeys(param.get("password"));
		lp.getElement("login_button").click();
		String errorMsg = lp.getElement("loginpwd_error").getText().trim();
		Log.logInfo("错误信息为：" + errorMsg);
		Assert.assertEquals(errorMsg, "账户名与密码不匹配，请重新输入");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
