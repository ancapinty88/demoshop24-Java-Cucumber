package stepDefinitions;

import action.*;
import io.cucumber.java.en.*;
import java.util.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.EditAccountPage;
import utils.ConfigFileReader;
import utils.Helper;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EditAccountSteps {

    WebDriver driver;
    ConfigFileReader configFileReader;
    Helper helper;
    EditAccountPage editAccountPage;
    EditAccountAction editAccountAction;
    BasePageAction basePageAction;

    public EditAccountSteps() {

        this.driver = Hooks.driver;
        PageFactory.initElements(driver, this);
        configFileReader = new ConfigFileReader();
        helper = new Helper();
        editAccountPage = new EditAccountPage();
        editAccountAction = new EditAccountAction();
        basePageAction = new BasePageAction();

    }

    @And("user clicks on {string} link in sub menu")
    public void userClickOnLinkInSubMenu(String arg0) {
        Helper.clickGivenElement(driver, editAccountPage.getEditAccountLink());
    }

    @Then("{string} title is present on the page")
    public void titleIsPresentOnThePage(String arg0) {
        basePageAction.getPageTitle(driver, arg0);
    }

    @When("user enter new credentials to the Edit Account form fields")
    public void userEnterNewCredentialsToTheEditAccountFormFields(List<Map<String, String>> enterValues) {
        for (Map<String, String> row : enterValues) {
            basePageAction.enterRandomString(row.get("First Name"), "random", editAccountPage.getFirstNameInput(), "firstName");
            basePageAction.enterRandomString(row.get("Last Name"), "random", editAccountPage.getLastNameInput(), "lastName");
            basePageAction.enterRandomEmail(row.get("E-Mail"), "@email.com", editAccountPage.getEmailInput(), "email");
            basePageAction.enterRandomPhoneNumber(row.get("Telephone"), "random", editAccountPage.getTelephoneInput(), "phone-number");
        }
    }

    @And("Page subtitle is {string}")
    public void pageSubtitleIs(String arg0) {
        basePageAction.compareElementText(editAccountPage.getEditAccountSubTitle(), arg0);
    }

    @Then("user is back at the {string} page with success message {string}")
    public void userIsBackAtThePageWithSuccessMessage(String arg0, String arg1) {
        basePageAction.getPageTitle(driver, arg0);
        basePageAction.compareElementText(editAccountPage.getSuccessMessage(), arg1);

    }


    @Then("user enter previous credentials")
    public void userEnterPreviousCredentials(Map<String, String> valuesToEnter) {
        basePageAction.enterRandomString(valuesToEnter.get("First Name"), "random", editAccountPage.getFirstNameInput(), "firstName");
        basePageAction.enterRandomString(valuesToEnter.get("Last Name"), "random", editAccountPage.getLastNameInput(), "lastName");
        basePageAction.enterRandomEmail(valuesToEnter.get("E-Mail"), "@email.com", editAccountPage.getEmailInput(), "email");
        basePageAction.enterRandomPhoneNumber(valuesToEnter.get("Telephone"), "random", editAccountPage.getTelephoneInput(), "phone-number");
    }

    @When("user clear all the fields inputs")
    public void userClearAllTheFieldsInputs() {
        editAccountPage.getFirstNameInput().clear();
        editAccountPage.getLastNameInput().clear();
        editAccountPage.getEmailInput().clear();
        editAccountPage.getTelephoneInput().clear();
    }

    @Then("I can see {string} under the {string} input field")
    public void iCanSeeUnderTheInputField(String arg0, String arg1) {
        for (WebElement inputField : editAccountPage.getRequiredElements()) {
            String label = basePageAction.getElementLabel(inputField);
            if (label.equals(arg1)) {
                String fieldErrorMessage = basePageAction.getElementErrorMessage(inputField);
                assertEquals(arg0, fieldErrorMessage);
                break;
            }
        }
    }
}




