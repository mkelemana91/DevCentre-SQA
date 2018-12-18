package driver_handlers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class WebDriverHandler {

    public static WebDriver driver;
    public static Properties prop;

    public WebDriverHandler() {

        prop = new Properties();

        try {
            FileInputStream propFile = new FileInputStream(System.getProperty("user.dir")+
                    "/src/main/resources/webconfig.properties");
            prop.load(propFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startBrowser(){

        String browserName = prop.getProperty("browser");

        if("chrome".equalsIgnoreCase(browserName))
            driver = new ChromeDriver();
        else if("firefox".equalsIgnoreCase(browserName))
            driver = new FirefoxDriver();
        else
            System.out.print("unable to start " + browserName + " browser");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));

    }

    public void closeBrowser(){

        driver.manage().deleteAllCookies();
        //driver.close();
        driver.quit();

    }

}
