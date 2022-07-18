package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

public class General_PO {
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
    @FindBy(how = How.XPATH, using = "//*[@type='submit' and @value='Continue']")
    private WebElement ContinueButton;
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
    public WebElement GlobalWarning;
    @FindBy(how = How.XPATH, using = "//*[contains(@class,'alert-success')]")
    public WebElement GlobalSuccess;

    public void enterFirstName (String FName) {
        FirstName.clear();
        FirstName.sendKeys(FName);
    }
    public void enterLastName (String LName) {
        LastName.clear();
        LastName.sendKeys(LName);
    }
    public void enterEmail (String email) {
        Email.clear();
        Email.sendKeys(email);
    }
    public void enterTelephone (String telephone) {
        Telephone.clear();
        Telephone.sendKeys(telephone);
    }
    public void enterPassword (String password) {
        Password.clear();
        Password.sendKeys(password);
    }
    public void enterPassConfirm (String passConfirm) {
        PassConfirm.clear();
        PassConfirm.sendKeys(passConfirm);
    }
    public void clickContinueButton () {
        ContinueButton.click();
    }
    public List<String> getTextOfList (List<WebElement> list) {
        List<String> MyAccHeaders = new ArrayList<>();
        for (WebElement l : list) {
            String header = l.getText();
            MyAccHeaders.add(header);
        }
        return MyAccHeaders;
    }

    public String readMessageText (String messageName) {
        String message = null;
        switch (messageName) {
            case "First Name" :
                message = FirstNameWarning.getText();
                break;
            case "Last Name" :
                message = LastNameWarning.getText();
                break;
            case "E-Mail" :
                message = EmailWarning.getText();
                break;
            case "Telephone" :
                message = TelephoneWarning.getText();
                break;
            case "Password" :
                message = PasswordWarning.getText();
                break;
            case "Password Confirm" :
                message = PassConfirmWarning.getText();
                break;
            case "Policy" :
                message = GlobalWarning.getText();
                break;
            case "Success Update" :
                message = GlobalSuccess.getText();
                break;
        }
        return message;
    }
}
