package com.test.base;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Element;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import com.test.bean.Config;
import com.test.bean.Global;
import com.test.util.ParseXml;

public class TestBase {
	protected WebDriver driver;
	private ParseXml px;
	private Global global;
	private Map<String, String> commonMap;

	private void initialPx() {
		// 此处用到了单列模式，在调用时，为null就new一个对象，如果不为null就不产生新的对象
		if (px == null) {
			// 得到当前的class名称
			px = new ParseXml("test-data/" + this.getClass().getSimpleName()
					+ ".xml");
		}
	}

	private void getCommonMap() {
		// 此处也用到了单列模式
		if (commonMap == null) {
			Element element = px.getElementObject("/*/common");
			commonMap = px.getChildrenInfoByElement(element);
		}
	}

	@DataProvider
	public Object[][] providerMethod(Method method) {
		// px = new ParseXml("test-data/" + this.getClass().getSimpleName()
		// + ".xml");
		this.initialPx();
		this.getCommonMap();
		// 得到当前class文件中当前的method名称，以便过滤xml文件
		String methodName = method.getName();

		// "/*/" + methodName代表的是Test1.xml的第二层,即<testLogin>
		List<Element> elements = px.getElementObjects("/*/" + methodName);
		Object[][] object = new Object[elements.size()][];
		for (int i = 0; i < elements.size(); i++) {
			// Object[] temp = new Object[] {
			// px.getChildrenInfoByElement(elements
			// .get(i)) };
			// Object[] temp = new Object[] { this.getMergeMapData(
			// px.getChildrenInfoByElement(elements.get(i)), commonMap) };
			Map<String, String> mergeCommon = this.getMergeMapData(
					px.getChildrenInfoByElement(elements.get(i)), commonMap);
			Map<String, String> mergeGlobal = this.getMergeMapData(mergeCommon,
					global.global);
			Object[] temp = new Object[] { mergeGlobal };
			object[i] = temp;
		}
		return object;
	}

	@SuppressWarnings("unused")
	private Map<String, String> getMergeMapData(Map<String, String> map1,
			Map<String, String> map2) {
		Iterator<String> it = map2.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			String value = map2.get(key);
			if (!map1.containsKey(key)) {
				map1.put(key, value);
			}
		}
		return map1;
	}

	@BeforeClass
	public void initialDriver() {
		SeleniumDriver selenium = new SeleniumDriver();
		driver = selenium.getDriver();
	}

	// @AfterClass
	// public void closeDriver() {
	// if (driver != null) {
	// driver.close();
	// driver.quit();
	// }
	// }

	public void goTo(String url) {
		driver.get(url);
		if (Config.Browser.equals("firefox")) {
			// Util.sleep(1);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
