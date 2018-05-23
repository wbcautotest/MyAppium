package com.wbc.appium.appium;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import io.appium.java_client.android.AndroidElement;

public class BaseElement extends AppTest {
	public String page;
	public String btnName;
	public static Logger logger = Logger.getRootLogger();
	public BaseElement(String page) throws Exception {
		this.page = page;
	}
	
	/**
	 * @描述：使用ID找到一个元素
	 * @作者：wbc
	 * @param id 元素id
	 * @param btnName 按钮名称
	 * @return 返回Android 元素类型
	 * @throws Exception
	 */
	public static  AndroidElement findElementByID(String id, String btnName) {
		logger.debug("找到"+btnName);
		return driver.findElement(By.id(id));
	}
	
	public String getBtnName() {
		return btnName;
	}
}

