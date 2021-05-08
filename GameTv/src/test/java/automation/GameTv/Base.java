package automation.GameTv;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Base {
	
	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement>  driver;
	public static  String userName;
	public static String password;
	public static Properties prop;
	
	public void loadProperties() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("src/test/java/config/global.properties");
			prop=new Properties();
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public AppiumDriverLocalService startServer() {
		boolean flag=	checkIfServerIsRunnning(4723);
		if(!flag)
		{
			AppiumServiceBuilder builder = new AppiumServiceBuilder()
					.withAppiumJS(new File(prop.getProperty("appiumMainjsFile")));
					service = builder.build();
			service.start();
		}
		return service;
	}
	
	public static boolean checkIfServerIsRunnning(int port) {	
			boolean isServerRunning = false;
			ServerSocket serverSocket;
			try {
				serverSocket = new ServerSocket(port);
				
				serverSocket.close();
			} catch (IOException e) {
				//If control comes here, then it means that the port is in use
				isServerRunning = true;
			} finally {
				serverSocket = null;
			}
			return isServerRunning;
	}

	public static void capabilities() throws IOException, InterruptedException {		
		userName= prop.getProperty("username");
		password= prop.getProperty("password");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		String device=(String) prop.get("device");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,14);
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("appPackage",prop.get("package"));
		capabilities.setCapability("appActivity",prop.get("activity"));
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
