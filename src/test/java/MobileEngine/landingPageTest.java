package MobileEngine;

import driver_handlers.AppiumDriverHandler;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Mobile.Mobile_LoginPage;
import pages.Web.LoginPage;

public class landingPageTest extends Mobile_LoginPage {
    //GIVEN
    @BeforeClass
    public void setUp(){
        launchApp();
      }
    //WHEN + THEN
   @Test
    public void login() {

        signIn("user2@eohmclive.onmicrosoft.com", "password123");
   }
    @AfterClass
    public void tearDown(){
       //closeApp();
    }


}
