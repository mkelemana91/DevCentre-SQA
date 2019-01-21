package pages.Mobile;

import driver_handlers.AppiumDriverHandler;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Mobile_LoginPage extends AppiumDriverHandler {
    //Using FindBy because the script is test Web View / Browser
    @FindBy(id = "mat-input-0")
    MobileElement _emailTextbox;

    @FindBy(id = "mat-input-1")
    MobileElement _passwordTextbox;

    //@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[3]/android.widget.Button")
    @FindBy(xpath = "//*[contains(text(),'Sign in')]")
    MobileElement _signButton;


    public Mobile_LoginPage() {

        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), this);
    }

    public LandingPage signIn(String user, String pass) {
        _emailTextbox.sendKeys(user);
        _passwordTextbox.sendKeys(pass);
        _signButton.click();

        return new LandingPage();

    }
}
