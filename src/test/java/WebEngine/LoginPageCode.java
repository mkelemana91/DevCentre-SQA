package WebEngine;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import driver_handlers.WebDriverHandler;
import org.junit.BeforeClass;
import org.openqa.selenium.support.PageFactory;
import pages.Web.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class LoginPageCode extends LoginPage {

    @Given("^The System Admin has navigated to the OM web portal$")
    public void the_System_Admin_has_navigated_to_the_OM_web_portal() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        navigateToUrl();

    }

    @When("^The System Admin must enter a valid email address$")
    public void the_System_Admin_must_enter_a_valid_email_address() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        captureEmail();
    }

    @When("^The System Admin must enter a valid password$")
    public void the_System_Admin_must_enter_a_valid_password() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        capturePassword();
    }

    @When("^The System Admin should have their name appear accordingly in a message\\]$")
    public void the_System_Admin_should_have_their_name_appear_accordingly_in_a_message() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

}
