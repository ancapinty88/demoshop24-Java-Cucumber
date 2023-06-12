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

public class EPIC01_RegistrationSteps extends CommonSteps {
    private static final Pattern FIRST_NAME_PATTERN = Pattern.compile("[a-zA-Z0-9]{1,32}");
    private static final Pattern LAST_NAME_PATTERN = Pattern.compile(".{1,32}");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(".{4,20}");
    private static final Pattern TELEPHONE_PATTERN = Pattern.compile("[0-9]{3,32}");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("[a-zA-Z0-9._%+#$^*~/|?!{}]+@[a-zA-Z0-9._-]+\\.[a-zA-Z]{2,4}");
    private static final String VALID_SYMBOLS_BEFORE_AT = "^[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]*[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]$";
    private static final String VALID_SYMBOLS_AFTER_AT = "^[A-Za-z0-9._-]*[A-Za-z0-9._-]$";

    @And("user clicks Register at header dropdown")
    public void userClicksRegisterAtHeaderDropdown() {
        epic01RegistrationPage.clickRegisterAtHeader();
    }

    @Then("user is redirected to Register Account page")
    public void userIsRedirectedToRegisterAccountPage() {
        assertEquals("https://www.demoshop24.com/index.php?route=account/register", driver.getCurrentUrl());
    }

    public static String makeEmailUnique() {
        String uniqueEmail = UUID.randomUUID() + "@mail.com";
        return uniqueEmail;
    }

    @When("user fills in registration form with valid credentials")
    public void userFillsInRegistrationFormWithValidCredentials(Map<String, String> valuesToEnter) {
        epic01RegistrationPage.enterFirstNameAtRegistrationForm(valuesToEnter.get("firstName"));
        epic01RegistrationPage.enterLastNameAtRegistrationForm(valuesToEnter.get("lastName"));
        String email;
        if (Objects.equals(valuesToEnter.get("email"), "randomEmail")) {
            email = makeEmailUnique();
        } else {
            email = valuesToEnter.get("email");
        }
        epic01RegistrationPage.enterEmailAtRegistrationForm(email);
        epic01RegistrationPage.enterTelephoneAtRegistrationForm(valuesToEnter.get("telephone"));
        epic01RegistrationPage.enterPasswordAtRegistrationForm(valuesToEnter.get("password"));
        epic01RegistrationPage.enterPasswordConfirmAtRegistrationForm(valuesToEnter.get("passwordConfirm"));
    }

    @And("user checks Privacy Policy checkbox")
    public void userChecksPrivacyPolicyCheckbox() {
        epic01RegistrationPage.clickPrivacyPolicyCheckbox();
    }

    @And("user clicks Continue button below Registration form")
    public void userClicksContinueButtonBelowRegistrationForm() {
        epic01RegistrationPage.clickContinueAtRegistrationForm();
    }

    @Then("user is navigated to confirmation page with title: {string}")
    public void userIsNavigatedToConfirmationPageWithTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    @When("user enters first name {string}")
    public void userEntersFirstName(String firstName) {
        epic01RegistrationPage.enterFirstNameAtRegistrationForm(firstName);
    }

    @Then("first name {string} should be valid and error message {string} is shown if it is invalid")
    public void firstNameShouldBeValidAndErrorMessageIsShownIfItIsInvalid(String firstName, String errorMessage) {
        if (FIRST_NAME_PATTERN.matcher(firstName).matches()) {
            assertTrue(epic01RegistrationPage.firstNameErrorMessages.isEmpty());
        } else {
            assertEquals(errorMessage, epic01RegistrationPage.firstNameErrorMessage.getText());
        }
    }

    @When("user enters telephone {string}")
    public void userEntersTelephone(String telephone) {
        epic01RegistrationPage.enterTelephoneAtRegistrationForm(telephone);
    }

    @Then("telephone {string} should be valid and error message {string} is shown if it is invalid")
    public void telephoneShouldBeValidAndErrorMessageIsShownIfItIsInvalid(String telephone, String errorMessage) {
        if (TELEPHONE_PATTERN.matcher(telephone).matches()) {
            assertTrue(epic01RegistrationPage.telephoneErrorMessages.isEmpty());
        } else {
            assertEquals(errorMessage, epic01RegistrationPage.telephoneErrorMessage.getText());
        }
    }

    @When("user enters email {string}")
    public void userEntersEmail(String email) {
        epic01RegistrationPage.enterEmailAtRegistrationForm(email);
    }

    public String getInvalidEmailAlert(WebDriverWait wait) {
        String alertText = "";
        try {
            alertText = wait.until(ExpectedConditions.elementToBeClickable(epic01RegistrationPage.emailAtRegistrationForm)).getAttribute("validationMessage");
        } catch (Exception e) {
        }
        return alertText;
    }

    private String[] getEmailParts(String email) {
        return email.split("@");
    }

