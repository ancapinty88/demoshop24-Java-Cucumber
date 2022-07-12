package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.RegisterAccount_PO;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterAccountPageSteps {
    private WebDriver driver;
    static RegisterAccount_PO RegAccountPO;

    public RegisterAccountPageSteps () {
        this.driver = Hooks.driver;
        RegAccountPO = PageFactory.initElements(Hooks.driver, RegisterAccount_PO.class);
    }

    @When("^User enters data$")
    public void UserEntersData (Map<String, String> registrationInput) throws Throwable {
        RegAccountPO.enterFirstName(registrationInput.get("First Name"));
        RegAccountPO.enterLastName(registrationInput.get("Last Name"));
        RegAccountPO.enterEmail(registrationInput.get("E-Mail"));
        RegAccountPO.enterTelephone(registrationInput.get("Telephone"));
        RegAccountPO.enterPassword(registrationInput.get("Password"));
        RegAccountPO.enterPassConfirm(registrationInput.get("Password Confirm"));
    }

    @When("^User enters First Name \"([^\"]*)\"$")
    public void UserEntersFirstName (String input) throws Throwable {
        RegAccountPO.enterFirstName(input);
    }
    @When("^User enters Last Name \"([^\"]*)\"$")
    public void UserEntersLastName (String input) throws Throwable {
        RegAccountPO.enterLastName(input);
    }

    @When("^User enters E-Mail \"([^\"]*)\"$")
    public void UserEntersEmail (String input) throws Throwable {
        RegAccountPO.enterEmail(input);
    }

    @When("^User enters Telephone \"([^\"]*)\"$")
    public void UserEntersTelephone (String input) throws Throwable {
        RegAccountPO.enterTelephone(input);
    }

    @When("^User enters Password \"([^\"]*)\"$")
    public void UserEntersPassword (String input) throws Throwable {
        RegAccountPO.enterPassword(input);
    }

    @When("^User enters Password Confirm \"([^\"]*)\"$")
    public void UserEntersPasswordConfirm (String input) throws Throwable {
        RegAccountPO.enterPassConfirm(input);
    }

    @And("^User ticks Privacy Policy checkbox")
    public void UserTicksPrivacyPolicyCheckbox () throws Throwable {
        RegAccountPO.tickPolicyCheckbox();
    }

    @And("^User clicks Continue button$")
    public void UserClicksContinueButton () throws Throwable {
        RegAccountPO.clickContinueButton();
    }

    @Then("^User is redirected to confirmation page$")
    public void UserIsRedirectedToConfirmationPage () throws Throwable {
        assertEquals(RegAccountPO.RegistrationConfirmPage(), driver.getCurrentUrl());
    }

    @And("^Confirmation message is displayed: \"([^\"]*)\"$")
    public void ConfirmationMessageIsDisplayed (String ConfirmMessage) throws Throwable {
        assertEquals(ConfirmMessage, RegAccountPO.readConfirmHeader());
    }

    @Then("^Subscribe radio button is visible$")
    public void SubscribeRadioButtonIsVisible () {
        assertTrue(RegAccountPO.Subscribe.isDisplayed());
    }

    @Then("^Subscribe radio button is set as \"([^\"]*)\"$")
    public void SubscribeRadioButtonIsSetAs (String setValue) {
        if (setValue == "Yes") {
            assertTrue(RegAccountPO.SubscribeYes.isSelected());
        } else {
            assertTrue(RegAccountPO.SubscribeNo.isSelected());
        }
    }

    @Then("^\"([^\"]*)\" warning message is not displayed$")
    public void WarningMessageIsNotDisplayed (String warning) {
        switch (warning) {
            case "First Name" :
                assertFalse(RegAccountPO.FirstNameWarning.isDisplayed());
                break;
            case "Last Name" :
                assertFalse(RegAccountPO.LastNameWarning.isDisplayed());
                break;
            case "Email" :
                assertFalse(RegAccountPO.EmailWarning.isDisplayed());
                break;
            case "Telephone" :
                assertFalse(RegAccountPO.TelephoneWarning.isDisplayed());
                break;
            case "Password" :
                assertFalse(RegAccountPO.PasswordWarning.isDisplayed());
                break;
            case "Password Confirm" :
                assertFalse(RegAccountPO.PassConfirmWarning.isDisplayed());
                break;
        }
    }

    @Then("^\"([^\"]*)\" value field has grey borders$")
    public void ValueFieldHasGreyBorders (String warning) {
        switch (warning) {
            case "First Name" :
                assertEquals(
                        "rgba(204, 204, 204, 1)",
                        RegAccountPO.FirstName.getCssValue("border-top-color"));
                break;
            case "Last Name" :
                assertEquals(
                        "rgba(204, 204, 204, 1)",
                        RegAccountPO.LastName.getCssValue("border-top-color"));
                break;
            case "Email" :
                assertEquals(
                        "rgba(204, 204, 204, 1)",
                        RegAccountPO.Email.getCssValue("border-top-color"));
                break;
            case "Telephone" :
                assertEquals(
                        "rgba(204, 204, 204, 1)",
                        RegAccountPO.Telephone.getCssValue("border-top-color"));
                break;
            case "Password" :
                assertEquals(
                        "rgba(204, 204, 204, 1)",
                        RegAccountPO.Password.getCssValue("border-top-color"));
                break;
            case "Password Confirm" :
                assertEquals(
                        "rgba(204, 204, 204, 1)",
                        RegAccountPO.PassConfirm.getCssValue("border-top-color"));
                break;
        }
    }

}
