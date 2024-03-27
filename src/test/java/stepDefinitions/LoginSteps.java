package stepDefinitions;

import action.BasePageAction;
import action.LoginPageAction;
import action.MyAccountPageAction;
import action.PasswordPageAction;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.PasswordPage;
import utils.Helper;

public class LoginSteps {
    WebDriver driver;

    public static BasePage basePage;
    public static BasePageAction basePageAction;
    public static LoginPage loginPage;
    public static LoginPageAction loginPageAction;
    public static MyAccountPage myAccountPage;
    public static MyAccountPageAction myAccountPageAction;
    public static Helper helper;
    public static PasswordPageAction passwordPageAction;
    public static PasswordPage passwordPage;

    public LoginSteps() {
        this.driver = Hooks.driver;
        loginPage = PageFactory.initElements(Hooks.driver, LoginPage.class);
        loginPageAction = PageFactory.initElements(Hooks.driver, LoginPageAction.class);
        myAccountPage = PageFactory.initElements(Hooks.driver, MyAccountPage.class);
        myAccountPageAction = PageFactory.initElements(Hooks.driver, MyAccountPageAction.class);
        helper = PageFactory.initElements(Hooks.driver, Helper.class);
        basePage = PageFactory.initElements(Hooks.driver, BasePage.class);
        basePageAction = PageFactory.initElements(Hooks.driver, BasePageAction.class);
        passwordPageAction = PageFactory.initElements(Hooks.driver, PasswordPageAction.class);
        passwordPage = PageFactory.initElements(Hooks.driver, PasswordPage.class);
    }

    @Then("user login with valid credentials")
    public void userLoginWithValidCredentials() {
        basePageAction.inputDataToTheField(loginPage.getEMailAddressInput(), loginPage.getLogEmail());
        basePageAction.inputDataToTheField(loginPage.getPasswordInputField(), loginPage.getLogPassword());
//            (Map<String, String> valuesToEnter) throws InterruptedException {
//        basePageAction.enterRandomEmail(valuesToEnter.get("E-Mail Address"), "@xmail.com", loginPage.getEMailAddressInput(), "email");
//        basePageAction.enterRandomString(valuesToEnter.get("Password"), "random", loginPage.getPasswordInputField(), "password");
    }

}

