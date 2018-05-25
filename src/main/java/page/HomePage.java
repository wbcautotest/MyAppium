package page;


import base.BasePage;
import element.HomeEle;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class HomePage extends BasePage {
	private HomeEle ele;
	public HomePage(AndroidDriver<AndroidElement> driver) throws Exception {
		super(driver);
		this.ele = new HomeEle();
	}
	
	public void tapTakePhoto() throws Exception {
		myDriver.tapAToConfirmIdVisible(ele.homeTakePhotoBtn(), ele.goLand_ID);
	}
	
	public void tryTapAllowBtn() throws Exception {
//		myDriver.tryTapBean(ele.allowBtn());
	}

}
