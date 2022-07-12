package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage_PO {
    @FindBy(how = How.ID, using = "input-email")
    private WebElement EmailAddress;
    @FindBy(how = How.ID, using = "input-password")
    private WebElement Password;
    @FindBy(how = How.XPATH, using = "//*[@type='submit' and @value='Login']")
    private WebElement LoginButton;


    public String MyAccountPage() {
        return "http://www.demoshop24.com/index.php?route=account/account";
    }

    public void enterEmail (String email) throws Throwable {
        EmailAddress.sendKeys(email);
    }

    public void enterPassword (String password) throws Throwable {
        Password.sendKeys(password);
    }

    public void clickLoginButton () {
        LoginButton.click();
    }
}
