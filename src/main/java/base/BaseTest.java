package base;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import appium.*;
import page.HomePage;

public class BaseTest extends AppTest {
	private static HomePage homePage;
	Logger logger = Logger.getRootLogger();
	public HomePage HomePage() throws Exception {
		if (homePage == null) {
			homePage = new HomePage(driver);
		}
		return homePage;
	}
	
	@Before
	public void setUp() throws Exception {
		driver = AppTest.getDriver();
		logger.debug("开始执行"+caseName());
	}
	
	@After
	public void tearDown() throws Exception {
		if (driver != null) {
			BaseDriver.delay(10);
			driver.quit();
		}
	}
}
