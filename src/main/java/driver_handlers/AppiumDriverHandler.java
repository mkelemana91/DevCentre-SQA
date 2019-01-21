package driver_handlers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AppiumDriverHandler {

    public static Properties mobileProp = null;
    public static AppiumDriver<MobileElement> mobileDriver = null;



    public AppiumDriverHandler(){



        if(mobileProp == null) {
            mobileProp = new Properties();
            try {
                FileInputStream propFile = new FileInputStream(System.getProperty("user.dir") +
                        "/src/main/resources/mobileconfig.properties");
                mobileProp.load(propFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        if(mobileDriver == null) {
            //Settings for our mobile device
            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability(MobileCapabilityType.UDID, mobileProp.getProperty("udid"));
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, mobileProp.getProperty("deviceName"));
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, mobileProp.getProperty("platformName"));
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, mobileProp.getProperty("platformVersion"));
            //capabilities.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+"/apk/apkName.apk");
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, mobileProp.getProperty("browser"));

            try {
                //service.start();
                mobileDriver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);


            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        }
    }
    public void launchApp(){
        mobileDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        mobileDriver.get("https://eohmc-omwealth-mobile.azurewebsites.net");
    }

    public void closeApp(){

        mobileDriver.quit();

    }
}
