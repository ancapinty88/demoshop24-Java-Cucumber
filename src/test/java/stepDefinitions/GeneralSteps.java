package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.General_PO;
import pages_sample.ExpectedMessages_PO;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeneralSteps {
    private WebDriver driver;
    static General_PO GeneralPO;
    static ExpectedMessages_PO WarningMessages;

    public GeneralSteps () {
        this.driver = Hooks.driver;
        GeneralPO = PageFactory.initElements(Hooks.driver, General_PO.class);
        WarningMessages = PageFactory.initElements(Hooks.driver, ExpectedMessages_PO.class);
    }
    @And("^User clicks Continue button$")
    public void UserClicksContinueButton () {
        GeneralPO.clickContinueButton();
    }

    @Then("^A message is displayed$")
    public void AMessageIsDisplayed (List<String> warnings) {
        for (String warning : warnings) {
            String actualWarning = GeneralPO.readMessageText(warning);
            String expectedWarning = WarningMessages.getExpectedMessage(warning);
            assertEquals(expectedWarning, actualWarning);
        }
    }

    @When("^User enters whitespace$")
    public void UserEntersWhitespace (List<String> fields) {
        for (String field : fields) {
            switch (field) {
                case "First Name" :
                    GeneralPO.FirstName.clear();
                    GeneralPO.FirstName.sendKeys(Keys.SPACE);
                    break;
                case "Last Name" :
                    GeneralPO.LastName.clear();
                    GeneralPO.LastName.sendKeys(Keys.SPACE);
                    break;
                case "Email" :
                    GeneralPO.Email.clear();
                    GeneralPO.Email.sendKeys(Keys.SPACE);
                    break;
                case "Telephone" :
                    GeneralPO.Telephone.clear();
                    GeneralPO.Telephone.sendKeys(Keys.SPACE);
                    break;
                case "Password" :
                    GeneralPO.Password.clear();
                    GeneralPO.Password.sendKeys(Keys.SPACE);
                    break;
                case "Password Confirm" :
                    GeneralPO.PassConfirm.clear();
                    GeneralPO.PassConfirm.sendKeys(Keys.SPACE);
                    break;
            }
        }
    }

    @When("^User enters data$")
    public void UserEntersData (Map<String, String> registrationInput) throws Throwable {
        UserEntersFirstName(registrationInput.get("First Name"));
        UserEntersLastName(registrationInput.get("Last Name"));
        UserEntersEmail(registrationInput.get("E-Mail"));
        UserEntersTelephone(registrationInput.get("Telephone"));
        UserEntersPassword(registrationInput.get("Password"));
        UserEntersPasswordConfirm(registrationInput.get("Password Confirm"));
    }

    @When("^User enters First Name \"([^\"]*)\"$")
    public void UserEntersFirstName (String input) throws Throwable {
        GeneralPO.enterFirstName(input);
    }
    @When("^User enters Last Name \"([^\"]*)\"$")
    public void UserEntersLastName (String input) throws Throwable {
        GeneralPO.enterLastName(input);
    }

    @When("^User enters E-Mail \"([^\"]*)\"$")
    public void UserEntersEmail (String input) throws Throwable {
        GeneralPO.enterEmail(input);
    }

    @When("^User enters Telephone \"([^\"]*)\"$")
    public void UserEntersTelephone (String input) throws Throwable {
        GeneralPO.enterTelephone(input);
    }

    @When("^User enters Password \"([^\"]*)\"$")
    public void UserEntersPassword (String input) throws Throwable {
        GeneralPO.enterPassword(input);
    }

    @When("^User enters Password Confirm \"([^\"]*)\"$")
    public void UserEntersPasswordConfirm (String input) throws Throwable {
        GeneralPO.enterPassConfirm(input);
    }
}
