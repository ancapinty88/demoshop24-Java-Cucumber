package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.RegisterAccount_PO;
import pages_sample.ExpectedMessages_PO;
import pages_sample.General_PO;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterAccountPageSteps {
    private WebDriver driver;
    static RegisterAccount_PO RegAccountPO;
    static ExpectedMessages_PO WarningMessages;
    static General_PO GeneralPO;

    public RegisterAccountPageSteps () {
        this.driver = Hooks.driver;
        RegAccountPO = PageFactory.initElements(Hooks.driver, RegisterAccount_PO.class);
        WarningMessages = PageFactory.initElements(Hooks.driver, ExpectedMessages_PO.class);
        GeneralPO = PageFactory.initElements(Hooks.driver, General_PO.class);
    }

    @And("^User ticks Privacy Policy checkbox")
    public void UserTicksPrivacyPolicyCheckbox () throws Throwable {
        RegAccountPO.tickPolicyCheckbox();
    }

    @Then("^User is redirected to confirmation page$")
    public void UserIsRedirectedToConfirmationPage () throws Throwable {
        assertEquals(RegAccountPO.RegistrationConfirmPage(), driver.getCurrentUrl());
    }

    @And("^Confirmation message is displayed: \"([^\"]*)\"$")
    public void ConfirmationMessageIsDisplayed (String ConfirmMessage) throws Throwable {
        assertEquals(ConfirmMessage, RegAccountPO.readConfirmationHeader());
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

    @Then("^Email field type=email$")
    public void EmailFieldTypeEqualsEmail () {
        assertEquals("email", GeneralPO.Email.getAttribute("type"));
    }

    @Then("^User selects Subscribe option \"([^\"]*)\"$")
    public void UserSelectsSubscribeOption (String option) {
        if (option.equals("yes")) {
            System.out.println(option);
            RegAccountPO.SubscribeYes.click();
        } else if (option.equals("no")) {
            RegAccountPO.SubscribeNo.click();
        }
    }

}
