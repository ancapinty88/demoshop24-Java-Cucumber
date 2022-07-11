package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterAccount_PO {
    @FindBy(how = How.ID, using = "input-firstname")
    private WebElement FirstName;
    @FindBy(how = How.ID, using = "input-lastname")
    private WebElement LastName;
    @FindBy(how = How.ID, using = "input-email")
    private WebElement Email;
    @FindBy(how = How.ID, using = "input-telephone")
    private WebElement Telephone;
    @FindBy(how = How.ID, using = "input-password")
    private WebElement Password;
    @FindBy(how = How.ID, using = "input-confirm")
    private WebElement PassConfirm;
    @FindBy(how = How.XPATH, using = "//*[@type='checkbox' and @name='agree']")
    private WebElement PolicyCheckbox;
    @FindBy(how = How.XPATH, using = "//*[@type='submit' and @value='Continue']")
    private WebElement ContinueButton;
    @FindBy(how = How.XPATH, using = "//div[@id='content']/h1")
    private WebElement ConfirmHeader;

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
