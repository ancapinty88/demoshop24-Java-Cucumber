package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.LoginPage_PO;
import pages_sample.MyAccountPage_PO;
import pages_sample.RegisterAccount_PO;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPageSteps {
    private WebDriver driver;
    static LoginPage_PO LoginPO;

    public LoginPageSteps () {
        this.driver = Hooks.driver;
        LoginPO = PageFactory.initElements(Hooks.driver, LoginPage_PO.class);
    }
    @When("^User enters Login data$")
    public void UserEntersLoginData (Map<String, String> registrationInput) throws Throwable {
        LoginPO.enterEmail(registrationInput.get("E-Mail Address"));
        LoginPO.enterPassword(registrationInput.get("Password"));
    }

    @And("^User clicks Login button$")
    public void UserClicksLoginButton () {
        LoginPO.clickLoginButton();
    }

    @Then("^User is redirected to User personal page$")
    public void UserIsRedirectedToUserPersonalPage () {
        assertEquals(LoginPO.MyAccountPage(), driver.getCurrentUrl());
    }


}
