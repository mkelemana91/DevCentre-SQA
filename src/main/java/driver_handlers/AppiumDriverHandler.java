package driver_handlers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class AppiumDriverHandler {

    public static Properties mobileProp;
    public static AppiumDriver<MobileElement> mobileDriver;



    public AppiumDriverHandler(){

        mobileProp = new Properties();


        try {
            FileInputStream propFile = new FileInputStream(System.getProperty("user.dir")+
                    "/src/main/resources/mobileconfig.properties");
            mobileProp.load(propFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void launchApp(){
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //capabilities.setCapability(MobileCapabilityType.UDID,mobileProp.getProperty("udid"));
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,mobileProp.getProperty("deviceName"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,mobileProp.getProperty("platformName"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,mobileProp.getProperty("platformVersion"));
        capabilities.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+"/apk/android-UniversalMusicPlayer.apk");

        //mobileDriver = new AndroidDriver<MobileElement>(capabilities);
        try {

            mobileDriver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void closeApp(){

        mobileDriver.quit();

    }
}
