package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.BasePage;
import pages_sample.EPIC01RegistrationPage;
import pages_sample.EPIC02MyAccountPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseSteps {
    protected WebDriver driver;
    static pages_sample.EPIC01RegistrationPage EPIC01RegistrationPage;
    static pages_sample.EPIC02MyAccountPage EPIC02MyAccountPage;
    static pages_sample.BasePage BasePage;

    public BaseSteps() {
        this.driver = Hooks.driver;
        BasePage = PageFactory.initElements(Hooks.driver, BasePage.class);
        EPIC01RegistrationPage = PageFactory.initElements(Hooks.driver, EPIC01RegistrationPage.class);
        EPIC02MyAccountPage = PageFactory.initElements(Hooks.driver, EPIC02MyAccountPage.class);
    }

    @Given("user is at DemoShop start page")
    public void userIsAtDEmoShopStartPage() {
        driver.get(EPIC01RegistrationPage.getPageUrl());
    }

    @And("user clicks Account icon at header top menu")
    public void userClicksAccountIconAtHeaderTopMenu() {
        EPIC01RegistrationPage.clickAccountIcon();
    }

    @And("user clicks Login at header dropdown")
    public void userClicksLoginAtHeaderDropdown() {
        EPIC02MyAccountPage.clickLoginAtHeader();
    }

    @And("user enters email {string} under returning customer")
    public void userEntersEmailUnderReturningCustomer(String email) {
        EPIC02MyAccountPage.enterEmailToLogin(email);
    }

    @And("user enters password {string} under returning customer")
    public void userEntersPasswordUnderReturningCustomer(String password) {
        EPIC02MyAccountPage.enterPasswordToLogin(password);
    }

    @Then("user is redirected to Personal Account page")
    public void userIsRedirectedToPersonalAccountPage() {
        assertEquals("https://www.demoshop24.com/index.php?route=account/account", driver.getCurrentUrl());
    }

    @And("user clicks Login button under returning customer")
    public void userClicksLoginButtonUnderReturningCustomer() {
        EPIC02MyAccountPage.clickLoginButtonUnderReturningCustomer();
    }
}
