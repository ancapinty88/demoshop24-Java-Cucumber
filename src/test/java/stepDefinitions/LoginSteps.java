package stepDefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.LoginPage;
import pages_sample.RegistrationPage;

public class LoginSteps {
    private WebDriver driver;
    public static LoginPage loginPage;

    public LoginSteps() {
        this.driver = Hooks.driver;
        loginPage = PageFactory.initElements(Hooks.driver, LoginPage.class);
    }

    @Then("Fill input {string} and {string} fields in the Returning Customer section")
    public void fillInputAndFieldsInTheReturningCustomerSection(String email, String password) {
        loginPage.enterEmailLogin(email);
        loginPage.enterPasswordLogin(password);
    }
    @Then("Click on the Login button")
    public void clickOnTheLoginButton() {
        loginPage.clickLoginButton();

    }

    @Then("Click on Login from My Account menu")
    public void clickOnLoginFromMyAccountMenu() {
        LoginPage.clickLoginOption();
    }
}
