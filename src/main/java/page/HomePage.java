package page;

import com.wbc.appium.appium.BasePage;
import element.HomeEle;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class HomePage extends BasePage {
	private HomeEle ele;
	public HomePage(AndroidDriver<AndroidElement> driver) throws Exception {
		super(driver, "首页");
		this.ele = new HomeEle();
	}
	
	public void tapTakePhoto() throws Exception {
//		myDriver.tapBean(ele.homeTakePhotoBtn());
		myDriver.tapAToConfirmIdVisible(ele.homeTakePhotoBtn(), ele.goLand_ID);
	}
	
	public void tryTapAllowBtn() throws Exception {
//		myDriver.tryTapBean(ele.allowBtn());
	}

}
