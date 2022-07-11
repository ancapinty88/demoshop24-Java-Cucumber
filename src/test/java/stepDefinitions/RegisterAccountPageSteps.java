package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.RegisterAccount_PO;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
