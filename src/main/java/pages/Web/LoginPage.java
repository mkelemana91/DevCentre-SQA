package pages.Web;

import data_readers.Excel_Reader;
//import driver_handlers.WebDriverHandler;
import driver_handlers.WebDriverHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage extends WebDriverHandler {

    //1. Object Repository
    @FindBy(xpath = ".//*[@id=\"i0116\"]")
    WebElement _usernameTextbox;

    @FindBy(xpath = ".//*[@id=\"idSIButton9\"]")
    WebElement _nextButton;

    @FindBy(xpath = ".//*[@id=\"i0118\"]")
    WebElement _passwordTextbox;

    @FindBy(css = "input[id=idSIButton9]")
    WebElement _nextButton2;

    @FindBy(xpath = "//*[@id=\"idBtn_Back\"]")
    WebElement _backButton;

    Excel_Reader xls = new Excel_Reader("data_source/loginDetails.xlsx");

    //2. Initialization
    public LoginPage() {

        PageFactory.initElements(driver, this);


    }


    //3. Methods
    public void navigateToUrl(){
        startBrowser();
    }

    public void captureEmail() {
        //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        _usernameTextbox.sendKeys("user1@eohmclive.onmicrosoft.com");
        _nextButton.click();
    }

    public HomePage capturePassword() throws InterruptedException {
        Thread.sleep(5000);
        _passwordTextbox.sendKeys("64j!CQZF^y%AF");
        _nextButton2.click();
        _backButton.click();

        return new HomePage();
    }


}
