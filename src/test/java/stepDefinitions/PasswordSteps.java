package stepDefinitions;

import action.BasePageAction;
import action.LoginPageAction;
import action.MyAccountPageAction;
import action.PasswordPageAction;
import cucumber.api.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.PasswordPage;
import utils.ConfigFileReader;
import utils.Helper;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.Helper.clickElement;

public class PasswordSteps  {
    WebDriver driver;

    static PasswordPage passwordPage;
    static ConfigFileReader configFileReader;
    LoginPageAction loginPageAction;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    MyAccountPageAction myAccountPageAction;
    BasePage basePage;
    BasePageAction basePageAction;
    PasswordPageAction passwordPageAction;

    public PasswordSteps() {
        this.driver = Hooks.driver;
        PageFactory.initElements (driver, this);
        configFileReader = new ConfigFileReader();
        loginPageAction = new LoginPageAction();
        loginPage = new LoginPage();
        myAccountPage = new MyAccountPage();
        myAccountPageAction = new MyAccountPageAction();
        basePage = new BasePage();
        basePageAction = new BasePageAction();
        passwordPageAction = new PasswordPageAction();
    }


    @When("Fill input {string} and {string} fields in the Returning Customer section")
    public void fillInputAndFieldsInTheReturningCustomerSection(String email, String password, DataTable dataTable) {
        loginPageAction.enterEmailLogin(email, loginPage.getEMailAddressInput());
        loginPageAction.enterPasswordLogin(password, loginPage.getPasswordInputField());
    }

    @Then("Click on the Login button")
    public void clickOnTheLoginButton() {
        clickElement((By) loginPage.getLogInButtonInLoginForm());
    }


    @And("user click on {string} link in sub menu")
    public void userClickOnLinkInSubMenu(String link) {
        for (WebElement element: myAccountPage.myAccountRightSideSubMenuLinks(driver) ) {
            if (element.getText().equals(link)) {
                Helper.clickGivenElement(driver, element);
                break;
            }
        }

    }

    @Then("user see {string} page title")
    public void userSeePageTitle(String arg0) {
        basePageAction.getPageTitle(driver, arg0);
    }

    @And("user see {string} page subtitle")
    public void userSeePageSubtitle(String arg0) {

        basePageAction.getPageTitle(driver, arg0);
    }

    @When("user see mandatory fields in the Change Password form")
    public void userSeeMandatoryFieldsInTheChangePasswordForm(List<String> requiredFields) {
        List<String> pageRequiredFields = passwordPageAction.getMandatoryFields(passwordPage.getRequiredElements());
        assertEquals(requiredFields, pageRequiredFields);
    }

    @And("user click on Back button at the bottom of Change Password form")
    public void userClickOnBackButtonAtTheBottomOfChangePasswordForm() {

        Helper.clickGivenElement(driver, passwordPage.getChangePasswordBackButton());
    }

    @When("user enter new credentials to the Change Password form fields")
    public void userEnterNewCredentialsToTheChangePasswordFormFields(Map<String, String> valuesToEnter) {

        basePageAction.enterRandomString(valuesToEnter.get("Password"), "random", passwordPage.getPasswordInput(), "password");
        basePageAction.enterRandomString(valuesToEnter.get("Password Confirm"), "password", passwordPage.getPasswordConfirmInput(), "passwordConfirm");
    }

    @Then("user see {string} for invalid Password Change {string} field")
    public void userSeeForInvalidPasswordChangeField(String arg0, String arg1) {
        for (WebElement inputField : passwordPage.getRequiredElements()) {
            String label = basePageAction.getElementLabel(inputField);
            if (label.equals(arg1)) {
                String fieldErrorMessage = basePageAction.getElementErrorMessage(inputField);
                assertEquals(arg0, fieldErrorMessage);
                break;
            }
        }
    }

}

