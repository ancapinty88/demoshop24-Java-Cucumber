package stepDefinitions;

import action.BasePageAction;
import io.cucumber.java.en.*;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.RegistrationPage;
import utils.Helper;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationSteps {

    WebDriver driver;
    static RegistrationPage registrationPage;
    BasePageAction basePageAction;
    BasePage basePage;

    public RegistrationSteps() {
        this.driver = Hooks.driver;
        registrationPage = PageFactory.initElements(Hooks.driver, RegistrationPage.class);
        basePageAction = PageFactory.initElements(Hooks.driver, BasePageAction.class);
        basePage = PageFactory.initElements(Hooks.driver, BasePage.class);

    }

    @And("user mark Privacy Policy checkbox")
    public void userMarkPrivacyPolicyCheckbox() {
        Helper.clickGivenElement(driver, registrationPage.getCheckboxToAgreeWithPrivacyPolicy());
    }

    @Then("user see {string} title")
    public void userSeeTitle(String arg0) {
        basePageAction.getPageTitle(driver, arg0);
    }

    @When("user enter valid data in registration fields:")
    public void userEnterValidDataInRegistrationFields(Map<String, String> valuesToEnter) {
        basePageAction.enterRandomString(valuesToEnter.get("First Name"), "random", registrationPage.getFirstNameInput(), "firstName");
        basePageAction.enterRandomString(valuesToEnter.get("Last Name"), "random", registrationPage.getLastNameInput(), "lastName");
        basePageAction.enterRandomEmail(valuesToEnter.get("E-Mail"), "@email.com", registrationPage.getEmailAddressInput(), "email");
        basePageAction.enterRandomPhoneNumber(valuesToEnter.get("Telephone"), "random", registrationPage.getTelephoneNumberInput(), "phone-number");
        basePageAction.enterRandomString(valuesToEnter.get("Password"), "random", registrationPage.getPasswordInput(), "password");
        basePageAction.enterPasswordConfirmation(valuesToEnter.get("Password Confirm"), "password", registrationPage.getPasswordConfirmInput(), "passwordConfirm", registrationPage.getPasswordInput());

    }

    @When("user enter registration data:")
    public void userEnterRegistrationData(List<Map<String, String>> enterValues) {
        for (Map<String, String> row : enterValues) {
            basePageAction.enterRandomString(row.get("First Name"), "random", registrationPage.getFirstNameInput(), "firstName");
            basePageAction.enterRandomString(row.get("Last Name"), "random", registrationPage.getLastNameInput(), "lastName");
            basePageAction.enterRandomEmail(row.get("E-Mail"), "@email.lt", registrationPage.getEmailAddressInput(), "email");
            basePageAction.enterRandomPhoneNumber(row.get("Telephone"), "random", registrationPage.getTelephoneNumberInput(), "phone-number");
            basePageAction.enterRandomString(row.get("Password"), "random", registrationPage.getPasswordInput(), "password");
            basePageAction.enterRandomString(row.get("Password Confirm"), "random", registrationPage.getPasswordConfirmInput(), "password-confirm");
        }
    }

    @Then("user see {string} for invalid {string}")
    public void userSeeForInvalid(String errorMessage, String inputFieldName) {

        for (WebElement inputField : registrationPage.getRequiredFieldElements()) {
            String label = basePageAction.getElementLabel(inputField);
            if (label.equals(inputFieldName)) {
                String actualErrorMessage = basePageAction.getElementErrorMessage(inputField);
                assertEquals(errorMessage, actualErrorMessage);
            }
        }
    }
}
