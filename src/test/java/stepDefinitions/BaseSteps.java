package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseSteps extends CommonSteps{

    @Given("user is at DemoShop start page")
    public void userIsAtDEmoShopStartPage() {
        driver.get(epic01RegistrationPage.getPageUrl());
    }

    @And("user clicks Account icon at header top menu")
    public void userClicksAccountIconAtHeaderTopMenu() {
        epic01RegistrationPage.clickAccountIcon();
    }

    @And("user clicks Login at header dropdown")
    public void userClicksLoginAtHeaderDropdown() {
        epic02MyAccountPage.clickLoginAtHeader();
    }

    @And("user enters email {string} under returning customer")
    public void userEntersEmailUnderReturningCustomer(String email) {
        epic02MyAccountPage.enterEmailToLogin(email);
    }

    @And("user enters password {string} under returning customer")
    public void userEntersPasswordUnderReturningCustomer(String password) {
        epic02MyAccountPage.enterPasswordToLogin(password);
    }

    @Then("user is redirected to Personal Account page")
    public void userIsRedirectedToPersonalAccountPage() {
        assertEquals("https://www.demoshop24.com/index.php?route=account/account", driver.getCurrentUrl());
    }

    @And("user clicks Login button under returning customer")
    public void userClicksLoginButtonUnderReturningCustomer() {
        epic02MyAccountPage.clickLoginButtonUnderReturningCustomer();
    }
}
