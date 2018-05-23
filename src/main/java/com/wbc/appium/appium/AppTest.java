package com.wbc.appium.appium;

import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppTest {
	public static AndroidDriver<AndroidElement> driver = null;
	private static DesiredCapabilities caps = new DesiredCapabilities(); // 初始化

	public static AndroidDriver<AndroidElement> getDriver() throws Exception {
		caps.setCapability("platformName", "Android"); // 设置安卓模式
		caps.setCapability("platformVersion", "7.1.1"); // 设置版本号
		caps.setCapability("udid", driverID()); // 设置 driverID
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Meitu T8s"); // 设置机器设备信息
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.benqu.wuta");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.benqu.wuta.activities.splash.SplashActivity");
		caps.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, ".activities.home.HomeActivity");
// 		caps.setCapability(MobileCapabilityType.APP, AppTest.apkPath()); // 设置apk路径
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "600"); // 设置超时时间
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium"); // 设置运行的默认引擎
		caps.setCapability(MobileCapabilityType.NO_RESET, true);
		driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
		return driver;
	}

	public static String driverID() {
		return "K51LHP1782600564";
	}

	public static String apkPath() {
		return "C:\\Users\\wbc\\Desktop\\新建文件夹 (2)\\无他相机.apk";
	}

}
