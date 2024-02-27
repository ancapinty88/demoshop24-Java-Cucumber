package stepDefinitions;

import action.LoginPageAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;

import static action.LoginPageAction.*;
import static utils.Helper.clickElement;

public class LoginSteps {
    private WebDriver driver;
    public static LoginPage loginPage;
    public static LoginPageAction loginPageAction;

    public LoginSteps() {
        this.driver = Hooks.driver;
        loginPage = PageFactory.initElements(Hooks.driver, LoginPage.class);
        loginPageAction = PageFactory.initElements(Hooks.driver, LoginPageAction.class);
    }

    @When("Fill input {string} and {string} fields in the Returning Customer section")
    public void fillInputAndFieldsInTheReturningCustomerSection(String email, String password) {
        loginPageAction.enterEmailLogin(email,loginPage.getEmailLogin());
        loginPageAction.enterPasswordLogin(password,loginPage.getPasswordLogin());
    }

    @Then("Click on the Login button")
    public void clickOnTheLoginButton() {
        clickElement((By) loginPage.getLoginButton());
    }



}
