package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages_sample.EPIC02MyAccountPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EPIC02_MyAccountSteps extends CommonSteps {

    @Then("user sees My Account links")
    public void userSeesMyAccountLinks(List<String> links) {
        for (int i = 0; i <= (EPIC02MyAccountPage.myAccountLinks.size()-1); i++) {
            assertEquals(links.get(i), EPIC02MyAccountPage.myAccountLinks.get(i).getText());
        }
    }

    @Then("user sees My Orders links")
    public void userSeesMyOrdersLinks(List<String> links) {
        for (int i = 0; i <= (EPIC02MyAccountPage.myOrdersLinks.size()-1); i++) {
            assertEquals(links.get(i), EPIC02MyAccountPage.myOrdersLinks.get(i).getText());
        }
    }

    @Then("user sees My Affiliate Account links")
    public void userSeesMyAffiliateAccountLinks(List<String> links) {
        for (int i = 0; i <= (EPIC02MyAccountPage.myAffiliateAccountLinks.size()-1); i++) {
            assertEquals(links.get(i), EPIC02MyAccountPage.myAffiliateAccountLinks.get(i).getText());
        }
    }

    @And("user sees Newsletter links")
    public void userSeesNewsletterLinks(List<String> links) {
        for (int i = 0; i <= (EPIC02MyAccountPage.newsletterLinks.size()-1); i++) {
            assertEquals(links.get(i), EPIC02MyAccountPage.newsletterLinks.get(i).getText());
        }
    }

    @Then("user sees menu links on the right side")
    public void userSeesMenuLinksOnTheRightSide(List<String> links) {
        for (int i = 0; i <= (EPIC02MyAccountPage.rightMenuLinks.size()-1); i++) {
            assertEquals(links.get(i), EPIC02MyAccountPage.rightMenuLinks.get(i).getText());
        }
    }

    @When("user clicks Edit Account menu item")
    public void userClicksEditAccountMenuItem() {
        EPIC02MyAccountPage.clickEditAccountBtnMenuRight();
    }

    @And("user is navigated to page with subtitle {string}")
    public void userIsNavigatedToPageWithSubtitle(String subtitle) {
        assertEquals(subtitle, EPIC02MyAccountPage.myAccountPageSubtitle.getText());
    }

    @When("user can see all the fields and buttons under Edit Account")
    public void userCanSeeAllTheFieldsAndButtonsUnderEditAccount(List<String> elements) {
        for (String element : elements) {
            WebElement fieldButtonElement = epic02MyAccountPage.getFieldsButtonsLocatedWhenEditAccount().get(element);
            assertTrue(fieldButtonElement.isDisplayed());
        }
    }

    @And("user can see asterisks {string} next to the mandatory fields at Edit Account form")
    public void userCanSeeAsterisksNextToTheMandatoryFieldsAtEditAccountForm(String asterisk, List<String> elements) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (String element : elements) {
            WebElement asteriskLocator = epic02MyAccountPage.getAsteriskLocators().get(element);
            String asteriskContent = (String) js.executeScript(
                    "return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", asteriskLocator
            );
            assertEquals(asterisk,asteriskContent);
        }
    }

    @When("user changes first name to {string}")
    public void userChangesFirstNameTo(String firstName) {
        epic02MyAccountPage.changeFirstNameAtEditAccount(firstName);
    }

    @And("user clicks Continue button below Edit Account form")
    public void userClicksContinueButtonBelowEditAccountForm() {
        epic02MyAccountPage.clickContinueAtEditAccount();
    }

    @And("message {string} is shown")
    public void messageIsShown(String message) {
        assertEquals(message,epic02MyAccountPage.successfulAccountUpdateMessage.getText());
    }

    @When("user changes last name to {string}")
    public void userChangesLastNameTo(String lastName) {
        epic02MyAccountPage.changeLastNameAtEditAccount(lastName);
    }
}