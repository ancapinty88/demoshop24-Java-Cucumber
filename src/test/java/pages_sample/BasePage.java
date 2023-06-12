package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BasePage {
    @FindBy(how = How.CSS, using = "#top-links [href*='route=account/account']")
    private WebElement headerAccountDropdown;
    @FindBy(how = How.CSS, using = "#top-links [href*='route=account/login']")
    private WebElement loginAtHeader;
    @FindBy(how = How.ID, using = "input-email")
    private WebElement emailToLogin;
    @FindBy(how = How.ID, using = "input-password")
    private WebElement passwordToLogin;
    @FindBy(how = How.XPATH, using = "//input[@value='Login']")
    private WebElement loginBtnUnderReturningCustomer;

    public String getPageUrl() {return "http://www.demoshop24.com/";}

    public void clickAccountIcon () {headerAccountDropdown.click();}

    public void clickLoginAtHeader() {
        loginAtHeader.click();
    }

    public void enterEmailToLogin(String email) {
        emailToLogin.clear();
        emailToLogin.sendKeys(email);
    }

    public void enterPasswordToLogin(String password) {
        passwordToLogin.clear();
        passwordToLogin.sendKeys(password);
    }

    public void clickLoginButtonUnderReturningCustomer() {
        loginBtnUnderReturningCustomer.click();
    }

}
