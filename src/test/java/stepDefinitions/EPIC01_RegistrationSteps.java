package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages_sample.*;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class EPIC01_RegistrationSteps {
    private static final Pattern FIRST_NAME_PATTERN = Pattern.compile("[a-zA-Z0-9]{1,32}");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(".{4,20}");
    private static final Pattern TELEPHONE_PATTERN = Pattern.compile("[0-9]{3,32}");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("[a-zA-Z0-9._%+#$^*~/|?!{}]+@[a-zA-Z0-9._-]+\\.[a-zA-Z]{2,4}");
    private static final String VALID_SYMBOLS_BEFORE_AT = "^[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]*[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]$";
    private static final String VALID_SYMBOLS_AFTER_AT = "^[A-Za-z0-9._-]*[A-Za-z0-9._-]$";
    private WebDriver driver;

    static EPIC01RegistrationPage EPIC01RegistrationPage;

    public EPIC01_RegistrationSteps() {
        this.driver = Hooks.driver;
        EPIC01RegistrationPage = PageFactory.initElements(Hooks.driver, EPIC01RegistrationPage.class);
    }

    @Given("user is at DemoShop start page")
    public void userIsAtDEmoShopStartPage() {
        driver.get(EPIC01RegistrationPage.getPageUrl());
    }

    @And("user clicks Account icon at header top menu")
    public void userClicksAccountIconAtHeaderTopMenu() {
        EPIC01RegistrationPage.clickAccountIcon();
    }

    @And("user clicks Register at header dropdown")
    public void userClicksRegisterAtHeaderDropdown() {
        EPIC01RegistrationPage.clickRegisterAtHeader();
    }

    @Then("user is redirected to Register Account page")
    public void userIsRedirectedToRegisterAccountPage() {
        assertEquals("https://www.demoshop24.com/index.php?route=account/register", driver.getCurrentUrl());
    }

    public static String makeEmailUnique() {
        String uniqueEmail = UUID.randomUUID().toString() + "@mail.com";
        return uniqueEmail;
    }

    @When("user fills in registration form with valid credentials")
    public void userFillsInRegistrationFormWithValidCredentials(Map<String, String> valuesToEnter) {
        EPIC01RegistrationPage.enterFirstNameAtRegistrationForm(valuesToEnter.get("firstName"));
        EPIC01RegistrationPage.enterLastNameAtRegistrationForm(valuesToEnter.get("lastName"));
        String email;
        if (Objects.equals(valuesToEnter.get("email"), "randomEmail")) {
            email = makeEmailUnique();
        } else {
            email = valuesToEnter.get("email");
        }
        EPIC01RegistrationPage.enterEmailAtRegistrationForm(email);
        EPIC01RegistrationPage.enterTelephoneAtRegistrationForm(valuesToEnter.get("telephone"));
        EPIC01RegistrationPage.enterPasswordAtRegistrationForm(valuesToEnter.get("password"));
        EPIC01RegistrationPage.enterPasswordConfirmAtRegistrationForm(valuesToEnter.get("passwordConfirm"));
    }

    @And("user checks Privacy Policy checkbox")
    public void userChecksPrivacyPolicyCheckbox() {
        EPIC01RegistrationPage.clickPrivacyPolicyCheckbox();
    }

    @And("user clicks Continue button below Registration form")
    public void userClicksContinueButtonBelowRegistrationForm() {
        EPIC01RegistrationPage.clickContinueAtRegistrationForm();
    }

    @Then("user is navigated to confirmation page with title: {string}")
    public void userIsNavigatedToConfirmationPageWithTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    @When("user enters first name {string}")
    public void userEntersFirstName(String firstName) {
        EPIC01RegistrationPage.enterFirstNameAtRegistrationForm(firstName);
    }

    @Then("first name {string} should be valid and error message {string} is shown if it is invalid")
    public void firstNameShouldBeValidAndErrorMessageIsShownIfItIsInvalid(String firstName, String errorMessage) {
        if (FIRST_NAME_PATTERN.matcher(firstName).matches()) {
            assertTrue(EPIC01RegistrationPage.firstNameErrorMessages.isEmpty());
        } else {
            assertEquals(errorMessage, EPIC01RegistrationPage.firstNameErrorMessage.getText());
        }
    }

    @When("user enters telephone {string}")
    public void userEntersTelephone(String telephone) {
        EPIC01RegistrationPage.enterTelephoneAtRegistrationForm(telephone);
    }

    @Then("telephone {string} should be valid and error message {string} is shown if it is invalid")
    public void telephoneShouldBeValidAndErrorMessageIsShownIfItIsInvalid(String telephone, String errorMessage) {
        if (TELEPHONE_PATTERN.matcher(telephone).matches()) {
            assertTrue(EPIC01RegistrationPage.TelephoneErrorMessages.isEmpty());
        } else {
            assertEquals(errorMessage, EPIC01RegistrationPage.TelephoneErrorMessage.getText());
        }
    }

    @When("user enters email {string}")
    public void userEntersEmail(String email) {
        EPIC01RegistrationPage.enterEmailAtRegistrationForm(email);
    }

    public String getInvalidEmailAlert(WebDriverWait wait) {
        String alertText = "";
        try {
            alertText = wait.until(ExpectedConditions.elementToBeClickable(EPIC01RegistrationPage.emailAtRegistrationForm)).getAttribute("validationMessage");
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
            assertTrue(EPIC01RegistrationPage.EmailErrorMessages.isEmpty());
        } else if ((email.isBlank()) || (email.startsWith(".")) || (email.contains(".."))) {
            assertEquals(errorMessage, EPIC01RegistrationPage.EmailErrorMessage.getText());
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
            assertEquals(errorMessage, EPIC01RegistrationPage.EmailErrorMessage.getText());
            }
        }
    }

    @When("user enters password {string}")
    public void userEntersPassword(String password) {
        EPIC01RegistrationPage.enterPasswordAtRegistrationForm(password);
    }

    @Then("password {string} should be valid and error message {string} is shown if it is invalid")
    public void passwordShouldBeValidAndErrorMessageIsShownIfItIsInvalid(String password, String errorMessage) {
        if (PASSWORD_PATTERN.matcher(password).matches()) {
            assertTrue(EPIC01RegistrationPage.PasswordErrorMessages.isEmpty());
        } else {
            assertEquals(errorMessage, EPIC01RegistrationPage.PasswordErrorMessage.getText());
        }
    }

    @And("user enters password confirm {string}")
    public void userEntersPasswordConfirm(String passwordConfirm) {
        EPIC01RegistrationPage.enterPasswordConfirmAtRegistrationForm(passwordConfirm);
    }

    @Then("password confirm {string} should be valid and error message {string} is shown if it is invalid")
    public void passwordConfirmShouldBeValidAndErrorMessageIsShownIfItIsInvalid(String passwordConfirm, String errorMessage) {
        if (Objects.equals(passwordConfirm, EPIC01RegistrationPage.passwordAtRegistrationForm.getAttribute("value"))) {
            assertTrue(EPIC01RegistrationPage.PasswordConfirmErrorMessages.isEmpty());
        } else {
            assertEquals(errorMessage, EPIC01RegistrationPage.PasswordConfirmErrorMessage.getText());
        }
    }
}