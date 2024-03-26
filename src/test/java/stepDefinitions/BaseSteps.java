package stepDefinitions;

import action.*;
import io.cucumber.java.en.*;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.LoginPage;
import pages.PasswordPage;
import pages.RegistrationPage;
import pages.WishListPage;
import utils.ConfigFileReader;
import utils.Helper;

public class BaseSteps {

    WebDriver driver;
    ConfigFileReader configFileReader;
    Helper helper;

    LoginPage loginPage;
    LoginPageAction loginPageAction;
    RegistrationPage registrationPage;
    RegistrationPageAction registrationPageAction;
    PasswordPage passwordPage;
    WishListPage wishListPage;

    //constructor
    public static BasePage basePage;

    public BaseSteps() {
        this.driver = Hooks.driver;
        PageFactory.initElements(driver, this);
        configFileReader = new ConfigFileReader();
        this.basePage = new BasePage();
        helper = new Helper();
        loginPage = new LoginPage();
        loginPageAction = new LoginPageAction();
        registrationPage = new RegistrationPage();
        registrationPageAction = new RegistrationPageAction();
        passwordPage = new PasswordPage();
        wishListPage = new WishListPage();
    }

//    @Given("user navigates to home page")
//    public void userNavigatesToHomePage() {
//    configFileReader.getHomePageUrl();
//    }

    @Given("user is on {string} page")
    public void userIsOnPage(String PageName) {
        String pageURL = configFileReader.getConfigVariable(PageName);
        helper.navigateToUrl(pageURL);

    }

    @And("{string} is displayed")
    public void isDisplayed(String text) {
        helper.assertElementIsDisplayed(basePage.TDStext);
    }

    @When("user clicks {string} button")
    public void userClicksButton(String button) {
        WebElement element = null;
//pass web element
        if (Objects.equals(button, "Login")) {
            element = loginPage.getLogInLink();
        }
        if (Objects.equals(button, "LoginAccount")) {
            element = loginPage.getLoginPageButton();
            {
                if (Objects.equals(button, "Register")) {
                    element = registrationPage.getRegisterLink();
                }
                if (Objects.equals(button, "My Account")) {
                    element = basePage.getMyAccountIcon();
                }
                if (Objects.equals(button, "ContinueReg")) {
                    element = registrationPage.getContinueButtonInRegistrationField();
                }
                if (Objects.equals(button, "Continue"))
                    element = passwordPage.getChangePasswordContinueButton();

                assert element != null;
                Helper.clickGivenElement(driver, element);

            }


        }
    }
}


//    @When("user is on {string} page")
//    public void userIsOnPage(String PageName) {
//        String pageURL = configFileReader.getConfigVariable(PageName);
//        helper.navigateToUrl(pageURL);
//    }
//
//    @Then("navigation header bar icons are displayed")
//    public void navigationHeaderBarIconsAreDisplayed() {
//    basePage.getIconElements();
//    }
//
//    @And("{string} is displayed")
//    public void isDisplayed(String text) {
//        helper.assertElementIsDisplayed(basePage.TDStext);
//    }





