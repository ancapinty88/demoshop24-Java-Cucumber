package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class EPIC01PersonalPage {

    @FindBy(how = How.CSS, using = "#top-links [href*='route=account/login']")
    private WebElement LoginAtHeader;
    @FindBy(how = How.ID, using = "input-email")
    private WebElement EmailToLogin;
    @FindBy(how = How.ID, using = "input-password")
    private WebElement PasswordToLogin;
    @FindBy(how = How.XPATH, using = "//input[@value='Login']")
    private WebElement LoginBtnUnderReturningCustomer;
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'My Account')]/following-sibling::ul[1]")
    public WebElement MyAccountBlock;
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'My Orders')]/following-sibling::ul[1]")
    public WebElement MyOrdersBlock;
    @FindBy(how = How.CSS, using = ".list-unstyled [href*='route=account/edit']")
    public WebElement EditAccountInfoLink;


    public void clickLoginAtHeader() {
        LoginAtHeader.click();
    }

    public void enterEmailToLogin(String email) {
        EmailToLogin.clear();
        EmailToLogin.sendKeys(email);
    }

    public void enterPasswordToLogin(String password) {
        PasswordToLogin.clear();
        PasswordToLogin.sendKeys(password);
    }

    public void clickLoginButtonUnderReturningCustomer() {
        LoginBtnUnderReturningCustomer.click();
    }


}