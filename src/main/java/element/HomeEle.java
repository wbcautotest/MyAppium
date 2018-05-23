package element;

import com.wbc.appium.appium.BaseElement;
import io.appium.java_client.android.AndroidElement;

public class HomeEle extends BaseElement {
	public String homeTakePhotoBtn_ID = "com.benqu.wuta:id/home_setting";
	public String goLand_ID = "com.benqu.wuta:id/setting_login_no_user";
	public HomeEle() throws Exception {
		super("首页");
	}
	
	public AndroidElement homeTakePhotoBtn() {
		return BaseElement.findElementByID(homeTakePhotoBtn_ID, "首页拍照按钮");
	}

}
