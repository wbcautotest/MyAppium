package base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriverException;
import appium.*;
import io.appium.java_client.android.AndroidElement;
import tools.HandleBridge;

public class BaseDriver extends AppTest {
	private BaseElement baseElement;
	public Logger logger = Logger.getRootLogger();

	public BaseDriver() {
		if (baseElement == null) {
			baseElement = new BaseElement("");
		}
	}

	/**
	 * @描述：等待time秒（注意，不能超过60，否则超过appium的超时时间
	 * @作者：wbc
	 * @param time
	 */
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
	 * @param list
	 * @throws Exception
	 */
	public void tapBean(AndroidElement element) throws Exception {
		element.click();
		logger.debug("点击" + baseElement.getPageDec() + baseElement.getBtnName());
		BaseDriver.delay(1);
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
				return true;
			} else {
				return false;
			}
		} catch (WebDriverException e) {
			return false;
		}
	}

	/**
	 * @描述：点击A判断B是否存在
	 * @作者：wbc
	 * @param elementA
	 * @param id
	 * @throws Exception
	 */
	public void tapAToConfirmIdVisible(AndroidElement elementA, String id) throws Exception {
		tapAToConfirmIdVisible(elementA, id, 5, () -> {
			return true;
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
		for (int i = 0; i < 5; i++) {
			if (i == 0) {
				tapBean(elementA);
			} else {
				tryTapBean(elementA);
			}
			if (handle.handleSomething() == false) {
				break;
			}
			for (int j = 0; j < time; j++) {
				if (isIdElementExist(id) == true) {
					logger.debug("判断的元素  ：" + baseElement.getBtnName() + " 存在");
					isExit = true;
					break;
				}
				System.out.println("等待中....");
				delay(1);
			}
			if (isExit) {
				break;
			}
		}
	}
}
