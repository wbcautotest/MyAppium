package com.wbc.appium.appium;

import static org.junit.Assert.fail;

import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriverException;

import io.appium.java_client.android.AndroidElement;
import tools.HandleBridge;

public class MyDriver extends AppTest {
	AndroidElement element;
	public Logger logger = Logger.getRootLogger();

	public static void delay(int time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @描述：尝试点击一个元素
	 * @作者：wbc
	 * @param element
	 * @throws Exception
	 */
	public void tryTapBean(AndroidElement element) throws Exception {
		try {
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
		logger.debug("点击" + element.toString());
	}

	/**
	 * @描述：使用id判断元素是否存在
	 * @作者：wbc
	 * @param id 
	 * @param isShow
	 * 
	 * @return
	 */
	public Boolean isIdElementExist(String id) {
		AndroidElement ae;
		try {
			ae = driver.findElementById(id);
			if (ae.isDisplayed()) {
				System.out.println(ae.isDisplayed() + "isIdElementExist");
				return true;
			} else {
				System.out.println(ae.isDisplayed() + "isIdElementExist");
				return false;
			}
		} catch (WebDriverException e) {
			return false;
		}
	}

	public void tapAToConfirmIdVisible(AndroidElement elementA, String id) throws Exception {
		tapAToConfirmIdVisible(elementA, id, 5, () -> {
			return false;
		});
	}

	/**
	 * @描述：点击元素A，确认 id存在于点击后的页面
	 * @作者：wbc
	 * @param elementA
	 * @param id
	 * @throws Exception
	 */
	private void tapAToConfirmIdVisible(AndroidElement elementA, String id, int time, HandleBridge handle)
			throws Exception {
		boolean isExit = false;
		boolean isSucces = true;
		for (int i = 0; i < 5; i++) {
			if (i == 0) {
				tapBean(elementA);
			} else {
				tryTapBean(elementA);
			}
			if (handle.handleSomething() == false) {
				isSucces = false;
			}
			for (int j = 0; j < time; j++) {
				if (isIdElementExist(id) == true) {
					System.out.println(id + "tapAToConfirmIdVisible");
					isExit = true;
					break;
				}
				System.out.println("等待中....");
				delay(1);
			}
			System.out.println(isExit);
			if (isExit) {
				break;
			}
			if (isExit == false) {
				throw new NoSuchElementException("未匹配到 ： " + id);
			}
		}
		if (isSucces == false) {
			throw new NullPointerException();
		}
	}
}
