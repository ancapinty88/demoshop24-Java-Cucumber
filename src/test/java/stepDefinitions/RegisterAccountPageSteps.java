package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.RegisterAccount_PO;

import java.util.List;
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

    @Then("^Warning message is displayed$")
    public void WarningMessageIsDisplayed (List<String> warnings) {
        for (String warning : warnings) {
            switch (warning) {
                case "First Name" :
                    assertTrue(RegAccountPO.FirstNameWarning.isDisplayed());
                    break;
                case "Last Name" :
                    assertTrue(RegAccountPO.LastNameWarning.isDisplayed());
                    break;
                case "Email" :
                    assertTrue(RegAccountPO.EmailWarning.isDisplayed());
                    break;
                case "Telephone" :
                    assertTrue(RegAccountPO.TelephoneWarning.isDisplayed());
                    break;
                case "Password" :
                    assertTrue(RegAccountPO.PasswordWarning.isDisplayed());
                    break;
                case "Password Confirm" :
                    assertTrue(RegAccountPO.PassConfirmWarning.isDisplayed());
                    break;
                case "Policy" :
                    assertTrue(RegAccountPO.PolicyWarning.isDisplayed());
                    break;
            }
        }
    }

    @Then("^Field is marked with asterisk$")
    public void FieldIsMarkedWithAsterisk (List<String> fields) {
        for (String field : fields) {
            switch (field) {
                    case "First Name" :
                        assertTrue(RegAccountPO.FirstNameWarning.isDisplayed());
                        break;
                    case "Last Name" :
                        assertTrue(RegAccountPO.LastNameWarning.isDisplayed());
                        break;
                    case "Email" :
                        assertTrue(RegAccountPO.EmailWarning.isDisplayed());
                        break;
                    case "Telephone" :
                        assertTrue(RegAccountPO.TelephoneWarning.isDisplayed());
                        break;
                    case "Password" :
                        assertTrue(RegAccountPO.PasswordWarning.isDisplayed());
                        break;
                    case "Password Confirm" :
                        assertTrue(RegAccountPO.PassConfirmWarning.isDisplayed());
                        break;
                    case "Policy" :
                        assertTrue(RegAccountPO.PolicyWarning.isDisplayed());
                        break;
                }
        }
    }

    @Then("^Email tooltip is displayed$")
    public void EmailTooltipIsDisplayed () {
        assertFalse(RegAccountPO.Email.getAttribute("validationMessage").isEmpty());
    }

    @Then("^Email field type=email$")
    public void EmailFieldTypeEqualsEmail () {
        assertEquals("email", RegAccountPO.Email.getAttribute("type"));
    }
}
