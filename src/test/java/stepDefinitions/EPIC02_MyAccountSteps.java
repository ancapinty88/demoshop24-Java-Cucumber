package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.EPIC02MyAccountPage;
import pages_sample.EPIC01RegistrationPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EPIC02_MyAccountSteps {
    private WebDriver driver;
    static EPIC01RegistrationPage EPIC01RegistrationPage;
    static EPIC02MyAccountPage EPIC02MyAccountPage;

    public EPIC02_MyAccountSteps() {
        this.driver = Hooks.driver;
        //EPIC01RegistrationPage = PageFactory.initElements(Hooks.driver, EPIC01RegistrationPage.class);
        EPIC02MyAccountPage = PageFactory.initElements(Hooks.driver, EPIC02MyAccountPage.class);
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

    @Then("user sees My Account links")
    public void userSeesMyAccountLinks(List<String> links) {
        for (int i = 0; i <= (EPIC02MyAccountPage.MyAccountLinks.size()-1); i++) {
            assertEquals(links.get(i), EPIC02MyAccountPage.MyAccountLinks.get(i).getText());
        }
    }

    @Then("user sees My Orders links")
    public void userSeesMyOrdersLinks(List<String> links) {
        for (int i = 0; i <= (EPIC02MyAccountPage.MyOrdersLinks.size()-1); i++) {
            assertEquals(links.get(i), EPIC02MyAccountPage.MyOrdersLinks.get(i).getText());
        }
    }

    @Then("user sees My Affiliate Account links")
    public void userSeesMyAffiliateAccountLinks(List<String> links) {
        for (int i = 0; i <= (EPIC02MyAccountPage.MyAffiliateAccountLinks.size()-1); i++) {
            assertEquals(links.get(i), EPIC02MyAccountPage.MyAffiliateAccountLinks.get(i).getText());
        }
    }

    @And("user sees Newsletter links")
    public void userSeesNewsletterLinks(List<String> links) {
        for (int i = 0; i <= (EPIC02MyAccountPage.NewsletterLinks.size()-1); i++) {
            assertEquals(links.get(i), EPIC02MyAccountPage.NewsletterLinks.get(i).getText());
        }
    }
}