package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class EPIC01_RegistrationSteps {
    private static final Pattern FIRST_NAME_PATTERN = Pattern.compile("[a-zA-Z0-9]{1,32}");
    private static final Pattern LAST_NAME_PATTERN = Pattern.compile(".{1,32}");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(".{4,20}");
    private static final Pattern TELEPHONE_PATTERN = Pattern.compile("[0-9]{3,32}");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("[a-zA-Z0-9._%+#$^*~/|?!{}]+@[a-zA-Z0-9._-]+\\.[a-zA-Z]{2,4}");
    private static final String VALID_SYMBOLS_BEFORE_AT = "^[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]*[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]$";
    private static final String VALID_SYMBOLS_AFTER_AT = "^[A-Za-z0-9._-]*[A-Za-z0-9._-]$";
    private final BaseSteps steps;

    public EPIC01_RegistrationSteps(BaseSteps steps) {
        this.steps = new BaseSteps();
    }

    @And("user clicks Register at header dropdown")
    public void userClicksRegisterAtHeaderDropdown() {
        BaseSteps.EPIC01RegistrationPage.clickRegisterAtHeader();
    }

    @Then("user is redirected to Register Account page")
    public void userIsRedirectedToRegisterAccountPage() {
        assertEquals("https://www.demoshop24.com/index.php?route=account/register", steps.driver.getCurrentUrl());
    }

    public static String makeEmailUnique() {
        String uniqueEmail = UUID.randomUUID() + "@mail.com";
        return uniqueEmail;
    }

    @When("user fills in registration form with valid credentials")
    public void userFillsInRegistrationFormWithValidCredentials(Map<String, String> valuesToEnter) {
        BaseSteps.EPIC01RegistrationPage.enterFirstNameAtRegistrationForm(valuesToEnter.get("firstName"));
        BaseSteps.EPIC01RegistrationPage.enterLastNameAtRegistrationForm(valuesToEnter.get("lastName"));
        String email;
        if (Objects.equals(valuesToEnter.get("email"), "randomEmail")) {
            email = makeEmailUnique();
        } else {
            email = valuesToEnter.get("email");
        }
        BaseSteps.EPIC01RegistrationPage.enterEmailAtRegistrationForm(email);
        BaseSteps.EPIC01RegistrationPage.enterTelephoneAtRegistrationForm(valuesToEnter.get("telephone"));
        BaseSteps.EPIC01RegistrationPage.enterPasswordAtRegistrationForm(valuesToEnter.get("password"));
        BaseSteps.EPIC01RegistrationPage.enterPasswordConfirmAtRegistrationForm(valuesToEnter.get("passwordConfirm"));
    }

    @And("user checks Privacy Policy checkbox")
    public void userChecksPrivacyPolicyCheckbox() {
        BaseSteps.EPIC01RegistrationPage.clickPrivacyPolicyCheckbox();
    }

    @And("user clicks Continue button below Registration form")
    public void userClicksContinueButtonBelowRegistrationForm() {
        BaseSteps.EPIC01RegistrationPage.clickContinueAtRegistrationForm();
    }

    @Then("user is navigated to confirmation page with title: {string}")
    public void userIsNavigatedToConfirmationPageWithTitle(String expectedTitle) {
        String actualTitle = steps.driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    @When("user enters first name {string}")
    public void userEntersFirstName(String firstName) {
        BaseSteps.EPIC01RegistrationPage.enterFirstNameAtRegistrationForm(firstName);
    }

    @Then("first name {string} should be valid and error message {string} is shown if it is invalid")
    public void firstNameShouldBeValidAndErrorMessageIsShownIfItIsInvalid(String firstName, String errorMessage) {
        if (FIRST_NAME_PATTERN.matcher(firstName).matches()) {
            assertTrue(BaseSteps.EPIC01RegistrationPage.firstNameErrorMessages.isEmpty());
        } else {
            assertEquals(errorMessage, BaseSteps.EPIC01RegistrationPage.firstNameErrorMessage.getText());
        }
    }

    @When("user enters telephone {string}")
    public void userEntersTelephone(String telephone) {
        BaseSteps.EPIC01RegistrationPage.enterTelephoneAtRegistrationForm(telephone);
    }

    @Then("telephone {string} should be valid and error message {string} is shown if it is invalid")
    public void telephoneShouldBeValidAndErrorMessageIsShownIfItIsInvalid(String telephone, String errorMessage) {
        if (TELEPHONE_PATTERN.matcher(telephone).matches()) {
            assertTrue(BaseSteps.EPIC01RegistrationPage.TelephoneErrorMessages.isEmpty());
        } else {
            assertEquals(errorMessage, BaseSteps.EPIC01RegistrationPage.TelephoneErrorMessage.getText());
        }
    }

    @When("user enters email {string}")
    public void userEntersEmail(String email) {
        BaseSteps.EPIC01RegistrationPage.enterEmailAtRegistrationForm(email);
    }

    public String getInvalidEmailAlert(WebDriverWait wait) {
        String alertText = "";
        try {
            alertText = wait.until(ExpectedConditions.elementToBeClickable(BaseSteps.EPIC01RegistrationPage.emailAtRegistrationForm)).getAttribute("validationMessage");
        } catch (Exception e) {
        }
        return alertText;
    }

    private String[] getEmailParts(String email) {
        return email.split("@");
    }

    @Then("email {string} should be valid and error message {string} is shown if it is invalid")
    public void emailShouldBeValidAndErrorMessageIsShownIfItIsInvalid(String email, String errorMessage) {
        WebDriverWait wait = new WebDriverWait(steps.driver, 10);
        if ((EMAIL_PATTERN.matcher(email).matches()) && (!email.startsWith(".")) && (!email.contains(".."))) {
            assertTrue(BaseSteps.EPIC01RegistrationPage.EmailErrorMessages.isEmpty());
        } else if ((email.isBlank()) || (email.startsWith(".")) || (email.contains(".."))) {
            assertEquals(errorMessage, BaseSteps.EPIC01RegistrationPage.EmailErrorMessage.getText());
        } else if (!email.contains("@")) {
            String alertText = getInvalidEmailAlert(wait);
            assertEquals(errorMessage, alertText);
        } else if (email.startsWith("@")) {
            String alertText = getInvalidEmailAlert(wait);
            assertEquals(errorMessage, alertText);
        } else if (email.endsWith("@")) {
            String alertText = getInvalidEmailAlert(wait);
            assertEquals(errorMessage, alertText);
        } else if (email.indexOf('.') == email.indexOf('@') + 1) {
            String alertText = getInvalidEmailAlert(wait);
            assertEquals(errorMessage, alertText);
        } else {
            String[] emailParts = getEmailParts(email);
            String partBeforeAt = emailParts[0];
            String partAfterAt = emailParts[1];
            if (!partBeforeAt.matches(VALID_SYMBOLS_BEFORE_AT)) {
            String alertText = getInvalidEmailAlert(wait);
            assertEquals(errorMessage, alertText);
            } else if (!partAfterAt.matches(VALID_SYMBOLS_AFTER_AT)) {
            String alertText = getInvalidEmailAlert(wait);
            assertEquals(errorMessage, alertText);
                }
            else {
            assertEquals(errorMessage, BaseSteps.EPIC01RegistrationPage.EmailErrorMessage.getText());
            }
        }
    }

    @When("user enters password {string}")
    public void userEntersPassword(String password) {
        BaseSteps.EPIC01RegistrationPage.enterPasswordAtRegistrationForm(password);
    }

    @Then("password {string} should be valid and error message {string} is shown if it is invalid")
    public void passwordShouldBeValidAndErrorMessageIsShownIfItIsInvalid(String password, String errorMessage) {
        if (PASSWORD_PATTERN.matcher(password).matches()) {
            assertTrue(BaseSteps.EPIC01RegistrationPage.PasswordErrorMessages.isEmpty());
        } else {
            assertEquals(errorMessage, BaseSteps.EPIC01RegistrationPage.PasswordErrorMessage.getText());
        }
    }

    @And("user enters password confirm {string}")
    public void userEntersPasswordConfirm(String passwordConfirm) {
        BaseSteps.EPIC01RegistrationPage.enterPasswordConfirmAtRegistrationForm(passwordConfirm);
    }

    @Then("password confirm {string} should be valid and error message {string} is shown if it is invalid")
    public void passwordConfirmShouldBeValidAndErrorMessageIsShownIfItIsInvalid(String passwordConfirm, String errorMessage) {
        if (Objects.equals(passwordConfirm, BaseSteps.EPIC01RegistrationPage.passwordAtRegistrationForm.getAttribute("value"))) {
            assertTrue(BaseSteps.EPIC01RegistrationPage.PasswordConfirmErrorMessages.isEmpty());
        } else {
            assertEquals(errorMessage, BaseSteps.EPIC01RegistrationPage.PasswordConfirmErrorMessage.getText());
        }
    }

    @Then("Privacy Policy warning is displayed")
    public void privacyPolicyWarningIsDisplayed() {
        assertTrue(BaseSteps.EPIC01RegistrationPage.PrivacyPolicyWarning.isDisplayed());
    }

    @Then("Privacy Policy warning is not displayed")
    public void privacyPolicyWarningIsNotDisplayed() {
        assertTrue(BaseSteps.EPIC01RegistrationPage.PrivacyPolicyWarnings.isEmpty());
    }

    @When("user enters last name {string}")
    public void userEntersLastName(String lastName) {
        BaseSteps.EPIC01RegistrationPage.enterLastNameAtRegistrationForm(lastName);
    }

    @Then("last name {string} should be valid and error message {string} is shown if it is invalid")
    public void lastNameShouldBeValidAndErrorMessageIsShownIfItIsInvalid(String lastName, String errorMessage) {
        if (LAST_NAME_PATTERN.matcher(lastName).matches()) {
            assertTrue(BaseSteps.EPIC01RegistrationPage.lastNameErrorMessages.isEmpty());
        } else {
            assertEquals(errorMessage, BaseSteps.EPIC01RegistrationPage.lastNameErrorMessage.getText());
        }
    }

    @When("user sees My Account block")
    public void userSeesMyAccountBlock() {
        assertTrue(BaseSteps.EPIC02MyAccountPage.MyAccountBlock.isDisplayed());
    }

    @And("user sees My Orders block")
    public void userSeesMyOrdersBlock() {
        assertTrue(BaseSteps.EPIC02MyAccountPage.MyOrdersBlock.isDisplayed());
    }

    @Then("user sees Edit Account link")
    public void userSeesEditAccountLink() {
        assertTrue(BaseSteps.EPIC02MyAccountPage.EditAccountInfoLink.isDisplayed());
    }

    @And("user can see all the fields")
    public void userCanSeeAllTheFields(List<String> elements) {
        for (String element : elements) {
            WebElement fieldElement = BaseSteps.EPIC01RegistrationPage.getFieldsLocated().get(element);
            assertTrue(fieldElement.isDisplayed());
        }
    }

    @And("user can see asterisks {string} next to the mandatory fields at registration page")
    public void userCanSeeAsterisksNextToTheMandatoryFieldsAtRegistrationPage(String asterisk, List<String> elements) {
        JavascriptExecutor js = (JavascriptExecutor) steps.driver;
        for (String element : elements) {
            WebElement asteriskLocator = BaseSteps.EPIC01RegistrationPage.getAsteriskLocators().get(element);
            String asteriskContent = (String) js.executeScript(
                    "return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", asteriskLocator
            );
            assertEquals(asterisk,asteriskContent);
        }
    }

    @And("radio button Subscribe is No by default")
    public void radioButtonSubscribeIsNoByDefault() {
        assertTrue(BaseSteps.EPIC01RegistrationPage.radioButtonSubscribeNoAtRegistrationForm.isSelected());
    }

    @Then("user can see that there are <{int}> fields")
    public void userCanSeeThatThereAreFields(int count) {
        assertEquals(count, BaseSteps.EPIC01RegistrationPage.fieldsList.size());
    }

    @And("user can see that there is <{int}> checkbox")
    public void userCanSeeThatThereIsCheckbox(int count) {
        assertEquals(count, BaseSteps.EPIC01RegistrationPage.privacyPolicyCheckboxesList.size());
    }

    @And("user can see that there are <{int}> radio buttons")
    public void userCanSeeThatThereAreRadioButtons(int count) {
        assertEquals(count, BaseSteps.EPIC01RegistrationPage.radioButtonsList.size());
    }
}