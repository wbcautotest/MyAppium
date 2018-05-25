package base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
	public WebDriver driver;
	public BaseDriver myDriver;
	public Logger logger = Logger.getRootLogger();

	public BasePage(WebDriver driver) throws Exception {
		this.driver = driver;
		if (myDriver == null) {
			myDriver = new BaseDriver();
		}
	}
}
