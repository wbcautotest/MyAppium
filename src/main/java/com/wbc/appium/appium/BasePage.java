package com.wbc.appium.appium;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
	public WebDriver driver;
	public MyDriver myDriver;
	public String page;
	public Logger logger = Logger.getRootLogger();

	public BasePage(WebDriver driver, String page) throws Exception {
		this.driver = driver;
		this.page = page;
		if (myDriver == null) {
			myDriver = new MyDriver();
		}
	}

	public WebDriver getDriver() {
		return driver;
	}
}
