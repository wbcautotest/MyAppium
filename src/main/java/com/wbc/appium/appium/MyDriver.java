package com.wbc.appium.appium;

import org.apache.log4j.Logger;
import io.appium.java_client.android.AndroidElement;


public class MyDriver extends AppTest{
	AndroidElement element;
	public Logger logger = Logger.getRootLogger();
	/**
	 * @描述：尝试点击一个元素
	 * @作者：wbc
	 * @param element
	 * @throws Exception
	 */
	public void tryTapBean(AndroidElement element) throws Exception {
		try {
			System.out.println(element.isDisplayed());
			if (element.isDisplayed()) {
				System.out.println(element.isDisplayed());
				element.click();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * @描述：点击一个元素
	 * @作者：wbc
	 * @param element
	 * @throws Exception
	 */
	public void tapBean(AndroidElement element) throws Exception {
		element.click();
		logger.debug("点击"+element.toString());
	}
	
	/**
	 * @描述：判断元素是否存在
	 * @作者：wbc
	 * @param id
	 * @param isShow  true 元素存在，false  元素不存在
	 * @return
	 */
	public Boolean isIdElementExist(String id,boolean isShow) {
		AndroidElement ae;
		try {
			if (driver != null) {
				ae = driver.findElementById(id);
				if (isShow) {
					return ae.isDisplayed();
				} else {
					return ae != null;
				}
			} else {
				System.out.println("driver为空");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return isShow;
		
	}
	
	/**
	 * @描述：点击元素A，确认 id存在于点击后的页面
	 * @作者：wbc
	 * @param elementA
	 * @param id
	 * @throws Exception
	 */
	public void tapAToConfirmIdVisible(AndroidElement elementA, String id) throws Exception {
		tapBean(elementA);
		if (isIdElementExist(id, true)) {
			logger.debug(id+"元素存在");
		} else {
			throw new NullPointerException("未找到元素"+id);
		}
	}
}
