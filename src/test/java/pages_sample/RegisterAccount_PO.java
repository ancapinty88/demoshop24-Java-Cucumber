package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class RegisterAccount_PO {
    @FindBy(how = How.ID, using = "input-firstname")
    public WebElement FirstName;
    @FindBy(how = How.ID, using = "input-lastname")
    public WebElement LastName;
    @FindBy(how = How.ID, using = "input-email")
    public WebElement Email;
    @FindBy(how = How.ID, using = "input-telephone")
    public WebElement Telephone;
    @FindBy(how = How.ID, using = "input-password")
    public WebElement Password;
    @FindBy(how = How.ID, using = "input-confirm")
    public WebElement PassConfirm;
    @FindBy(how = How.XPATH, using = "//*[@type='checkbox' and @name='agree']")
    private WebElement PolicyCheckbox;
    @FindBy(how = How.XPATH, using = "//*[@type='submit' and @value='Continue']")
    private WebElement ContinueButton;
    @FindBy(how = How.XPATH, using = "//div[@id='content']/h1")
    private WebElement ConfirmHeader;
    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'Subscribe')]")
    public WebElement Subscribe;
    @FindBy(how = How.XPATH, using = "//*[@class='radio-inline']/*[@type='radio' and @value='1']")
    public WebElement SubscribeYes;
    @FindBy(how = How.XPATH, using = "//*[@class='radio-inline']/*[@type='radio' and @value='0']")
    public WebElement SubscribeNo;
    @FindBy(how = How.XPATH, using = "//*[@class='text-danger' and contains(text(), 'First Name')]")
    public WebElement FirstNameWarning;
    @FindBy(how = How.XPATH, using = "//*[@class='text-danger' and contains(text(), 'Last Name')]")
    public WebElement LastNameWarning;
    @FindBy(how = How.XPATH, using = "//*[@class='text-danger' and contains(text(), 'E-Mail')]")
    public WebElement EmailWarning;
    @FindBy(how = How.XPATH, using = "//*[@class='text-danger' and contains(text(), 'Telephone')]")
    public WebElement TelephoneWarning;
    @FindBy(how = How.XPATH, using = "//*[@class='text-danger' and contains(text(), 'Password must')]")
    public WebElement PasswordWarning;
    @FindBy(how = How.XPATH, using = "//*[@class='text-danger' and contains(text(), 'Password conf')]")
    public WebElement PassConfirmWarning;
    @FindBy(how = How.XPATH, using = "//*[contains(@class,'alert-danger')]")
    public WebElement PolicyWarning;



    public String RegistrationConfirmPage() {
        return "http://www.demoshop24.com/index.php?route=account/success";
    }

    public void enterFirstName (String FName) throws Throwable {
        FirstName.sendKeys(FName);
    }

    public void enterLastName (String LName) throws Throwable {
        LastName.sendKeys(LName);
    }
    public void enterEmail (String email) throws Throwable {
        Email.sendKeys(email);
    }
    public void enterTelephone (String telephone) throws Throwable {
        Telephone.sendKeys(telephone);
    }
    public void enterPassword (String password) throws Throwable {
        Password.sendKeys(password);
    }
    public void enterPassConfirm (String passConfirm) throws Throwable {
        PassConfirm.sendKeys(passConfirm);
    }

    public void tickPolicyCheckbox () throws Throwable {
        PolicyCheckbox.click();
    }

    public void clickContinueButton () throws Throwable {
        ContinueButton.click();
    }

    public String readConfirmHeader () throws Throwable {
        return ConfirmHeader.getText();
    }

}
