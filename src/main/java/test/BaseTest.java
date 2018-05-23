package test;

import org.junit.After;
import org.junit.Before;
import com.wbc.appium.appium.AppTest;
import page.HomePage;

public class BaseTest extends AppTest {
	private static HomePage homePage;
	public HomePage HomePage() throws Exception {
		if (homePage == null) {
			homePage = new HomePage(driver);
		}
		return homePage;
	}
	
	@Before
	public void setUp() throws Exception {
		driver = AppTest.getDriver();
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}
