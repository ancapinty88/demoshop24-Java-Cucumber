package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage_PO {
    @FindBy(how = How.XPATH, using = "//*[@class='dropdown-toggle' and @title='My Account']")
    private WebElement MyAccountDropdown;
    @FindBy(how = How.XPATH, using = "//*[contains(a,'Register')]")
    private WebElement MyAccountRegister;
    @FindBy(how = How.XPATH, using = "//*[contains(a,'Login')]")
    private WebElement MyAccountLogin;
    public String homePage() {
        return "http://www.demoshop24.com/";
    }

    public void clickMyAccountDropdown() {
        MyAccountDropdown.click();
    }

    public void clickMyAccountRegister() {
        MyAccountRegister.click();
    }

    public void clickMyAccountLogin() {
        MyAccountLogin.click();
    }
}
