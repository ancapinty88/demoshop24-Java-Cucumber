package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BasePage {
    @FindBy(how = How.CSS, using = "#top-links [href*='route=account/account']")
    private WebElement headerAccountDropdown;
    @FindBy(how = How.CSS, using = "#top-links [href*='route=account/login']")
    private WebElement LoginAtHeader;
    @FindBy(how = How.ID, using = "input-email")
    private WebElement EmailToLogin;
    @FindBy(how = How.ID, using = "input-password")
    private WebElement PasswordToLogin;
    @FindBy(how = How.XPATH, using = "//input[@value='Login']")
    private WebElement LoginBtnUnderReturningCustomer;

    public String getPageUrl() {return "http://www.demoshop24.com/";}

    public void clickAccountIcon () {headerAccountDropdown.click();}

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
