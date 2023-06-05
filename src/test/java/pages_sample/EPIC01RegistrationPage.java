package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EPIC01RegistrationPage extends BasePage {
    @FindBy(how = How.CSS, using = "#top-links [href*='route=account/register']")
    private WebElement RegisterAtHeader;
    @FindBy(how = How.ID, using = "input-firstname")
    public WebElement firstNameAtRegistrationForm;
    @FindBy(how = How.ID, using = "input-lastname")
    private WebElement lastNameAtRegistrationForm;
    @FindBy(how = How.ID, using = "input-email")
    public WebElement emailAtRegistrationForm;
    @FindBy(how = How.ID, using = "input-telephone")
    public WebElement telephoneAtRegistrationForm;
    @FindBy(how = How.ID, using = "input-password")
    public WebElement passwordAtRegistrationForm;
    @FindBy(how = How.ID, using = "input-confirm")
    public WebElement passwordConfirmAtRegistrationForm;
    @FindBy(how = How.NAME, using = "agree")
    public WebElement PrivacyPolicyCheckbox;
    @FindBy(how = How.CLASS_NAME, using = "btn-primary")
    private WebElement ContinueBtnAtRegistrationForm;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'First Name must')]")
    public List<WebElement> firstNameErrorMessages;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'First Name must')]")
    public WebElement firstNameErrorMessage;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Telephone must')]")
    public List<WebElement> TelephoneErrorMessages;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Telephone must')]")
    public WebElement TelephoneErrorMessage;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'E-Mail Address does not')]")
    public List<WebElement> EmailErrorMessages;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'E-Mail Address does not')]")
    public WebElement EmailErrorMessage;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Password must be between')]")
    public List<WebElement> PasswordErrorMessages;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Password must be between')]")
    public WebElement PasswordErrorMessage;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Password confirmation does not')]")
    public List<WebElement> PasswordConfirmErrorMessages;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Password confirmation does not')]")
    public WebElement PasswordConfirmErrorMessage;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Warning:')]")
    public WebElement PrivacyPolicyWarning;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Warning:')]")
    public List<WebElement>  PrivacyPolicyWarnings;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Last Name must')]")
    public List<WebElement> lastNameErrorMessages;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Last Name must')]")
    public WebElement lastNameErrorMessage;
    @FindBy(how = How.CSS, using = "div.form-group.required label[for='input-firstname']")
    public WebElement firstNameForAsterisk;
    @FindBy(how = How.CSS, using = "div.form-group.required label[for='input-lastname']")
    public WebElement lastNameForAsterisk;
    @FindBy(how = How.CSS, using = "div.form-group.required label[for='input-email']")
    public WebElement emailForAsterisk;
    @FindBy(how = How.CSS, using = "div.form-group.required label[for='input-telephone']")
    public WebElement telephoneForAsterisk;
    @FindBy(how = How.CSS, using = "div.form-group.required label[for='input-password']")
    public WebElement passwordForAsterisk;
    @FindBy(how = How.CSS, using = "div.form-group.required label[for='input-confirm']")
    public WebElement passwordConfirmForAsterisk;
    @FindBy(how = How.CSS, using = ("input[type='radio'][value='0']"))
    public WebElement radioButtonSubscribeNoAtRegistrationForm;
    @FindBy(how = How.CSS, using = ".form-group.required:not([style*='display:  none ;'")
    public List<WebElement> fieldsList;
    @FindBy(how = How.NAME, using = "agree")
    public List<WebElement> privacyPolicyCheckboxesList;
    @FindBy(how = How.CSS, using = (".form-group:not([style*='display:  none ;']) input[type=radio]"))
    public List<WebElement> radioButtonsList;

    public Map<String, WebElement> getFieldsLocated () {
        Map<String, WebElement>fieldsLocated = new HashMap<>();
        fieldsLocated.put("firstName", firstNameAtRegistrationForm);
        fieldsLocated.put("lastName", lastNameAtRegistrationForm);
        fieldsLocated.put("email", emailAtRegistrationForm);
        fieldsLocated.put("telephone", telephoneAtRegistrationForm);
        fieldsLocated.put("password", passwordAtRegistrationForm);
        fieldsLocated.put("passwordConfirm", passwordConfirmAtRegistrationForm);
        fieldsLocated.put("privacyPolicyCheckbox", PrivacyPolicyCheckbox);
        fieldsLocated.put("radioButtonSubscribeNo", radioButtonSubscribeNoAtRegistrationForm);
        return fieldsLocated;
    }

    public Map<String, WebElement> getAsteriskLocators () {
        Map<String, WebElement>asteriskLocators = new HashMap<>();
        asteriskLocators.put("firstName", firstNameForAsterisk);
        asteriskLocators.put("lastName", lastNameForAsterisk);
        asteriskLocators.put("email", emailForAsterisk);
        asteriskLocators.put("telephone", telephoneForAsterisk);
        asteriskLocators.put("password", passwordForAsterisk);
        asteriskLocators.put("passwordConfirm", passwordConfirmForAsterisk);
        return asteriskLocators;
    }

    public void clickRegisterAtHeader () {RegisterAtHeader.click();}

    public void enterFirstNameAtRegistrationForm(String firstName) {
        firstNameAtRegistrationForm.clear();
        firstNameAtRegistrationForm.sendKeys(firstName);
    }

    public void enterLastNameAtRegistrationForm(String lastName) {
        lastNameAtRegistrationForm.clear();
        lastNameAtRegistrationForm.sendKeys(lastName);
    }

    public void enterEmailAtRegistrationForm(String email) {
        emailAtRegistrationForm.clear();
        emailAtRegistrationForm.sendKeys(email);
    }

    public void enterTelephoneAtRegistrationForm(String telephone) {
        telephoneAtRegistrationForm.clear();
        telephoneAtRegistrationForm.sendKeys(telephone);
    }

    public void enterPasswordAtRegistrationForm(String password) {
        passwordAtRegistrationForm.clear();
        passwordAtRegistrationForm.sendKeys(password);
    }

    public void enterPasswordConfirmAtRegistrationForm(String passwordConfirm) {
        passwordConfirmAtRegistrationForm.clear();
        passwordConfirmAtRegistrationForm.sendKeys(passwordConfirm);
    }

    public void clickPrivacyPolicyCheckbox() {PrivacyPolicyCheckbox.click();}

    public void clickContinueAtRegistrationForm () {ContinueBtnAtRegistrationForm.click();}



}