    @Then("email {string} should be valid and error message {string} is shown if it is invalid")
    public void emailShouldBeValidAndErrorMessageIsShownIfItIsInvalid(String email, String errorMessage) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        if ((EMAIL_PATTERN.matcher(email).matches()) && (!email.startsWith(".")) && (!email.contains(".."))) {
            assertTrue(epic01RegistrationPage.emailErrorMessages.isEmpty());
        } else if ((email.isBlank()) || (email.startsWith(".")) || (email.contains(".."))) {
            assertEquals(errorMessage, epic01RegistrationPage.emailErrorMessage.getText());
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
            assertEquals(errorMessage, epic01RegistrationPage.emailErrorMessage.getText());
            }
        }
    }

    @When("user enters password {string}")
    public void userEntersPassword(String password) {
        epic01RegistrationPage.enterPasswordAtRegistrationForm(password);
    }

    @Then("password {string} should be valid and error message {string} is shown if it is invalid")
    public void passwordShouldBeValidAndErrorMessageIsShownIfItIsInvalid(String password, String errorMessage) {
        if (PASSWORD_PATTERN.matcher(password).matches()) {
            assertTrue(epic01RegistrationPage.passwordErrorMessages.isEmpty());
        } else {
            assertEquals(errorMessage, epic01RegistrationPage.passwordErrorMessage.getText());
        }
    }

    @And("user enters password confirm {string}")
    public void userEntersPasswordConfirm(String passwordConfirm) {
        epic01RegistrationPage.enterPasswordConfirmAtRegistrationForm(passwordConfirm);
    }

    @Then("password confirm {string} should be valid and error message {string} is shown if it is invalid")
    public void passwordConfirmShouldBeValidAndErrorMessageIsShownIfItIsInvalid(String passwordConfirm, String errorMessage) {
        if (Objects.equals(passwordConfirm, epic01RegistrationPage.passwordAtRegistrationForm.getAttribute("value"))) {
            assertTrue(epic01RegistrationPage.passwordConfirmErrorMessages.isEmpty());
        } else {
            assertEquals(errorMessage, epic01RegistrationPage.passwordConfirmErrorMessage.getText());
        }
    }

    @Then("Privacy Policy warning is displayed")
    public void privacyPolicyWarningIsDisplayed() {
        assertTrue(epic01RegistrationPage.privacyPolicyWarning.isDisplayed());
    }

    @Then("Privacy Policy warning is not displayed")
    public void privacyPolicyWarningIsNotDisplayed() {
        assertTrue(epic01RegistrationPage.privacyPolicyWarnings.isEmpty());
    }

    @When("user enters last name {string}")
    public void userEntersLastName(String lastName) {
        epic01RegistrationPage.enterLastNameAtRegistrationForm(lastName);
    }

    @Then("last name {string} should be valid and error message {string} is shown if it is invalid")
    public void lastNameShouldBeValidAndErrorMessageIsShownIfItIsInvalid(String lastName, String errorMessage) {
        if (LAST_NAME_PATTERN.matcher(lastName).matches()) {
            assertTrue(epic01RegistrationPage.lastNameErrorMessages.isEmpty());
        } else {
            assertEquals(errorMessage, epic01RegistrationPage.lastNameErrorMessage.getText());
        }
    }

    @When("user sees My Account block")
    public void userSeesMyAccountBlock() {
        assertTrue(epic02MyAccountPage.myAccountBlock.isDisplayed());
    }

    @And("user sees My Orders block")
    public void userSeesMyOrdersBlock() {
        assertTrue(epic02MyAccountPage.myOrdersBlock.isDisplayed());
    }

    @Then("user sees Edit Account link")
    public void userSeesEditAccountLink() {
        assertTrue(epic02MyAccountPage.editAccountInfoLink.isDisplayed());
    }

    @And("user can see all the fields")
    public void userCanSeeAllTheFields(List<String> elements) {
        for (String element : elements) {
            WebElement fieldElement = epic01RegistrationPage.getFieldsLocated().get(element);
            assertTrue(fieldElement.isDisplayed());
        }
    }

    @And("user can see asterisks {string} next to the mandatory fields at registration page")
    public void userCanSeeAsterisksNextToTheMandatoryFieldsAtRegistrationPage(String asterisk, List<String> elements) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (String element : elements) {
            WebElement asteriskLocator = epic01RegistrationPage.getAsteriskLocators().get(element);
            String asteriskContent = (String) js.executeScript(
                    "return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", asteriskLocator
            );
            assertEquals(asterisk,asteriskContent);
        }
    }

    @And("radio button Subscribe is No by default")
    public void radioButtonSubscribeIsNoByDefault() {
        assertTrue(epic01RegistrationPage.radioButtonSubscribeNoAtRegistrationForm.isSelected());
    }

    @Then("user can see that there are <{int}> fields")
    public void userCanSeeThatThereAreFields(int count) {
        assertEquals(count, epic01RegistrationPage.fieldsList.size());
    }

    @And("user can see that there is <{int}> checkbox")
    public void userCanSeeThatThereIsCheckbox(int count) {
        assertEquals(count, epic01RegistrationPage.privacyPolicyCheckboxesList.size());
    }

    @And("user can see that there are <{int}> radio buttons")
    public void userCanSeeThatThereAreRadioButtons(int count) {
        assertEquals(count, epic01RegistrationPage.radioButtonsList.size());
    }
}