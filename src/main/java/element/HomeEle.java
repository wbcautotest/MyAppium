package element;

import java.util.List;
import org.openqa.selenium.By;

import base.BaseElement;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;


public class HomeEle extends BaseElement {
	public HomeEle() {
		super(pageDec);
	}

	public String homeTakePhotoBtn_ID = "com.benqu.wuta:id/home_setting";
	public String goLand_ID = "com.benqu.wuta:id/setting_login_no_user";
	
	public AndroidElement homeTakePhotoBtn() throws Exception {
		return initElement(homeTakePhotoBtn_ID, "首页","设置按钮");
	}

}
